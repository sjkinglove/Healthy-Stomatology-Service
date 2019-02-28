//package com.haoze.admin.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.haoze.admin.CloudAdminApplicationTest;
//import com.haoze.admin.model.system.RoleEntity;
//import com.haoze.admin.service.system.RoleService;
//import com.haoze.common.response.ResultGenerator;
//import com.haoze.common.utils.ChineseCharactersCode;
//import com.haoze.common.utils.UUIDUtil;
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
//import org.junit.Test;
//import tk.mybatis.mapper.entity.Condition;
//import tk.mybatis.mapper.entity.Example;
//import tk.mybatis.mapper.util.StringUtil;
//
//import javax.annotation.Resource;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class RoleControllerTest extends CloudAdminApplicationTest {
//
//    @Resource
//    private RoleService roleService;
//
//    @Test
//    public void add() {
//        RoleEntity role = new RoleEntity();
//        role.setName("FCX测试");
//        role.setId(UUIDUtil.randomString());
//        role.setStopFlag("0");// 未停用
//        role.initAdd();
//        try {
//            String code = ChineseCharactersCode.getPinyinCode(role.getName());
//            role.setCode(code);
//            role.setPyCode(code);
//            role.setWbCode(ChineseCharactersCode.getWBCode(role.getName()));
//        } catch (BadHanyuPinyinOutputFormatCombination e) {
//            e.printStackTrace();
//        }
//        this.roleService.save(role);
//    }
//
//    @Test
//    public void update() {
//        RoleEntity role = new RoleEntity();
//        role.setId("b9b421532673481783c40eaba5429a8b");
//        role.setName("fcx测试修改1");
//        role.initUpdate();
//        try {
//            String code = ChineseCharactersCode.getPinyinCode(role.getName());
//            role.setCode(code);
//            role.setPyCode(code);
//            role.setWbCode(ChineseCharactersCode.getWBCode(role.getName()));
//        } catch (BadHanyuPinyinOutputFormatCombination e) {
//            e.printStackTrace();
//        }
//        this.roleService.update(role);
//    }
//
//    @Test
//    public void list() {
//        String queryString = "%fcx%";
//        PageHelper.startPage(1, 30);
//        Condition condition = new Condition(RoleEntity.class);
//        Example.Criteria criteria = condition.createCriteria();
//        if (StringUtil.isNotEmpty(queryString)) {
//            criteria.andLike("name", queryString).orLike("code", queryString);
//        }
//        final List<RoleEntity> list = this.roleService.findByCondition(condition);
//        final PageInfo<RoleEntity> pageInfo = new PageInfo<>(list);
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void getInfoByName() {
//        String name = "系统管理员";
//        String id = "";
//        Condition condition = new Condition(RoleEntity.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo("name", name);
//        if (!"".equals(id)) {
//            criteria.andNotEqualTo("id", id);
//        }
//        final List<RoleEntity> list = roleService.findByCondition(condition);
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void getInfoByCode() {
//        String code = "admin";
//        String id = "";
//        Condition condition = new Condition(RoleEntity.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo("code", code);
//        if (!"".equals(id)) {
//            criteria.andNotEqualTo("id", id);
//        }
//        final List<RoleEntity> list = roleService.findByCondition(condition);
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void delete() {
//        this.roleService.deleteByIds("'123213213','12312312321'");
//
//    }
//
//    @Test
//    public void stopRole() {
//        this.roleService.updateStopFlagById("1", "1");
//    }
//
//    @Test
//    public void startRole() {
//        this.roleService.updateStopFlagById("1", "0");
//    }
//}