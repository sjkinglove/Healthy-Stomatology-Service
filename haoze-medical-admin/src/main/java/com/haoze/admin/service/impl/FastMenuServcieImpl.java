package com.haoze.admin.service.impl;

import com.haoze.admin.core.Status;
import com.haoze.admin.dto.system.FastMenuDTO;
import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.mapper.FastMenuMapper;
import com.haoze.admin.mapper.UserMapper;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.admin.service.FastMenuServcie;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.HttpContextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenjun
 * @date 2019/02/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FastMenuServcieImpl extends AbstractService<FastMenuEntity> implements FastMenuServcie {

    @Resource
    private FastMenuMapper fastMenuMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 根据IDs批量删除快速通道
     * */
    @Override
    public void deleteByIds(String ids) {

        if (ids!=null&&!"".equals(ids)) {
            if(ids.contains("\'")||ids.contains("\"")){
                fastMenuMapper.deleteByIds(ids);
            }else{
                String[] idArry = ids.split(",");

                StringBuffer sb = new StringBuffer();

                for(String fastMenuId:idArry){
                   sb.append("\'").append(fastMenuId).append("\'").append(",");
                }
                //移除末尾逗号
                sb.deleteCharAt(sb.length() - 1);

                fastMenuMapper.deleteByIds(sb.toString());
            }
        }

    }

    /**
     * 根据roleID获取快速通道
     * */
    @Override
    public List<FastMenuEntity> listByRoleId(String id) {

        Condition condition = new Condition(FastMenuEntity.class);
        //按序号升序排列
        condition.setOrderByClause("FAST_MENU_SORT ASC");

        Example.Criteria criteria = condition.createCriteria();
        //根据用户ID查询
        criteria.andEqualTo("trId", id);

        final List<FastMenuEntity> list = fastMenuMapper.selectByCondition(condition);
        return list;
    }

    /**
     * 多条件查询快速通道
     * */
    @Override
    public List<FastMenuEntity> listByQuery(FastMenuDTO entity) {

        Condition condition = new Condition(FastMenuEntity.class);
        //升序
        condition.setOrderByClause("FAST_MENU_SORT ASC");

        Example.Criteria criteria = condition.createCriteria();

        criteria.andEqualTo("trId", entity.getTrId());
        //查询条件fastMenuName快捷通道名
        if(entity.getFastMenuName()!=null){criteria.andEqualTo("fastMenuName", "%"+entity.getFastMenuName()+"%");}
        //查询条件fastMenuSort序号
        if(entity.getFastMenuSort()!=null){criteria.andEqualTo("fastMenuSort", "%"+entity.getFastMenuSort()+"%");}
        //查询条件remark备注
        if(entity.getRemark()!=null){criteria.andEqualTo("remark", "%"+entity.getRemark()+"%");}

        final List<FastMenuEntity> list = fastMenuMapper.selectByCondition(condition);

        return list;
    }

    /**
     * 首页快速通道列表
     * */
    @Override
    public List<FastMenuDTO> list(String id) {

        List<FastMenuDTO> list=fastMenuMapper.list(id);

        return list;
    }

    @Override
    public void updateStopFlagById(String id, String stopFlag) {
        fastMenuMapper.updateStopFlagById(id, stopFlag);
    }

    /**
     * 保存
     * */
    @Override
    public void saveFastMenu(FastMenuEntity entity) {
        //更新其他快速通道序号
        fastMenuMapper.updateSortNoForEnlarge(entity.getFastMenuSort());
        //点击次数初始设置为0
        entity.setClickNum(Integer.valueOf(Status.INIT_CLICK_NUM.getValue()));
        //根据用户名获取账号
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String account = request.getHeader("zuul_account");
        UserDTO userDTO = userMapper.findUserRelWithLoginName(account);
        //保存用户所在机构ID
        entity.setToId(userDTO.getToId());

        fastMenuMapper.insertFastMenu(entity);
    }
    /**
     * 更新
     * */
    @Override
    public void updateFastMenu(FastMenuEntity entity) {
        //更新其他快速通道序号
        fastMenuMapper.updateSortNoForEnlarge(entity.getFastMenuSort());

        fastMenuMapper.updateSortNoForReduce(entity.getFastMenuSort());

        fastMenuMapper.updateFastMenu(entity);
    }


}
