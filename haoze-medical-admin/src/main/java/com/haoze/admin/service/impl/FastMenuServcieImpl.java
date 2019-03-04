package com.haoze.admin.service.impl;

import com.haoze.admin.core.Status;
import com.haoze.admin.dto.system.FastMenuDTO;
import com.haoze.admin.mapper.FastMenuMapper;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.admin.service.FastMenuServcie;
import com.haoze.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shenjun
 * @date 2019/02/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FastMenuServcieImpl extends AbstractService<FastMenuEntity> implements FastMenuServcie {

    @Resource
    private FastMenuMapper fastMenuMapper;

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

    @Override
    public List<FastMenuEntity> listByUserId(String id) {

        Condition condition = new Condition(FastMenuEntity.class);

        condition.setOrderByClause("FAST_MENU_SORT ASC");

        Example.Criteria criteria = condition.createCriteria();

        criteria.andEqualTo("tuId", id);

        final List<FastMenuEntity> list = fastMenuMapper.selectByCondition(condition);
        return list;
    }

    @Override
    public List<FastMenuEntity> listByQuery(FastMenuDTO entity) {

        Condition condition = new Condition(FastMenuEntity.class);
        //升序
        condition.setOrderByClause("FAST_MENU_SORT ASC");

        Example.Criteria criteria = condition.createCriteria();

        criteria.andEqualTo("tuId", entity.getTuId());
        //查询条件fastMenuName快捷通道名
        if(entity.getFastMenuName()!=null){criteria.andEqualTo("fastMenuName", "%"+entity.getFastMenuName()+"%");}
        //查询条件fastMenuSort序号
        if(entity.getFastMenuSort()!=null){criteria.andEqualTo("fastMenuSort", "%"+entity.getFastMenuSort()+"%");}
        //查询条件remark备注
        if(entity.getRemark()!=null){criteria.andEqualTo("remark", "%"+entity.getRemark()+"%");}

        final List<FastMenuEntity> list = fastMenuMapper.selectByCondition(condition);

        return list;
    }

    @Override
    public List<FastMenuDTO> list(String id) {

        List<FastMenuDTO> list=fastMenuMapper.list(id);

        return list;
    }

    @Override
    public void saveFastMenu(FastMenuEntity entity) {

        fastMenuMapper.updateSortNoForEnlarge(entity.getFastMenuSort());//更新其他快速通道序号

        entity.setClickNum(Integer.valueOf(Status.INIT_CLICK_NUM.getValue()));//点击次数初始设置为0

        fastMenuMapper.insertFastMenu(entity);
    }

    @Override
    public void updateFastMenu(FastMenuEntity entity) {

        fastMenuMapper.updateSortNoForEnlarge(entity.getFastMenuSort());//更新其他快速通道序号

        fastMenuMapper.updateFastMenu(entity);
    }

    public void deleteById(String ids){

        fastMenuMapper.deleteByIds(ids);

    }

}
