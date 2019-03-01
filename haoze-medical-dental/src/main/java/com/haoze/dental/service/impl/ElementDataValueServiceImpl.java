package com.haoze.dental.service.impl;

import com.haoze.common.service.AbstractService;
import com.haoze.dental.dao.ElementDataValueMapper;
import com.haoze.dental.model.PrimaryValueEntity;
import com.haoze.dental.service.ElementDataValueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ElementDataValueServiceImpl extends AbstractService<PrimaryValueEntity> implements ElementDataValueService {
    @Resource
    private ElementDataValueMapper elementDataValueMapper;

    public List<PrimaryValueEntity> listValue(String rangeId) {
        return elementDataValueMapper.listValue(rangeId);
    }

}
