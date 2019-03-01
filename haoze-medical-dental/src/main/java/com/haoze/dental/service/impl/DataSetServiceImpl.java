package com.haoze.dental.service.impl;

import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.UUIDUtil;
import com.haoze.dental.dao.DataSetDetailMapper;
import com.haoze.dental.dao.DataSetMapper;
import com.haoze.dental.dto.DataSetDTO;
import com.haoze.dental.model.DataSetDetailEntity;
import com.haoze.dental.model.DataSetEntity;
import com.haoze.dental.service.DataSetService;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 数据集service实现
 * @author fcx
 * @date 2019年2月19日09:17:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DataSetServiceImpl extends AbstractService<DataSetEntity> implements DataSetService {

    @Resource
    private DataSetMapper dataSetMapper;
    @Resource
    private DataSetDetailMapper dataSetDetailMapper;

    @Override
    public Result saveDto (DataSetDTO dataSetDTO) {
        try {
            dataSetDTO.getDataSetEntity().initAdd();
            dataSetDTO.getDataSetEntity().setDatasetId(UUIDUtil.randomString());
            // TODO 数据集code
            dataSetDTO.getDataSetEntity().setDatasetCode("DS" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int)((Math.random()*9+1)*100000));
            dataSetDTO.getDataSetEntity().setPyCode(ChineseCharactersCode.getPinyinCode(dataSetDTO.getDataSetEntity().getDatasetName()));
            dataSetDTO.getDataSetEntity().setWbCode(ChineseCharactersCode.getWBCode(dataSetDTO.getDataSetEntity().getDatasetName()));
            this.dataSetMapper.insert(dataSetDTO.getDataSetEntity());
            for (DataSetDetailEntity detail : dataSetDTO.getDataSetDetailEntities()) {
                detail.initAdd();
                detail.setDatasetdetailId(UUIDUtil.randomString());
                detail.setDatasetId(dataSetDTO.getDataSetEntity().getDatasetId());
                this.dataSetDetailMapper.insert(detail);
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return ResultGenerator.genOkResult("保存成功");
    }

    @Override
    public Result updateDto (DataSetDTO dataSetDTO) {
        try {
            //先删除子集
            Condition condition = new Condition(DataSetDetailEntity.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("datasetId", dataSetDTO.getDataSetEntity().getDatasetId());
            this.dataSetDetailMapper.deleteByCondition(condition);
            //再更新主表信息，新增子表信息
            dataSetDTO.getDataSetEntity().initUpdate();
            dataSetDTO.getDataSetEntity().setPyCode(ChineseCharactersCode.getPinyinCode(dataSetDTO.getDataSetEntity().getDatasetName()));
            dataSetDTO.getDataSetEntity().setWbCode(ChineseCharactersCode.getWBCode(dataSetDTO.getDataSetEntity().getDatasetName()));
            this.dataSetMapper.updateByPrimaryKeySelective(dataSetDTO.getDataSetEntity());
            for (DataSetDetailEntity detail : dataSetDTO.getDataSetDetailEntities()) {
                detail.initAdd();
                detail.setDatasetdetailId(UUIDUtil.randomString());
                detail.setDatasetId(dataSetDTO.getDataSetEntity().getDatasetId());
                this.dataSetDetailMapper.insert(detail);
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return ResultGenerator.genOkResult("修改成功");
    }

    @Override
    public List<DataSetDTO> listAllDataSet () {
        return this.dataSetMapper.listAllDataSet();
    }

}
