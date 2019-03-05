package com.haoze.dental.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.UUIDUtil;
import com.haoze.dental.dto.DataSetDTO;
import com.haoze.dental.model.system.DataSetDetailEntity;
import com.haoze.dental.model.system.DataSetEntity;
import com.haoze.dental.service.system.DataSetDetailService;
import com.haoze.dental.service.system.DataSetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据集管理controller
 * @author fcx
 * @date 2019年2月19日09:22:15
 */
@RestController
@RequestMapping("/data/set")
@Validated
@Api(description = "数据集")
public class DataSetController {

    @Resource
    private DataSetService dataSetService;

    @Resource
    private DataSetDetailService dataSetDetailService;

    @GetMapping("/list")
    @ApiOperation(value = "数据集列表", notes = "queryString可按名称查询")
    public Result list(@RequestParam(defaultValue = "0") final Integer page,
                       @RequestParam(defaultValue = "0") final Integer size,
                       @RequestParam(defaultValue = "") final String queryString) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(DataSetEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtil.isNotEmpty(queryString)) {
            criteria.andLike("datasetName", "%" + queryString + "%");
        }
        final List<DataSetEntity> list = this.dataSetService.findByCondition(condition);
        final PageInfo<DataSetEntity> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    @PostMapping("/save")
    @ApiOperation(value = "数据集新增")
    public Result add(@RequestBody final DataSetDTO dataSetDTO) {
        return dataSetService.saveDto(dataSetDTO);
    }

    @PutMapping("/update")
    @ApiOperation(value = "数据集修改")
    public Result update (@RequestBody final DataSetDTO dataSetDTO) {
        return dataSetService.updateDto(dataSetDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "数据集删除")
    public Result delete(@PathVariable final String id) {

        this.dataSetService.deleteByIds(id);
        return ResultGenerator.genOkResult("删除成功");
    }

    @PostMapping("/hasName")
    @ApiOperation(value = "判断数据集名称是否重复")
    public Result getInfoByName(@RequestBody final DataSetEntity entity) {
        String name = entity.getDatasetName();
        String id = entity.getDatasetId();
        if ("".equals(name)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(DataSetEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("datasetName", name);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("datasetId", id);
        }
        final List<DataSetEntity> list = dataSetService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("数据集名称已存在");
        }
    }

    @GetMapping("/listAllDataSet")
    @ApiOperation(value = "数据集树形列表")
    public Result listAllDataSet (){
        final List<DataSetDTO> list = this.dataSetService.listAllDataSet();
        return ResultGenerator.genOkResult(list);
    }

    @PostMapping("/quoteDataElement")
    @ApiOperation(value = "引用数据元", notes = "先验证引用的数据元是否重复")
    public Result quoteDataElement (@RequestBody final List<DataSetDetailEntity> entities) {
        for (DataSetDetailEntity detail : entities) {
            // 判断是否引用相同数据元
            Condition condition = new Condition(DataSetDetailEntity.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("datasetId", detail.getDatasetId());
            criteria.andEqualTo("elementId", detail.getElementId());
            int count = this.dataSetDetailService.countByCondition(condition);
            if (count > 0) {
                return ResultGenerator.genFailedResult("请勿引用相同数据元");
            }
            // 验证无重复则新增
            detail.initAdd();
            detail.setDatasetdetailId(UUIDUtil.randomString());
            this.dataSetDetailService.save(detail);
        }
        return ResultGenerator.genOkResult("引用成功");
    }

    @PostMapping("/deleteDetail/{datasetId}")
    @ApiOperation(value = "删除引用的数据元")
    public Result deleteDetail (@PathVariable String datasetId) {
        this.dataSetDetailService.deleteById(datasetId);
        return ResultGenerator.genOkResult("删除成功");
    }
}
