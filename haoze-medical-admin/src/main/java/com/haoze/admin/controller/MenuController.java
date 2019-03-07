package com.haoze.admin.controller;

import com.haoze.admin.model.MenuEntity;
import com.haoze.admin.service.MenuService;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.HttpContextUtils;
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
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yangyb
 * @date 2018/12/6
 */
@RestController
@RequestMapping("/system/menu")
@Validated
@Api(value = "MenuController")
public class MenuController {
    @Resource
    private MenuService menuService;

    @ApiOperation(value = "角色列表显示", notes = "")
    @GetMapping
    public Result list() {
        Condition condition = new Condition(MenuEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("MENU_SORT");
        final List<MenuEntity> list = menuService.findByCondition(condition);
        return ResultGenerator.genOkResult(list);
    }

    /**
     * 获取所有角色关联菜单
     *
     * @param id
     * @return
     * @author yangyb
     * @date 2018/12/26
     */
    @ApiOperation(value = "获取所有角色关联菜单", notes = "")
    @GetMapping("listByRoleId/{id}")
    public Result listByRoleId(@PathVariable final String id) {
        final List<String> list = menuService.listByRoleId(id);
        return ResultGenerator.genOkResult(list);
    }

    /**
     * 获取导航菜单
     *
     * @return
     */
    @ApiOperation(value = "获取导航菜单", notes = "")
    @GetMapping("naviMenu")
    public Result naviList() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String account = request.getHeader("zuul_account");
        final List<MenuEntity> list = menuService.selectMenuByUserRole(account);
        return ResultGenerator.genOkResult(list);
    }

    /**
     * 保存
     *
     * @param entity
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "添加", notes = "")
    @PostMapping
    public Result add(@RequestBody @Valid final MenuEntity entity,
                      final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            entity.setTmId(UUIDUtil.randomString());
            entity.setDisplayFlag("0");
            entity.initAdd();
            if (entity.getParentMenuId() == null) {
                entity.setParentMenuId("0");
            }
            //查询该父节点下的排序
            Condition condition = new Condition(MenuEntity.class);
            condition.setOrderByClause("MENU_SORT desc");
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("parentMenuId", entity.getParentMenuId());
            List<MenuEntity> sortList = menuService.findByCondition(condition);
            int count = 1;
            if (sortList.size() > 0) {
                count = Integer.parseInt(sortList.get(0).getMenuSort()) + 1;
            }
            entity.setMenuSort(String.valueOf(count));
            try {
                entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getMenuName()));
                entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getMenuName()));
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            entity.setMenuCode("MENU" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int)((Math.random()*9+1)*100000));
            menuService.save(entity);
            return ResultGenerator.genOkResult("保存成功！");
        }
    }

    /**
     * 保存菜单、角色关系
     *
     * @param m
     * @return
     */
    @ApiOperation(value = "保存菜单、角色关系", notes = "")
    @PostMapping("saveRoleMenuRela")
    public Result saveRoleMenuRela(@RequestBody Map m) {
        String roleId = m.get("roleId").toString();
        String menuIds = m.get("menuIds").toString();
        menuService.saveRoleMenuRela(roleId, menuIds);
        return ResultGenerator.genOkResult("保存成功！");
    }

    /**
     * 修改
     *
     * @param entity
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改", notes = "")
    @PutMapping
    public Result edit(@RequestBody @Valid final MenuEntity entity,
                       final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            entity.initUpdate();
            menuService.update(entity);
            return ResultGenerator.genOkResult("保存成功！");
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除", notes = "")
    @DeleteMapping("/{id}")
    public Result remove(@PathVariable final String id) {
        // 查询是否关联角色
        int count = menuService.countMenuRoleByMenuId(id);
        if (count > 0) {
            return ResultGenerator.genFailedResult("已关联角色，请先删除角色");
        }
        menuService.deleteById(id);
        return ResultGenerator.genOkResult("删除成功！");
    }

    @ApiOperation(value = "路径存在验证", notes = "")
    @PostMapping("hasUrl")
    public Result getInfoByUrl(@RequestBody final MenuEntity entity) {
        String url = entity.getMenuUrl();
        String id = entity.getTmId();
        if ("".equals(url)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(MenuEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("menuUrl", url);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("tmId", id);
        }
        final List<MenuEntity> list = menuService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("路径已存在");
        }
    }

    @ApiOperation(value = "权限存在验证", notes = "")
    @PostMapping("hasPermission")
    public Result getInfoByPermission(@RequestBody final MenuEntity entity) {
        //获取菜单权限
        String permission = entity.getMenuPermission();
        String id = entity.getTmId();
        if ("".equals(permission)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(MenuEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("menuPermission", permission);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("tmId", id);
        }
        final List<MenuEntity> list = menuService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("权限编码已存在");
        }
    }

    @ApiOperation(value = "菜单名重复验证录入", notes = "")
    @PostMapping("hasMenuName")
    public Result getInfoByName(@RequestBody final MenuEntity entity) {
        String name = entity.getMenuName();
        String id = entity.getTmId();
        if ("".equals(name)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(MenuEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("menuName", name);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("tmId", id);
        }
        final List<MenuEntity> list = menuService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("名称已存在");
        }
    }
}
