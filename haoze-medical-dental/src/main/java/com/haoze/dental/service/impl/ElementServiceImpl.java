package com.haoze.dental.service.impl;

import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.UUIDUtil;
import com.haoze.dental.dao.ElementCatalogMapper;
import com.haoze.dental.dao.ElementMapper;
import com.haoze.dental.model.ElementCatalogEntity;
import com.haoze.dental.model.ElementEntity;
import com.haoze.dental.service.ElementService;

import org.apache.commons.lang3.StringUtils;
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
public class ElementServiceImpl extends AbstractService<ElementEntity> implements ElementService {
    @Resource
    private ElementMapper elementMapper;

    @Resource
    private ElementCatalogMapper elementCatalogMapper;

    @Override
    public List<ElementEntity> listElement(String queryString) {
        String parentIds = "";
        List<ElementEntity> list = this.elementMapper.listElement(queryString);
        for(int i = 0;i < list.size();i++){
            parentIds = "";
            if(elementMapper.getCount(list.get(i).getElementId()) > 0){
                List<ElementEntity> ListValue = elementMapper.getParentId(list.get(i).getElementId());
                for(int t = 0;t < ListValue.size();t++){
                    parentIds = parentIds + ListValue.get(t).getParentIds();
                    if(t < ListValue.size() - 1){
                        parentIds = parentIds + ",";
                    }
                }
                list.get(i).setParentIds(parentIds);
            }
        }
        return list;
    }

    @Override
    public List<ElementEntity> listOptions() {
        String parentIds = "";
        List<ElementEntity> list = this.elementMapper.listOptions();
        for(int i = 0;i < list.size();i++){
            parentIds = "";
            if(elementMapper.getCount(list.get(i).getElementId()) > 0){
                List<ElementEntity> ListValue = elementMapper.getParentId(list.get(i).getElementId());
                for(int t = 0;t < ListValue.size();t++){
                    parentIds = parentIds + ListValue.get(t).getParentIds();
                    if(t < ListValue.size() - 1){
                        parentIds = parentIds + ",";
                    }
                }
                list.get(i).setParentIds(parentIds);
            }
        }
        return list;
    }

    @Override
    public Result saveRange(ElementEntity role) {
        try {
            role.initAdd();
            role.setElementId(UUIDUtil.randomString());
            role.setPyCode(ChineseCharactersCode.getPinyinCode(role.getElementName()));
            role.setWbCode(ChineseCharactersCode.getWBCode(role.getElementName()));
            role.setElementCode("DE" + new SimpleDateFormat("yyyyMMddHHmmss") .format(new Date() ) + (int)((Math.random()*9+1)*100000));
            if(StringUtils.isBlank(role.getStopFlag())){
                role.setStopFlag("0");
            }
            elementMapper.saveRange(role);

            if(role.getParentIds() != ""||role.getParentIds() != null) {
                ElementCatalogEntity entity = new ElementCatalogEntity();
                entity.initAdd();
                entity.setDictionaryName(role.getElementName());
                entity.setElementId(role.getElementId());
                entity.setDictionaryType("2");
                entity.setStopFlag(role.getStopFlag());
                String [] list = role.getParentIds().split(",");
                for(int i = 0;i < list.length;i++) {
                    entity.setDictionaryCode("DED" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int) ((Math.random() * 9 + 1) * 100000));
                    entity.setDictionaryId(UUIDUtil.randomString());
                    entity.setParentId(list[i]);
                    elementCatalogMapper.saveRange(entity);
                }
            }

            return ResultGenerator.genOkResult("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("保存失败！");
        }
    }

    @Override
    public Result updateRange(ElementEntity role) {
        try {
            role.initUpdate();
            role.setPyCode(ChineseCharactersCode.getPinyinCode(role.getElementName()));
            role.setWbCode(ChineseCharactersCode.getWBCode(role.getElementName()));
            if(StringUtils.isBlank(role.getStopFlag())){
                role.setStopFlag("0");
            }
            elementMapper.updateRange(role);

            if(role.getParentIds() != ""||role.getParentIds() != null) {
                ElementCatalogEntity entity = new ElementCatalogEntity();
                entity.initUpdate();
                entity.setDictionaryName(role.getElementName());
                entity.setElementId(role.getElementId());
                entity.setStopFlag(role.getStopFlag());
                String [] list = role.getParentIds().split(",");
                for(int i = 0;i < list.length;i++) {
                    entity.setParentId(list[i]);
                    elementCatalogMapper.updateRangeValue(entity);
                }
            }

            return ResultGenerator.genOkResult("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("修改失败！");
        }
    }

    @Override
    public Result deleteRange(String id) {
        try {

            elementCatalogMapper.deleteRangeValue(id);
            elementMapper.deleteRange(id);
            return ResultGenerator.genOkResult("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("删除失败！");
        }
    }

    @Override
    public Result stopRange(String id) {
        try {
            elementCatalogMapper.stopRangeValue(id);
            elementMapper.stopRange(id);
            return ResultGenerator.genOkResult("停止成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("停止失败！");
        }
    }

    @Override
    public Result startRange(String id) {
        try {
            elementCatalogMapper.startRangeValue(id);
            elementMapper.startRange(id);
            return ResultGenerator.genOkResult("启用成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("启用失败！");
        }
    }
}
