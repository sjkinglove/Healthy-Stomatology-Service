//package com.haoze.admin.controller;
//
//import com.haoze.admin.CloudAdminApplicationTest;
//import com.haoze.admin.model.system.DepartmentEntity;
//import com.haoze.admin.service.system.DepartmentService;
//import org.junit.Test;
//import tk.mybatis.mapper.model.Condition;
//import tk.mybatis.mapper.model.Example;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//public class OrganizationControllerTest extends CloudAdminApplicationTest {
//
//    @Resource
//    private DepartmentService departmentService;
//
//    @Test
//    public void list() {
//        Condition condition = new Condition(DepartmentEntity.class);
//        Example.Criteria criteria = condition.createCriteria();
//        final List<DepartmentEntity> list = departmentService.findByCondition(condition);
//        System.out.println(list.get(0).getCode());
//    }
//
//    @Test
//    public void add() {
//        for (int i = 7; i < 10; i++) {
//            DepartmentEntity model = new DepartmentEntity();
//            model.setCode("cs" + (4 + i));
//            model.setName("测试" + (3 + i));
//            model.setStopFlag("0");
//            model.setParentId("002b37eecb5f482da4da53498de71a31");
//
//            departmentService.save(model);
//        }
//    }
//
//    @Test
//    public void edit() {
//        DepartmentEntity model = new DepartmentEntity();
//        model.setId("f472a15810234390b4452c3bd9e1ffee");
//        model.setName("科室21");
//        model.setDeptSort("5");
//        model.setParentId("0");
//        model.initUpdate();
//        departmentService.update(model);
//    }
//
//    @Test
//    public void remove() {
//        departmentService.deleteById("fab92950f76748d9bb7ca888d80b0692");
//    }
//}