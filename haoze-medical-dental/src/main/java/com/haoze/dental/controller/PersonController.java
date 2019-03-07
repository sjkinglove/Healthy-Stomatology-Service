package com.haoze.dental.controller;

import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.HttpContextUtils;
import com.haoze.dental.core.TypeValue;
import com.haoze.dental.dto.PersonDTO;
import com.haoze.dental.model.PersonEntity;
import com.haoze.dental.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 人员管理controller
 * @author shenjun
 * @date 2019/3/5
 */
@RestController
@RequestMapping("/record/person")
@Validated
@Api(tags = "人员管理")
public class PersonController {

    @Resource
    private PersonService personService;

    /**
     * 获取所有人员
     *
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "获取所有人员", notes = "")
    @GetMapping
    public Result list() {
        Condition condition = new Condition(PersonEntity.class);
        final List<PersonEntity> list = personService.findByCondition(condition);
        return ResultGenerator.genOkResult(list);
    }

    /**
     * 添加人员档案
     *
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "添加人员档案", notes = "")
    @GetMapping
    public Result add(@RequestBody @Valid final PersonEntity entity,
                      final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {

            if(entity.getPersonName() == null || "".equals(entity.getPersonName())){
                return ResultGenerator.genOkFailedResult("姓名未填写");
            }
            if(entity.getGender() == null || "".equals(entity.getGender())){
                return ResultGenerator.genOkFailedResult("性别未选中");
            }
            if(entity.getIdCard() == null || "".equals(entity.getIdCard())){
                entity.setDocType(TypeValue.TYPE_ZERO.getValue());//临时档案 字段值为0
            }else{
                entity.setDocType(TypeValue.TYPE_ONE.getValue());//正式档案 字段值为1
            }
            personService.save(entity);

            return ResultGenerator.genOkResult("保存成功");
        }
    }

    /**
     * 身份证重复验证
     *
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "身份证重复验证", notes = "")
    @PostMapping("hasIdCard")
    public Result getInfoByName(@RequestBody final PersonDTO entity) {
        String idCard = entity.getIdCard();
        if ("".equals(idCard)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(PersonEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("idCard", idCard);

        final List<PersonEntity> list = personService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("快速通道名称已存在");
        }
    }

}
