package com.haoze.dental.controller.system;

import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.dental.model.system.ElementCatalogEntity;
import com.haoze.dental.model.system.IdsEntity;
import com.haoze.dental.service.system.ElementRelationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zj
 * @date 2018/12/6
 */
@RestController
@RequestMapping("/elementRelation")
@Validated
@Api(description = "数据元目录关系")
public class ElementRelationController {
    @Resource
    private ElementRelationService elementRelationService;

    /**
     * 数据元目录下加目录
     * @param listId
     * @return
     */
//    @PostMapping("/addDirectory")
//    @ApiOperation(value = "数据元目录下加目录")
//    public Result addDirectory(@RequestBody final IdsEntity listId) {
//        return this.elementRelationService.addDirectory(listId);
//    }

    /**
     * 数据元目录下加数据元
     * @param listId
     * @return
     */
    @PostMapping("/addElement")
    @ApiOperation(value = "数据元目录下加数据元")
    public Result addElement(@RequestBody final IdsEntity listId) {
        return this.elementRelationService.addElement(listId);
    }

    /**
     * 获取数据元目录树
     * @return
     */
    @GetMapping("/listTree")
    @ApiOperation(value = "获取数据元目录树")
    public Result listTree() {
        List<ElementCatalogEntity> List = elementRelationService.listTree();
        return ResultGenerator.genOkResult(List);
    }

}
