package com.haoze.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.model.UserEntity;
import com.haoze.admin.service.UserService;
import com.haoze.admin.service.feign.JwtService;
import com.haoze.common.annotation.HasEmrPermission;
import com.haoze.common.response.Result;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.HttpContextUtils;
import com.haoze.common.utils.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * @author shenjun
 * @date 2019/02/28
 */
@RestController
@RequestMapping("/system/user")
@Validated
@Api(value = "UserController")
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    JwtService jwtService;

    @ApiOperation(value = "test", notes = "测试接口")
    @GetMapping("/test")
    @HasEmrPermission("system:menu:add")
    public Result test() {
        return ResultGenerator.genOkResult("测试返回");
    }


    @ApiOperation(value = "用户注册", notes = "")
    @PostMapping
    public Result register(@RequestBody @Valid final UserDTO user,
                           final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFailedResult(msg);
        } else {
            user.setTuId(UUIDUtil.randomString());
            UserEntity userEntity = new UserEntity();
            userEntity.setLoginName(user.getLoginName());
            userEntity.setTuId(user.getTuId());
            this.userService.saveUserAndRoleAndOrganizagion(user);
            return this.getToken(userEntity);
        }
    }

    //    @PreAuthorize("hasAuthority('user:delete')")
    @ApiOperation(value = "删除用户", notes = "")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable final String id) {
        this.userService.deleteById(id);
        return ResultGenerator.genOkResult();
    }

    @ApiOperation(value = "验证密码", notes = "")
    @PostMapping("/password")
    public Result validatePassword(@RequestBody final UserEntity user) {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String account = request.getHeader("zuul_account");
        final UserEntity oldUser = this.userService.findBy("loginName", account);
        final boolean isValidate = this.userService.verifyPassword(user.getLoginName(), oldUser.getUserPwd());
        return ResultGenerator.genOkResult(isValidate);
    }

    /**
     * 重置密码
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "重置密码", notes = "")
    @PostMapping("/resetPassword")
    public Result resetPassword(@RequestBody final UserEntity user) {
        user.initUpdate();
        user.setUserPwd(this.userService.encodePassword(user.getUserPwd()));
        Condition condition = new Condition(UserEntity.class);
        Example.Criteria criteria = condition.createCriteria();

        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String account = request.getHeader("zuul_account");

        criteria.andEqualTo("loginName", account);
        this.userService.updateByCondition(user, condition);
        return ResultGenerator.genOkResult();
    }

    @ApiOperation(value = "更新用户信息", notes = "")
    @PutMapping
    public Result update(@RequestBody final UserDTO user) {

        this.userService.updateUserAndRoleAndDept(user);

        return this.getToken(this.userService.findBy("tuId", user.getTuId()));
    }

    @ApiOperation(value = "根据ID进行账户验证", notes = "")
    @GetMapping("/{id}")
    public Result detail(@PathVariable final String id) {
        final UserEntity user = this.userService.findById(id);
        return ResultGenerator.genOkResult(user);
    }

    @ApiOperation(value = "根据账户获取用户信息", notes = "")
    @GetMapping("/info/{account}")
    public UserEntity info(@PathVariable String account) {
        UserEntity userDB = userService.findBy("loginName", account);
        return userDB;
    }

    @ApiOperation(value = "查询所有", notes = "")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") final Integer page,
                       @RequestParam(defaultValue = "0") final Integer size,
                       @RequestParam String queryString) {
        PageHelper.startPage(page, size);
        final List<UserDTO> list = this.userService.findAllUserWithRole(queryString);
        final PageInfo<UserDTO> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return Result
     */
    @ApiOperation(value = "用户登录", notes = "")
    @PostMapping("/login")
    public Result login(@RequestBody final UserEntity user) {
        if (user.getLoginName() == null) {
            return ResultGenerator.genFailedResult("账号不能为空");
        }
        if (user.getUserPwd()== null) {
            return ResultGenerator.genFailedResult("密码不能为空");
        }
        // 用户名登录
        UserEntity dbUser = null;
        if (user.getLoginName() != null) {
            dbUser = this.userService.findBy("loginName", user.getLoginName());
            if (dbUser == null) {
                return ResultGenerator.genFailedResult("账号不存在");
            }
        }
        // 验证密码
        if (!this.userService.verifyPassword(user.getUserPwd(), dbUser.getUserPwd())) {
            return ResultGenerator.genFailedResult("密码错误");
        }
        user.setTuId(dbUser.getTuId());
        return this.getToken(user);
    }

    @GetMapping("/logout")
    public Result logout(final Principal user) {
        return ResultGenerator.genOkResult();
    }

    /**
     * 获得 token
     */
    private Result getToken(final UserEntity user) {
        final String username = user.getLoginName();
        final String id = user.getTuId();
        final String token = jwtService.getToken(username, id, "1");
        return ResultGenerator.genOkResult(token);
    }

    @ApiOperation(value = "账户验证", notes = "")
    @PostMapping("hasAccount")
    public Result getInfoByAccount(@RequestBody final UserEntity entity) {
        String account = entity.getLoginName();
        String id = entity.getTuId();
        if ("".equals(account)) {
            return ResultGenerator.genOkResult();
        }
        Condition condition = new Condition(UserEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("loginName", account);
        if (!"".equals(id)) {
            criteria.andNotEqualTo("tuId", id);
        }
        final List<UserEntity> list = userService.findByCondition(condition);
        if (list.size() == 0) {
            return ResultGenerator.genOkResult();
        } else {
            return ResultGenerator.genFailedResult("账号已存在");
        }
    }

        @ApiOperation(value = "账户验证并返回信息", notes = "")
        @GetMapping("/hasAccount/{account}")
        public Result getInfoByAccountCase(@PathVariable final String account) {
            if ("".equals(account)) {
                return ResultGenerator.genOkResult();
            }
            Condition condition = new Condition(UserEntity.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria.andEqualTo("loginName", account);
            final List<UserEntity> list = userService.findByCondition(condition);
            if (list.size() == 0) {
                return ResultGenerator.genOkResult();
            } else {
                return ResultGenerator.genOkResult(list);
            }
    }
}
