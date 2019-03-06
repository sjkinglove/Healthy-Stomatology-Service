package com.haoze.admin.controller;

import com.haoze.admin.core.Status;
import com.haoze.admin.dto.system.OrganizationDTO;
import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.model.OrganizationEntity;
import com.haoze.admin.model.UserEntity;
import com.haoze.admin.service.OrganizationService;
import com.haoze.admin.service.UserService;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Resource
    private UserService userService;


    @ApiOperation(value = "机构列表", notes = "")
    @GetMapping
    public Result list() {
        Condition condition = new Condition(OrganizationEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        final List<OrganizationEntity> list = organizationService.findByCondition(condition);

        List<OrganizationDTO> newList= new ArrayList<OrganizationDTO>();

        for(OrganizationEntity organizationEntity : list){

            OrganizationDTO organizationDTO = new OrganizationDTO();
            organizationDTO.setOrganizationClass(organizationEntity.getOrganizationClass());
            organizationDTO.setOrganizationAddress(organizationEntity.getOrganizationAddress());
            organizationDTO.setOrganizationCode(organizationEntity.getOrganizationCode());
            organizationDTO.setOrganizationName(organizationEntity.getOrganizationName());
            organizationDTO.setPyCode(organizationEntity.getPyCode());
            organizationDTO.setWbCode(organizationEntity.getWbCode());
            organizationDTO.setStopFlag(organizationEntity.getStopFlag());
            organizationDTO.setParentToId(organizationEntity.getParentToId());
            organizationDTO.setToSort(organizationEntity.getToSort());
            organizationDTO.setToId(organizationEntity.getToId());
            organizationDTO.setParentToName(organizationEntity.getParentToName());

            List<UserDTO> userDTOList = userService.findManageUserByToId(organizationEntity.getToId());
            if(userDTOList != null && userDTOList.size() != 0){

                organizationDTO.setName(userDTOList.get(0).getName());
                organizationDTO.setPhone(userDTOList.get(0).getPhone());
                organizationDTO.setLoginName(userDTOList.get(0).getLoginName());
                organizationDTO.setPhone(userDTOList.get(0).getPhone());
                organizationDTO.setRoleId(userDTOList.get(0).getRoleId());

                newList.add(organizationDTO);
            }else{
                newList.add(organizationDTO);
            }


        }

        return ResultGenerator.genOkResult(newList);
    }

    @ApiOperation(value = "组织机构新增", notes = "")
    @PostMapping
    public Result add(@RequestBody @Valid final OrganizationDTO entity,
                      final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            OrganizationEntity organizationEntity =new OrganizationEntity();
            organizationEntity.setOrganizationName(entity.getOrganizationName());
            organizationEntity.setOrganizationAddress(entity.getOrganizationAddress());
            organizationEntity.setOrganizationClass(entity.getOrganizationClass());
            organizationEntity.setOrganizationClassId(entity.getOrganizationClassId());
            organizationEntity.setParentToId(entity.getParentToId());
            organizationEntity.setParentToName(entity.getParentToName());
            organizationEntity.setStopFlag(entity.getStopFlag());
            organizationEntity.setToId(UUIDUtil.randomString());
            organizationService.save(organizationEntity);

            UserDTO userDTO = new UserDTO();
            userDTO.setLoginName(entity.getLoginName());//用户名
            userDTO.setPhone(entity.getPhone());//电话
            userDTO.setPassword(Status.DEFAULT_PASSWORD.getValue());//默认密码
            userDTO.setWorkNo(entity.getWorkNo());//工号
            userDTO.setName(entity.getName());//用户名
            userDTO.setRoleId(entity.getRoleId());//角色ID
            userDTO.setToId(organizationEntity.getToId());//组织机构ID

            try {
                userService.saveUserAndRoleAndOrganizagionCase(userDTO);
                return ResultGenerator.genOkResult("保存成功！");
            } catch (ParseException e) {
                return ResultGenerator.genFailedResult("保存失败");
            }



        }
    }
    @GetMapping("test")
    public Result test() {
        organizationService.test();
        return ResultGenerator.genOkResult("保存成功！");
    }

    @ApiOperation(value = "编辑机构", notes = "")
    @PutMapping
    public Result edit(@RequestBody @Valid final OrganizationDTO entity,
                       final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {

            OrganizationEntity organizationEntity =new OrganizationEntity();

            organizationEntity.setToId(entity.getToId());
            organizationEntity.setOrganizationName(entity.getOrganizationName());
            organizationEntity.setOrganizationAddress(entity.getOrganizationAddress());
            organizationEntity.setOrganizationClass(entity.getOrganizationClass());
            organizationEntity.setOrganizationClassId(entity.getOrganizationClassId());
            organizationEntity.setParentToId(entity.getParentToId());
            organizationEntity.setParentToName(entity.getParentToName());
            organizationEntity.setStopFlag(entity.getStopFlag());

            organizationEntity.initUpdate();
            try {
                entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getOrganizationName()));
                entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getOrganizationName()));
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            organizationService.update(organizationEntity);

            UserDTO userDTO = new UserDTO();
            userDTO.setLoginName(entity.getLoginName());//用户名
            userDTO.setPhone(entity.getPhone());//电话
            userDTO.setPassword(Status.DEFAULT_PASSWORD.getValue());//默认密码
            userDTO.setWorkNo(entity.getWorkNo());//工号
            userDTO.setName(entity.getName());//用户名
            userDTO.setRoleId(entity.getRoleId());

            try {
                userService.saveUserAndRoleAndOrganizagionCase(userDTO);
                return ResultGenerator.genOkResult("保存成功！");
            } catch (ParseException e) {
                return ResultGenerator.genFailedResult("保存失败");
            }
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
    public Result getInfoByName(@RequestBody final OrganizationEntity entity) {
        String name = entity.getOrganizationName();
        String id = entity.getToId();
        if ("".equals(name)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(OrganizationEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("organizationName", name);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("toId", id);
        }
        final List<OrganizationEntity> list = organizationService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genOkFailedResult("名称已存在");
        }
    }
}
