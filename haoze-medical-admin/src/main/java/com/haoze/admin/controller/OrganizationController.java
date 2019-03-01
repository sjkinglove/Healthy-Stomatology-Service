package com.haoze.admin.controller;

import com.haoze.admin.model.TOrganization;
import com.haoze.admin.service.OrganizationService;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author yangyb
 * @date 2018/12/6
 */
@RestController
@RequestMapping("/system/department")
@Validated
@Api(value = "组织机构相关")
public class OrganizationController {
    @Resource
    private OrganizationService organizationService;

    @ApiOperation(value = "机构列表", notes = "")
    @GetMapping
    public Result list() {
        Condition condition = new Condition(TOrganization.class);
        Example.Criteria criteria = condition.createCriteria();
        final List<TOrganization> list = organizationService.findByCondition(condition);
        return ResultGenerator.genOkResult(list);
    }

    @ApiOperation(value = "组织机构新增", notes = "")
    @PostMapping
    public Result add(@RequestBody @Valid final TOrganization entity,
                      final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            organizationService.save(entity);
            return ResultGenerator.genOkResult("保存成功！");
        }
    }
    @GetMapping("test")
    public Result test() {
        organizationService.test();
        return ResultGenerator.genOkResult("保存成功！");
    }

    @ApiOperation(value = "编辑机构", notes = "")
    @PutMapping
    public Result edit(@RequestBody @Valid final TOrganization entity,
                       final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            entity.initUpdate();
            try {
                entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getOrganizationName()));
                entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getOrganizationName()));
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            organizationService.update(entity);
            return ResultGenerator.genOkResult("保存成功！");
        }
    }

    @ApiOperation(value = "删除机构", notes = "")
    @DeleteMapping("/{id}")
    public Result remove(@PathVariable final String id) {
        //根据机构ID 查询是否用相关用户关系
        int count = organizationService.countUserOrganizationByToId(id);
        if (count > 0) {
            return ResultGenerator.genFailedResult("已关联用户，请先删除用户。");
        }
        organizationService.deleteById(id);
        return ResultGenerator.genOkResult("删除成功！");
    }

    @ApiOperation(value = "机构名存在验证", notes = "")
    @PostMapping("hasName")
    public Result getInfoByName(@RequestBody final TOrganization entity) {
        String name = entity.getOrganizationName();
        String id = entity.getToId();
        if ("".equals(name)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(TOrganization.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("organizationName", name);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("toId", id);
        }
        final List<TOrganization> list = organizationService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("名称已存在");
        }
    }
}
