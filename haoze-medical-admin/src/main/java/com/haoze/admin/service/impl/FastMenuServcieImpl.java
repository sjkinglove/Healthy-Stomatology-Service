package com.haoze.admin.service.impl;

import com.haoze.admin.core.Status;
import com.haoze.admin.dto.system.FastMenuDTO;
import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.mapper.FastMenuMapper;
import com.haoze.admin.mapper.MenuMapper;
import com.haoze.admin.mapper.UserMapper;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.admin.service.FastMenuServcie;
import com.haoze.common.exception.ServiceException;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.HttpContextUtils;
import com.haoze.common.utils.UUIDUtil;
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
    @Resource
    private MenuMapper menuMapper;

    /**
     * 根据IDs批量删除快速通道
     * */
    @Override
    public void deleteByIds(String ids) {
        //判断拼接字符串有没有加引号
        if (ids!=null&&!"".equals(ids)) {
            if(ids.contains("\'")||ids.contains("\"")){
                String[] idArry = ids.split(",");

                for(String fastMenuId:idArry){

                    String currentSortNo = fastMenuMapper.getFastMenuSortById(fastMenuId);

                    Map<String, Object> map = new HashMap<>();
                    map.put("currentSortNo", currentSortNo);

                    fastMenuMapper.updateSortNoForReduce(map);

                }

                fastMenuMapper.deleteByIds(ids);
            }else{
                String[] idArry = ids.split(",");

                StringBuffer sb = new StringBuffer();

                for(String fastMenuId:idArry){
                   sb.append("\'").append(fastMenuId).append("\'").append(",");

                    String currentSortNo = fastMenuMapper.getFastMenuSortById(fastMenuId);

                    Map<String, Object> map = new HashMap<>();
                    map.put("currentSortNo", currentSortNo);

                    fastMenuMapper.updateSortNoForReduce(map);

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
        //根据角色ID查询
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
     * 保存新增
     * */
    @Override
    public void saveFastMenu(FastMenuDTO entity) {

        //更新其他快速通道序号
        Map<String, Object> map = new HashMap<>();
        map.put("targetSortNo", entity.getFastMenuSort());
        fastMenuMapper.updateSortNoForEnlarge(map);

        FastMenuEntity fastMenuEntity =new FastMenuEntity();

        UserDTO userDTO = userMapper.findUserRelWithUserId(entity.getTuId());

        if(userDTO != null){
            //保存用户所在机构ID
            fastMenuEntity.setToId(userDTO.getToId());
        }else{
            throw new ServiceException("查无此账号");
        }

        if(fastMenuEntity.getTrId()==null||"".equals(fastMenuEntity.getTrId())){fastMenuEntity.setTrId(userDTO.getRoleId());}
        //快捷菜单名
        fastMenuEntity.setFastMenuName(entity.getFastMenuName());
        //排序
        fastMenuEntity.setFastMenuSort(entity.getFastMenuSort());
        //备注
        fastMenuEntity.setRemark(entity.getRemark());
        //开启状态
        fastMenuEntity.setOpenState(entity.getOpenState());
        //菜单ID
        fastMenuEntity.setTmId(entity.getTmId());
        //角色ID
        fastMenuEntity.setTrId(entity.getTrId());
        //点击次数初始设置为0
        fastMenuEntity.setClickNum(Integer.valueOf(Status.INIT_CLICK_NUM.getValue()));

        Map<String,String> menuMap =menuMapper.selectCompleteMenuUrlByMenuId(fastMenuEntity.getTmId());
        fastMenuEntity.setFastMenuUrl(menuMap.get("menuUrl"));

        fastMenuEntity.setFastMenuType(menuMap.get("menuType"));


        //快速菜单主键ID
        fastMenuEntity.setTfmId(UUIDUtil.randomString());

        fastMenuEntity.initAdd();

        fastMenuMapper.insertFastMenu(fastMenuEntity);



    }
    /**
     * 更新
     * */
    @Override
    public void updateFastMenu(FastMenuEntity entity) {
        //目标序号
        int targetSortNo = Integer.valueOf(entity.getFastMenuSort());
        //当前序号
        int currentSortNo = Integer.valueOf(fastMenuMapper.getFastMenuSortById(entity.getTfmId()));

        Map<String, Object> map = new HashMap<>();
        map.put("targetSortNo", targetSortNo);
        map.put("currentSortNo", currentSortNo);

        //更新其他快速通道序号
        if(targetSortNo > currentSortNo){
            fastMenuMapper.updateSortNoForReduce(map);
        }else if(targetSortNo < currentSortNo){
            fastMenuMapper.updateSortNoForEnlarge(map);
        }

        Map<String,String> menuMap =menuMapper.selectCompleteMenuUrlByMenuId(entity.getTmId());
        entity.setFastMenuUrl(menuMap.get("menuUrl"));

        entity.setFastMenuType(menuMap.get("menuType"));

        fastMenuMapper.updateFastMenu(entity);
    }

}
