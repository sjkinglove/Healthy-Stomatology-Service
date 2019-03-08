package com.haoze.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoze.admin.core.Status;
import com.haoze.admin.dto.system.FastMenuDTO;
import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.admin.model.MenuEntity;
import com.haoze.admin.model.UserEntity;
import com.haoze.admin.service.FastMenuServcie;
import com.haoze.admin.service.UserService;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.HttpContextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author shenjun
 * @date 2019/3/4
 */
@RestController
@RequestMapping("/system/fastmenu")
@Validated
@Api(tags = "快捷通道")
public class FastMenuController {
    @Resource
    private FastMenuServcie fastMenuServcie;

    @Resource
    private UserService userService;

    /**
     * 获取用户所有快捷通道
     *
     * @param id
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "获取角色所有快捷通道", notes = "")
    @GetMapping("listByUserId/{id}")
    public Result listByUserId(@PathVariable final String id) {

        final List<FastMenuEntity> list = fastMenuServcie.listByRoleId(id);

        return ResultGenerator.genOkResult(list);
    }

    /**
     * 按条件获取快捷通道
     *
     * @param entity
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "按条件获取快捷通道", notes = "")
    @PostMapping("listByQuery")
    public Result listByQuery(@RequestBody @Valid final FastMenuDTO entity,
                              final BindingResult bindingResult) {

        final List<FastMenuEntity> list = fastMenuServcie.listByQuery(entity);

        return ResultGenerator.genOkResult(list);
    }

    /**
     * 首页快捷通道列表
     *
     * @param id
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "首页快捷通道列表", notes = "")
    @PostMapping("list/{id}")
    public Result list(@PathVariable final String id) {

        final List<FastMenuDTO> list = fastMenuServcie.list(id);

        return ResultGenerator.genOkResult(list);
    }

    /**
     * 首页快捷通道列表
     *
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "全快速通道列表", notes = "")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") final Integer page,
                       @RequestParam(defaultValue = "0") final Integer size,
                       @RequestParam(defaultValue = "") final String queryString) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(FastMenuEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtil.isNotEmpty(queryString)) {
            criteria.andLike("fastMenuName", "%" + queryString + "%")//快速菜单名
                    .orLike("fastMenuSort", "%" + queryString + "%")//快捷通道排序
                    .orLike("remark", "%" + queryString + "%");//备注
        }
        condition.setOrderByClause("FAST_MENU_SORT");

        final List<FastMenuEntity> list = fastMenuServcie.findByCondition(condition);
        final PageInfo<FastMenuEntity> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    /**
     * 添加快捷通道
     *
     * @param entity
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "添加快捷通道", notes = "")
    @PostMapping
    public Result add(@RequestBody @Valid final FastMenuDTO entity,
                               final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            //标头获取人员ID
            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
            String tuId = request.getHeader("zuul_id");
            //String tuId = "c4e3ac134f044ebd8641f09ee451254b";
            if(tuId!=null && !"".equals(tuId)){
                entity.setTuId(tuId);

                fastMenuServcie.saveFastMenu(entity);

                return ResultGenerator.genOkResult("保存成功！");
            }else{
                return ResultGenerator.genOkFailedResult("无法从TOKEN中获取用户ID");
            }

        }
    }

    /**
     * 修改快捷通道
     *
     * @param entity
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改快捷通道", notes = "")
    @PutMapping
    public Result edit(@RequestBody @Valid final FastMenuDTO entity,
                       final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            FastMenuEntity fastMenuEntity =new FastMenuEntity();
            //关键字段校验
            //快速菜单ID是否为空
            if(entity.getTfmId()!=null){
                fastMenuEntity.setTfmId(entity.getTfmId());
            }else{
                return ResultGenerator.genFailedResult("异常");
            }
            //菜单ID是否为空
            if(entity.getTmId()!=null){
                fastMenuEntity.setTmId(entity.getTmId());
            }else{
                return ResultGenerator.genOkFailedResult("异常");
            }
            //快捷通道名是否为空
            if(entity.getFastMenuName()!=null){
                fastMenuEntity.setFastMenuName(entity.getFastMenuName());
            }else{
                return ResultGenerator.genOkFailedResult("异常");
            }
            //开启状态
            if(entity.getOpenState()!=null){
                fastMenuEntity.setOpenState(entity.getOpenState());
            }else{
                return ResultGenerator.genOkFailedResult("异常");
            }
            //排序序号
            if(entity.getFastMenuSort()!=null){
                fastMenuEntity.setFastMenuSort(entity.getFastMenuSort());
            }else{
                return ResultGenerator.genOkFailedResult("异常");
            }

            fastMenuServcie.updateFastMenu(fastMenuEntity);

            return ResultGenerator.genOkResult("更新成功！");
        }
    }

    /**
     * 修改启用状态
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "停用", notes = "")
    @PostMapping("/stopFastMenu")
    public Result stopRole(@RequestBody String id) {
        fastMenuServcie.updateStopFlagById(id, Status.CLOSE_FLAG.getValue());
        return ResultGenerator.genOkResult("已停用");
    }

    @ApiOperation(value = "启用", notes = "")
    @PostMapping("/startFastMenu")
    public Result startRole(@RequestBody String id) {
        fastMenuServcie.updateStopFlagById(id, Status.OPEN_FLAG.getValue());
        return ResultGenerator.genOkResult("已启用");
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除", notes = "")
    @DeleteMapping("/{ids}")
    public Result remove(@PathVariable final String ids) {
        if (ids!=null) {
            fastMenuServcie.deleteByIds(ids);
            return ResultGenerator.genOkResult("删除成功！");
        }else{
            return ResultGenerator.genFailedResult("空异常");
        }
    }

    @ApiOperation(value = "快捷通道名重复验证录入", notes = "")
    @PostMapping("hasFastMenuName")
    public Result getInfoByName(@RequestBody final FastMenuEntity entity) {
        String name = entity.getFastMenuName();
        String id = entity.getTfmId();
        if ("".equals(name)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(FastMenuEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("fastMenuName", name);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("tfmId", id);
        }
        final List<FastMenuEntity> list = fastMenuServcie.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genOkFailedResult("快速通道名称已存在");
        }
    }
}
