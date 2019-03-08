package com.haoze.dental.service.impl;

import com.haoze.common.service.AbstractService;
import com.haoze.dental.dao.PersonMapper;
import com.haoze.dental.dto.PersonDTO;
import com.haoze.dental.model.PersonEntity;
import com.haoze.dental.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shenjun
 * @date 2019/3/5
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PersonServiceImpl extends AbstractService<PersonEntity> implements PersonService {

    @Resource
    PersonMapper personMapper;

    @Override
    public List<PersonEntity> getListByQuery(PersonDTO entity){

        Condition condition = new Condition(PersonEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        //判断是临时档案还是正式档案
        if(entity.getDocType() != null && "".equals(entity.getDocType())){
            criteria.andEqualTo("docType",entity.getDocType());
        }
        if(entity.getAreaName() != null && !"".equals(entity.getAreaName())){
            criteria.andLike("areaName", "%" + entity.getAreaName() + "%");
        }
        if(entity.getSchoolName() != null && !"".equals(entity.getSchoolName())){
            criteria.andLike("schoolName", "%" + entity.getSchoolName() + "%");
        }
        if(entity.getGradeName() != null && !"".equals(entity.getGradeName())){
            criteria.andLike("gradeName", "%" + entity.getGradeName() + "%");
        }
        if(entity.getClassName() != null && !"".equals(entity.getClassName())){
            criteria.andLike("className", "%" + entity.getClassName() + "%");
        }
        if(entity.getPersonName() != null && !"".equals(entity.getPersonName())){
            criteria.andLike("personName", "%" + entity.getPersonName() + "%");
        }
        if(entity.getStartTime() != null && !"".equals(entity.getStartTime())){
            criteria.andGreaterThan("createTime",entity.getStartTime()).orEqualTo("createTime",entity.getStartTime());
        }
        if(entity.getEndTime() != null && !"".equals(entity.getEndTime())){
            criteria.andLessThan("createTime",entity.getEndTime()).orEqualTo("createTime",entity.getEndTime());
        }
        final List<PersonEntity> list = personMapper.selectByCondition(condition);

        return list;
    }


}
