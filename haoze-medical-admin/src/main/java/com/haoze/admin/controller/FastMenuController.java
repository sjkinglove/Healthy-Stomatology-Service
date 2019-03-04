package com.haoze.admin.controller;

import com.haoze.admin.dto.system.FastMenuDTO;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.admin.model.MenuEntity;
import com.haoze.admin.service.FastMenuServcie;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/system/fastmenu")
@Validated
@Api(tags = "快捷通道")
public class FastMenuController {
    @Resource
    private FastMenuServcie fastMenuServcie;

    /**
     * 获取用户所有快捷通道
     *
     * @param id
     * @return
     * @author shenjun
     * @date 2019/3/4
     */
    @ApiOperation(value = "获取所有角色关联菜单", notes = "")
    @GetMapping("listByUserId/{id}")
    public Result listByUserId(@PathVariable final String id) {
        final List<FastMenuEntity> list = fastMenuServcie.listByUserId(id);
        return ResultGenerator.genOkResult(list);
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
            FastMenuEntity fastMenuEntity =new FastMenuEntity();

            if(entity.getFastMenuName()!=null){
                fastMenuEntity.setFastMenuName(entity.getFastMenuName());
            }else{
                return ResultGenerator.genFailedResult("异常");
            }

            if(entity.getOpenState()!=null){
                fastMenuEntity.setOpenState(entity.getOpenState());
            }else{
                return ResultGenerator.genFailedResult("异常");
            }

            if(entity.getFastMenuSort()!=null){
                fastMenuEntity.setFastMenuSort(entity.getFastMenuSort());
            }else{
                return ResultGenerator.genFailedResult("异常");
            }

            fastMenuServcie.saveFastMenu(fastMenuEntity);
            return ResultGenerator.genOkResult("保存成功！");
        }
    }

//    /**
//     * 修改快捷通道
//     *
//     * @param entity
//     * @param bindingResult
//     * @return
//     */
//    @ApiOperation(value = "修改快捷通道", notes = "")
//    @PutMapping
//    public Result edit(@RequestBody @Valid final FastMenuDTO entity,
//                       final BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            final String msg = bindingResult.getFieldError().getDefaultMessage();
//            return ResultGenerator.genFailedResult(msg);
//        } else {
//            entity.initUpdate();
//            menuService.update(entity);
//            return ResultGenerator.genOkResult("保存成功！");
//        }
//    }
}
