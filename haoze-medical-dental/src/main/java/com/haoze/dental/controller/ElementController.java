package com.haoze.dental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.dental.model.ElementEntity;
import com.haoze.dental.service.ElementService;

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
@RequestMapping("/element")
@Validated
@Api(description = "数据元")
public class ElementController {
    @Resource
    private ElementService elementService;

    /**
     * 数据元目录查询列表
     * @param page
     * @param size
     * @param queryString 查询条件
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "数据元查询列表", notes = "queryString可按名称、code")
    public Result list(@RequestParam(defaultValue = "1") final Integer page,
                       @RequestParam(defaultValue = "20") final Integer size,
                       @RequestParam(defaultValue = "") final String queryString) {
        PageHelper.startPage(page, size);
        final List<ElementEntity> list = this.elementService.listElement(queryString);
        final PageInfo<ElementEntity> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    /**
     * 数据元目录下拉列表
     * @return
     */
    @GetMapping("/listOptions")
    @ApiOperation(value = "数据元下拉列表", notes = "数据元实体类")
    public Result listOptions() {
        List<ElementEntity> List = this.elementService.listOptions();
        return ResultGenerator.genOkResult(List);
    }

    /**
     * 数据元目录保存
     * @param entity
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "数据元保存")
    public Result save(@RequestBody final ElementEntity entity) {
        return this.elementService.saveRange(entity);
    }

    /**
     * 数据元目录修改
     * @param entity
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "数据元修改")
    public Result update(@RequestBody final ElementEntity entity) {
        return elementService.updateRange(entity);
    }

    /**
     * 数据元目录删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "数据元删除")
    public Result delete(@PathVariable final String id) {
        return elementService.deleteRange(id);
    }

    /**
     * 数据元目录停止
     * @param id
     * @return
     */
    @GetMapping("/stop/{id}")
    @ApiOperation(value = "数据元停止")
    public Result stop(@PathVariable final String id) {
        return elementService.stopRange(id);
    }

    /**
     * 数据元目录启动
     * @param id
     * @return
     */
    @GetMapping("/start/{id}")
    @ApiOperation(value = "数据元启动")
    public Result start(@PathVariable final String id) {
        return elementService.startRange(id);
    }

    /**
     * 数据元是否有重复
     * @param entity
     * @return
     */
    @PostMapping("/hasName")
    @ApiOperation(value = "判断数据元是否有重复", notes = "参数：数据元实体类")
    public Result getInfoByName(@RequestBody final ElementEntity entity) {
        String id = entity.getElementId();
        String name = entity.getElementName();
        if ("".equals(name)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(ElementEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("elementName", name);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("elementId", id);
        }
        final List<ElementEntity> list = elementService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("名称已存在");
        }
    }
}
