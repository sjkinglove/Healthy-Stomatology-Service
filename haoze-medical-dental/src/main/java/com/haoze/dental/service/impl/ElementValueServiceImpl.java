package com.haoze.dental.service.impl;

import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.UUIDUtil;
import com.haoze.dental.dao.ElementValueMapper;
import com.haoze.dental.dto.ElementValueDTO;
import com.haoze.dental.model.ElementValueEntity;
import com.haoze.dental.model.PrimaryValueEntity;
import com.haoze.dental.service.ElementValueService;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
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
public class ElementValueServiceImpl extends AbstractService<ElementValueEntity> implements ElementValueService {
    @Resource
    private ElementValueMapper elementValueMapper;

    public List<ElementValueEntity> listDictionary(String queryString) {
        return elementValueMapper.listDictionary(queryString);
    }

    public List<ElementValueEntity> listRangeOptions() {
        return elementValueMapper.listRangeOptions();
    }

    public Result saveRange(ElementValueDTO role) {
        try {
            role.setPrimaryDataId(UUIDUtil.randomString());
            role.setGmtCreate(new Date());
            role.setDataVersion("1.0");
            role.setHospitalId("常州二院");
            role.setPrimaryDataCode("PD" + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() ));
            role.setPyCode(ChineseCharactersCode.getPinyinCode(role.getPrimaryDataName()));
            role.setWbCode(ChineseCharactersCode.getWBCode(role.getPrimaryDataName()));
            this.elementValueMapper.saveRange(role);
            List<PrimaryValueEntity> List = role.getValueList();
            int length = List.size();
            for(int i = 0;i < length;i++){
                if(List.get(i).getDatavalueId() == ""||List.get(i).getDatavalueId() == null){
                    List.get(i).setDatavalueId(UUIDUtil.randomString());
                    List.get(i).setGmtCreate(new Date());
                    List.get(i).setHospitalId("常州二院");
                    List.get(i).setDataVersion("1.0");
                    List.get(i).setPrimaryDataId(role.getPrimaryDataId());
                    List.get(i).setDataValue("PDV" + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() ));
                    List.get(i).setPyCode(ChineseCharactersCode.getPinyinCode(List.get(i).getDataValueRemark()));
                    List.get(i).setWbCode(ChineseCharactersCode.getWBCode(List.get(i).getDataValueRemark()));
                    elementValueMapper.saveRangeValue(List.get(i));
                }else{
                    List.get(i).setGmtModify(new Date());
                    List.get(i).setHospitalId("常州二院");
                    List.get(i).setDataVersion("1.0");
                    List.get(i).setPrimaryDataId(role.getPrimaryDataId());
                    List.get(i).setDataValue("PDV" + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() ));
                    List.get(i).setPyCode(ChineseCharactersCode.getPinyinCode(List.get(i).getDataValueRemark()));
                    List.get(i).setWbCode(ChineseCharactersCode.getWBCode(List.get(i).getDataValueRemark()));
                    this.elementValueMapper.updateRangeValue(List.get(i));
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return ResultGenerator.genOkResult();
    }

    public Result updateRange(ElementValueDTO role) {
        try {
            role.setGmtModify(new Date());
            role.setDataVersion("1.0");
            role.setHospitalId("常州二院");
            role.setPrimaryDataCode("PD" + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() ));
            role.setPyCode(ChineseCharactersCode.getPinyinCode(role.getPrimaryDataName()));
            role.setWbCode(ChineseCharactersCode.getWBCode(role.getPrimaryDataName()));
            this.elementValueMapper.updateRange(role);
            elementValueMapper.deleteRangeValue(role.getPrimaryDataId());
            List<PrimaryValueEntity> List = role.getValueList();
            int length = List.size();
            for(int i = 0;i < length;i++){
                if(List.get(i).getDatavalueId() == ""||List.get(i).getDatavalueId() == null){
                    List.get(i).setDatavalueId(UUIDUtil.randomString());
                    List.get(i).setGmtCreate(new Date());
                    List.get(i).setHospitalId("常州二院");
                    List.get(i).setDataVersion("1.0");
                    List.get(i).setPrimaryDataId(role.getPrimaryDataId());
                    List.get(i).setDataValue("PDV" + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() ));
                    List.get(i).setPyCode(ChineseCharactersCode.getPinyinCode(List.get(i).getDataValueRemark()));
                    List.get(i).setWbCode(ChineseCharactersCode.getWBCode(List.get(i).getDataValueRemark()));
                    elementValueMapper.saveRangeValue(List.get(i));
                }else{
                    List.get(i).setGmtModify(new Date());
//                    List.get(i).setHospitalId("常州二院");
//                    List.get(i).setDataVersion("1.0");
//                    List.get(i).setPrimaryDataId(role.getPrimaryDataId());
//                    List.get(i).setDataValue("PDV" + new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() ));
                    List.get(i).setPyCode(ChineseCharactersCode.getPinyinCode(List.get(i).getDataValueRemark()));
                    List.get(i).setWbCode(ChineseCharactersCode.getWBCode(List.get(i).getDataValueRemark()));
                    this.elementValueMapper.saveRangeValue(List.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genOkResult();
    }

    public Result deleteRange(String rangeId) {
        try {
            elementValueMapper.deleteRange(rangeId);
            elementValueMapper.deleteRangeValue(rangeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genOkResult();
    }

    public Result stopRange(String rangeId) {
        try {
            elementValueMapper.stopRange(rangeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genOkResult();
    }

    public Result startRange(String rangeId) {
        try {
            elementValueMapper.startRange(rangeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genOkResult();
    }
}
