package com.haoze.dental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.UUIDUtil;
import com.haoze.dental.core.TypeValue;
import com.haoze.dental.dto.PersonDTO;
import com.haoze.dental.model.PersonEntity;
import com.haoze.dental.service.PersonService;
import com.haoze.dental.util.Verify;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

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
     * 获取所有人员档案
     *
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "获取所有人员档案", notes = "")
    @PostMapping
    public Result list(@RequestParam(defaultValue = "0") final Integer page,
                       @RequestParam(defaultValue = "0") final Integer size,
                       @RequestBody @Valid PersonDTO entity) {
        PageHelper.startPage(page, size);
        final List<PersonEntity> list = personService.getListByQuery(entity);
        final PageInfo<PersonEntity> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    /**
     * 添加/修改人员档案
     *
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "添加/修改人员档案", notes = "")
    @PutMapping
    public Result add(@RequestBody @Valid final PersonEntity entity,
                      final BindingResult bindingResult) throws ParseException, BadHanyuPinyinOutputFormatCombination {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            //必填项校验
            //人员名
            if(entity.getPersonName() == null || "".equals(entity.getPersonName())){
                return ResultGenerator.genOkFailedResult("姓名未填写");
            }
            //性别
            if(entity.getGender() == null || "".equals(entity.getGender())){
                return ResultGenerator.genOkFailedResult("性别未选中");
            }
            //身份证
            if(entity.getIdCard() == null || "".equals(entity.getIdCard())){
                entity.setDocType(TypeValue.TYPE_ZERO.getValue());//临时档案 字段值为0
            }else{
                entity.setDocType(TypeValue.TYPE_ONE.getValue());//正式档案 字段值为1
            }
            entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getPersonName()));
            entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getPersonName()));
            //根据人员ID 判断是新增还是修改
            if(entity.getTpId() == null || "".equals(entity.getTpId())){
                //人员ID生成
                entity.setTpId(UUIDUtil.randomString());
                entity.initAdd();
                personService.save(entity);
                return ResultGenerator.genOkResult("保存成功");
            }else{
                entity.initUpdate();
                personService.update(entity);
                return ResultGenerator.genOkResult("修改成功");
            }
        }
    }



    /**
     * 身份证验证
     *
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "身份证验证并返回出生年月年龄性别", notes = "")
    @PostMapping("IdCardVerify/{idCard}")
    public Result IdCardVerify(@PathVariable final String idCard) {
        //空判断
        if ("".equals(idCard)) {
            return ResultGenerator.genOkFailedResult("身份证号码不能为空");
        }
        Condition condition = new Condition(PersonEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("idCard", idCard);

        final List<PersonEntity> list = personService.findByCondition(condition);
        if (list.size() == 0) {
            //身份证号码正则验证
            if(!Verify.isIDNumber(idCard)){
                return ResultGenerator.genOkFailedResult("身份证号码不正确");
            }
            //获取出身年月 年龄 性别（birthday,age,sex）
            Map<String,String> map = Verify.getBirAgeSex(idCard);

            return ResultGenerator.genOkResult(map);
        } else {
            return ResultGenerator.genOkFailedResult("身份证号码已存在");
        }
    }

}
