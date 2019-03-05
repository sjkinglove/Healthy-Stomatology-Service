package com.haoze.dental.service.impl.system;

import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.UUIDUtil;
import com.haoze.dental.dao.system.ElementCatalogMapper;
import com.haoze.dental.model.system.ElementCatalogEntity;
import com.haoze.dental.service.system.ElementCatalogService;

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
public class ElementCatalogServiceImpl extends AbstractService<ElementCatalogEntity> implements ElementCatalogService {
    @Resource
    private ElementCatalogMapper elementCatalogMapper;

    @Override
    public List<ElementCatalogEntity> listDictionary(String queryString) {
        List<ElementCatalogEntity> list = this.elementCatalogMapper.listDictionary(queryString);
        return list;
    }

    @Override
    public List<ElementCatalogEntity> listOptions() {
        List<ElementCatalogEntity> list = this.elementCatalogMapper.listOptions();
        return list;
    }

    @Override
    public Result saveRange(ElementCatalogEntity role) {
        try {
            role.initAdd();
            role.setDictionaryId(UUIDUtil.randomString());
            role.setDictionaryCode("DED" + new SimpleDateFormat("yyyyMMddHHmmss") .format(new Date() ) + (int)((Math.random()*9+1)*100000));

            if(StringUtils.isBlank(role.getStopFlag())){
                role.setStopFlag("0");
            }
            elementCatalogMapper.saveRange(role);
            return ResultGenerator.genOkResult("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("保存失败！");
        }
    }

    @Override
    public Result updateRange(ElementCatalogEntity role) {
        try {
            role.initUpdate();
            if(StringUtils.isBlank(role.getStopFlag())){
                role.setStopFlag("0");
            }
            elementCatalogMapper.updateRange(role);
            return ResultGenerator.genOkResult("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("修改失败！");
        }
    }

    @Override
    public Result deleteRange(String id) {
        try {
            elementCatalogMapper.deleteRange(id);
            return ResultGenerator.genOkResult("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("删除失败！");
        }
    }

    @Override
    public Result stopRange(String id) {
        try {
            elementCatalogMapper.stopRange(id);
            return ResultGenerator.genOkResult("停止成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("停止失败！");
        }
    }

    @Override
    public Result startRange(String id) {
        try {
            elementCatalogMapper.startRange(id);
            return ResultGenerator.genOkResult("启用成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genOkResult("启用失败！");
        }
    }
}
