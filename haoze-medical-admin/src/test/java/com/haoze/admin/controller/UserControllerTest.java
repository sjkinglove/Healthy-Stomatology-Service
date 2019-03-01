//package com.haoze.admin.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.haoze.admin.CloudAdminApplicationTest;
//import com.haoze.admin.dto.system.UserDTO;
//import com.haoze.admin.model.UserEntity;
//import com.haoze.admin.service.UserService;
//import com.haoze.admin.service.feign.JwtService;
//import com.haoze.common.utils.UUIDUtil;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import tk.mybatis.mapper.model.Condition;
//import tk.mybatis.mapper.model.Example;
//
//import java.util.List;
//
///**
// * Created by fcx on 2019/1/25.
// */
//public class UserControllerTest extends CloudAdminApplicationTest {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    JwtService jwtService;
//
//    @Test
//    public void testLogin() {
//        UserEntity user = new UserEntity();
//        user.setLoginName("admin");
//        user.setUserPwd("123456");
//        UserEntity u = userService.findBy("account", user.getLoginName());
//        boolean login = userService.verifyPassword(user.getUserPwd(), u.getUserPwd());
//        System.out.println(login);
//    }
//
//    @Test
//    public void register() {
//        UserDTO user = new UserDTO();
//        user.setId(UUIDUtil.randomString());
//        user.setAccount("fcxTEST");
//        user.setDeptId("1");
//        user.setName("fcxTEST");
//        user.setPassword("123456");
//        user.setRoleId("1");
//        user.setDepartmentId("1");
//        user.initAdd();
////        this.userService.save(user);
//    }
//
//    @Test
//    public void delete() {
//        this.userService.deleteById("7dec3b29124e44a7b72667800b408395");
//    }
//
//    @Test
//    public void validatePassword() {
//        final UserEntity oldUser = this.userService.findById("1");
//        final boolean isValidate = this.userService.verifyPassword("admin123", oldUser.getUserPwd());
//        System.out.println(isValidate);
//    }
//
//    @Test
//    public void update() {
//        UserDTO user = new UserDTO();
//        user.setId("1");
//        user.setRoleId("1");
//        user.setDepartmentId("1");
////        this.userService.update(user);
//    }
//
//    @Test
//    public void detail() {
//        final UserEntity user = this.userService.findById("1");
//        System.out.println(user.getLoginName() + ", " + user.getUserName());
//    }
//
//    @Test
//    public void info() {
//        UserEntity userDB = userService.findBy("account", "admin");
//        System.out.println(userDB.getUserName());
//    }
//
//    @Test
//    public void list() {
//        PageHelper.startPage(1, 30);
//        final List<UserDTO> list = this.userService.findAllUserWithRole("");
////        final PageInfo<UserDTO> pageInfo = new PageInfo<>(list);
//        System.out.println("1");
//    }
//
//    @Test
//    public void getToken() {
//        final String token = jwtService.getToken("admin", "1", "1");
//        System.out.println(token);
//    }
//
//    @Test
//    public void getInfoByAccount() {
//        String account = "admin";
//        String id = "2";
//        Condition condition = new Condition(UserDTO.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo("account", account);
//        criteria.andNotEqualTo("id", id);
//        final List<UserEntity> list = userService.findByCondition(condition);
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void resetPassword() {
//        final UserEntity oldUser = this.userService.findById("86b5efd0ae9c45109cc9ea5d82f024f1");
//        UserDTO resetUser = new UserDTO();
//        resetUser.initUpdate();
//        resetUser.setPassword(this.userService.encodePassword("222222"));
//        Condition condition = new Condition(UserDTO.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo("id", "86b5efd0ae9c45109cc9ea5d82f024f1");
////        this.userService.updateByCondition(resetUser, condition);
//    }
//}