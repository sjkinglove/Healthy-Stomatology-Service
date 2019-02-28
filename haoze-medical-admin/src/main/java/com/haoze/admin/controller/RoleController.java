package com.haoze.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoze.admin.dto.system.RoleMenuDTO;
import com.haoze.admin.model.TRole;
import com.haoze.admin.service.MenuService;
import com.haoze.admin.service.RoleService;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.UUIDUtil;
import io.swagger.annotations.ApiOperation;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author shenjun
 * @date 2019/02/27
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    @ApiOperation(value = "增加角色", notes = "")
    @PostMapping
    public Result add(@RequestBody final RoleMenuDTO roleMenu) {
        TRole role = new TRole();
        role.setRoleCode("ROLE" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int)((Math.random()*9+1)*100000));
        role.setRoleName(roleMenu.getName());
        role.setWbCode(roleMenu.getWbCode());
        role.setPyCode(roleMenu.getPyCode());
        role.setRoleLevel(roleMenu.getGroupLevel());
        role.setTrId(UUIDUtil.randomString());
        role.setStopFlag(roleMenu.getStopFlag());
        role.initAdd();
        try {
            String code = ChineseCharactersCode.getPinyinCode(role.getRoleName());
            role.setRoleCode(code);
            role.setPyCode(code);
            role.setWbCode(ChineseCharactersCode.getWBCode(role.getRoleName()));
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        this.roleService.save(role);
        menuService.saveRoleMenuRela(role.getTrId(), roleMenu.getMenuIds());
        return ResultGenerator.genOkResult();
    }

    @ApiOperation(value = "删除角色", notes = "")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable final String id) {
        // 查询是否有关联用户
        int count = roleService.countRoleMenuByRoleId(id);
        if (count > 0) {
            return ResultGenerator.genFailedResult("存在已分配角色的用户，请先删除用户。");
        }
        this.roleService.deleteByIds(id);
        return ResultGenerator.genOkResult();
    }

    @ApiOperation(value = "更新角色", notes = "")
    @PutMapping
    public Result update(@RequestBody final TRole role) {
        role.initUpdate();
        try {
            String code = ChineseCharactersCode.getPinyinCode(role.getRoleName());
            role.setRoleCode(code);
            role.setPyCode(code);
            role.setWbCode(ChineseCharactersCode.getWBCode(role.getRoleName()));
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        this.roleService.update(role);
        return ResultGenerator.genOkResult();
    }

    @ApiOperation(value = "获取角色列表", notes = "")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") final Integer page,
                       @RequestParam(defaultValue = "0") final Integer size,
                       @RequestParam(defaultValue = "") final String queryString) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(TRole.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtil.isNotEmpty(queryString)) {
            criteria.andLike("roleName", "%" + queryString + "%")
                    .orLike("roleCode", "%" + queryString + "%")
                    .orEqualTo("stopFlag", queryString);
        }
        final List<TRole> list = this.roleService.findByCondition(condition);
        final PageInfo<TRole> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    @ApiOperation(value = "角色名重复验证录入", notes = "")
    @PostMapping("hasName")
    public Result getInfoByName(@RequestBody final TRole entity) {
        String name = entity.getRoleName();
        String id = entity.getTrId();
        if ("".equals(name)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(TRole.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("roleName", name);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("trId", id);
        }
        final List<TRole> list = roleService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("名称已存在");
        }
    }

    @ApiOperation(value = "角色编码重复验证录入", notes = "")
    @PostMapping("hasCode")
    public Result getInfoByCode(@RequestBody final TRole entity) {
        String code = entity.getRoleCode();
        String id = entity.getTrId();
        if ("".equals(code)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(TRole.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("roleCode", code);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("trId", id);
        }
        final List<TRole> list = roleService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("编码已存在");
        }
    }

    @ApiOperation(value = "停用", notes = "")
    @PostMapping("/stopRole")
    public Result stopRole(@RequestBody String id) {
        roleService.updateStopFlagById(id, "1");
        return ResultGenerator.genOkResult("已停用");
    }

    @ApiOperation(value = "启用", notes = "")
    @PostMapping("/startRole")
    public Result startRole(@RequestBody String id) {
        roleService.updateStopFlagById(id, "0");
        return ResultGenerator.genOkResult("已启用");
    }


}
