package com.haoze.dental.service.impl;

import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.UUIDUtil;
import com.haoze.dental.dao.ElementCatalogMapper;
import com.haoze.dental.dao.ElementMapper;
import com.haoze.dental.model.ElementCatalogEntity;
import com.haoze.dental.model.ElementEntity;
import com.haoze.dental.model.IdsEntity;
import com.haoze.dental.service.ElementRelationService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ElementRelationImpl extends AbstractService<ElementCatalogEntity> implements ElementRelationService {
    @Resource
    private ElementCatalogMapper elementCatalogMapper;

    @Resource
    private ElementMapper elementMapper;

    @Override
    public Result addDirectory(IdsEntity listId) {
        try {
            elementCatalogMapper.addDirectory(listId);
            return ResultGenerator.genOkResult("执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("执行失败！");
        }
    }

    @Override
    public Result addElement(IdsEntity listId) {
        try {
            ElementEntity entity = new ElementEntity();
            entity = elementMapper.getList(listId.getId()).get(0);
            ElementCatalogEntity elementEntity = new ElementCatalogEntity();
            elementEntity.setElementId(listId.getId());
            elementEntity.setStopFlag("0");
            elementEntity.setDictionaryType("2");
            elementEntity.setParentId(listId.getParentId());
            elementEntity.setDictionaryName(entity.getElementName());
            elementEntity.initAdd();
            elementEntity.setDictionaryId(UUIDUtil.randomString());
            elementEntity.setDictionaryCode("DED" + new SimpleDateFormat("yyyyMMddHHmmss") .format(new Date() ) + (int)((Math.random()*9+1)*100000));
            int sortNo = elementCatalogMapper.getCount(listId.getParentId());
            elementEntity.setSortNo(sortNo + 1);

            elementCatalogMapper.saveRange(elementEntity);
            return ResultGenerator.genOkResult("执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("执行失败！");
        }
    }

    @Override
    public List<ElementCatalogEntity> listTree() {
        List<ElementCatalogEntity> listTree = this.elementCatalogMapper.listTree();
        return listTree;
    }
}
