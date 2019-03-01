package com.haoze.dental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.dental.dao.ElementValueMapper;
import com.haoze.dental.dto.ElementValueDTO;
import com.haoze.dental.model.ElementValueEntity;
import com.haoze.dental.model.PrimaryValueEntity;
import com.haoze.dental.service.ElementDataValueService;
import com.haoze.dental.service.ElementValueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
@RestController
@RequestMapping("/elementValue")
@Validated
@Api(description = "值域，值内容")
public class ElementValueController {
    @Resource
    private ElementValueMapper elementValueMapper;

    @Resource
    private ElementValueService elementValueService;

    @Resource
    private ElementDataValueService elementDataValueService;

    /**
     * 值域内容查询列表
     * @param page
     * @param size
     * @param queryString 查询条件
     * @return
     */
    @GetMapping("/listRange")
    @ApiOperation(value = "值域内容列表", notes = "queryString可按名称、拼音码、五笔码查询")
    public Result listRange(@RequestParam(defaultValue = "0") final Integer page,
                            @RequestParam(defaultValue = "0") final Integer size,
                            @RequestParam(defaultValue = "") final String queryString) {
        PageHelper.startPage(page, size);
        final List<ElementValueEntity> list = this.elementValueService.listDictionary(queryString);
        final PageInfo<ElementValueEntity> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    /**
     * 值域对应值下拉列表
     * @param rangeId
     * @return
     */
    @GetMapping("/listValue/{rangeId}")
    @ApiOperation(value = "值域对应值下拉列表", notes = "参数：值域主键id")
    public Result listValue(@PathVariable final String rangeId) {
        List<PrimaryValueEntity> List = this.elementDataValueService.listValue(rangeId);
        return ResultGenerator.genOkResult(List);
    }

    /**
     * 值域内容下拉列表
     * @return
     */
    @GetMapping("/listRangeOptions")
    @ApiOperation(value = "值域内容下拉列表", notes = "")
    public Result listRangeOptions() {
        List<ElementValueEntity> List = this.elementValueService.listRangeOptions();
        return ResultGenerator.genOkResult(List);
    }

    /**
     * 值域内容，值保存
     * @param role
     * @return
     */
    @PostMapping("/saveRange")
    @ApiOperation(value = "值域内容，值保存", notes = "参数：值域dto")
    public Result saveRange(@RequestBody final ElementValueDTO role) {
        return elementValueService.saveRange(role);
    }

    /**
     * 值域内容，值修改
     * @param role
     * @return
     */
    @PutMapping("/updateRange")
    @ApiOperation(value = "值域内容，值修改", notes = "参数：值域dto")
    public Result updateRange(@RequestBody final ElementValueDTO role) {
        return elementValueService.updateRange(role);
    }

    /**
     * 值域内容，值删除
     * @param rangeId
     * @return
     */
    @DeleteMapping("/deleteRange/{rangeId}")
    @ApiOperation(value = "值域内容，值删除", notes = "参数：值域主键")
    public Result deleteRange(@PathVariable final String rangeId) {
        return elementValueService.deleteRange(rangeId);
    }

    /**
     * 值域停止使用
     * @param rangeId
     * @return
     */
    @GetMapping("/stopRange")
    @ApiOperation(value = "值域停止使用", notes = "参数：值域主键")
    public Result stopRange(@RequestParam(defaultValue = "") final String rangeId) {
        return elementValueService.stopRange(rangeId);
    }

    /**
     * 值域启动使用
     * @param rangeId
     * @return
     */
    @GetMapping("/startRange")
    @ApiOperation(value = "值域启动使用", notes = "参数：值域主键")
    public Result startRange(@RequestParam(defaultValue = "") final String rangeId) {
        return elementValueService.startRange(rangeId);
    }

    /**
     * 判断值域是否有重复
     * @param entity
     * @return
     */
    @PostMapping("/hasName")
    @ApiOperation(value = "判断值域是否有重复", notes = "参数：值域dto")
    public Result getInfoByName(@RequestBody final ElementValueEntity entity) {
        String name = entity.getPrimaryDataName();
        String id = entity.getPrimaryDataId();
        if ("".equals(name)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(ElementValueEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("primaryDataName", name);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("primaryDataId", id);
        }
        final List<ElementValueEntity> list = elementValueService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("名称已存在");
        }
    }
}
