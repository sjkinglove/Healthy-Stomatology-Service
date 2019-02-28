//package com.haoze.admin.controller;
//
//import com.haoze.admin.CloudAdminApplicationTest;
//import com.haoze.admin.model.system.MenuEntity;
//import com.haoze.admin.service.system.MenuService;
//import com.haoze.common.response.ResultGenerator;
//import com.haoze.common.utils.ChineseCharactersCode;
//import com.haoze.common.utils.UUIDUtil;
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import tk.mybatis.mapper.entity.Condition;
//import tk.mybatis.mapper.entity.Example;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class MenuControllerTest extends CloudAdminApplicationTest {
//
//    @Autowired
//    private MenuService menuService;
//
//    @Test
//    public void list() {
//        Condition condition = new Condition(MenuEntity.class);
//        Example.Criteria criteria = condition.createCriteria();
//        condition.setOrderByClause("MENU_SORT");
////        criteria.andEqualTo("displayFlag", "0");
//        final List<MenuEntity> list = menuService.findByCondition(condition);
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void listByRoleId() {
//        final List<String> list = menuService.listByRoleId("1");
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void naviList() {
//        Condition condition = new Condition(MenuEntity.class);
//        List<String> typeList = new ArrayList();
//        typeList.add("1");
//        typeList.add("2");
//        Example.Criteria criteria = condition.createCriteria();
//        condition.setOrderByClause("MENU_SORT");
//        criteria.andIn("type", typeList);
//        criteria.andEqualTo("displayFlag", "0");
//        final List<MenuEntity> list = menuService.findByCondition(condition);
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void add() {
//        MenuEntity entity = new MenuEntity();
//        entity.setId(UUIDUtil.randomString());
//        entity.setName("fcx测试菜单");
//        entity.setCode("fcxcscd");
//        entity.setType("2");
//        entity.setSort("1");
//        entity.setDisplayFlag("0");
//        entity.setMenuLevel("2");
//        entity.setUrl("/user");
//        entity.setParentId("7b5844df314844b284b0dd42e3e4423d");
//
//        entity.initAdd();
//        if (entity.getParentId() == null) {
//            entity.setParentId("0");
//        }
//        //查询该父节点下的排序
//        Condition condition = new Condition(MenuEntity.class);
//        condition.setOrderByClause("MENU_SORT desc");
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo("parentId", entity.getParentId());
//        List<MenuEntity> sortList = menuService.findByCondition(condition);
//        int count = 1;
//        if (sortList.size() > 0) {
//            count = Integer.parseInt(sortList.get(0).getSort()) + 1;
//        }
//        entity.setSort(String.valueOf(count));
//        try {
//            entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getName()));
//            entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getName()));
//        } catch (BadHanyuPinyinOutputFormatCombination e) {
//            e.printStackTrace();
//        }
//        menuService.save(entity);
//    }
//
//    @Test
//    public void edit() {
//        MenuEntity entity = new MenuEntity();
//        entity.setId("d46c840b6c2c4affae53c18a6356f0e1");
//        entity.setName("用户管理");
//        entity.setParentId("7b5844df314844b284b0dd42e3e4423d");
//        entity.setSort("5");
//        entity.initUpdate();
//        try {
//            entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getName()));
//            entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getName()));
//        } catch (BadHanyuPinyinOutputFormatCombination e) {
//            e.printStackTrace();
//        }
//        menuService.update(entity);
//    }
//
//    @Test
//    public void remove() {
//        menuService.deleteById("0eb8e145a1824f32a438857c0b05624a");
//    }
//
//    @Test
//    public void getInfoByUrl() {
//        String url = "";
//        String id = "";
//        Condition condition = new Condition(MenuEntity.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo("url", url);
//        if (!"".equals(id)) {
//            criteria.andNotEqualTo("id", id);
//        }
//        final List<MenuEntity> list = menuService.findByCondition(condition);
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void getInfoByPermission() {
//        String permission = "system:menu:cs";
//        String id = "";
//        Condition condition = new Condition(MenuEntity.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo("permission", permission);
//        if (!"".equals(id)) {
//            criteria.andNotEqualTo("id", id);
//        }
//        final List<MenuEntity> list = menuService.findByCondition(condition);
//        System.out.println(list.size());
//    }
//
//    @Test
//    public void saveRoleMenuRela() {
//        this.menuService.saveRoleMenuRela("1", "7b5844df314844b284b0dd42e3e4423d,d46c840b6c2c4affae53c18a6356f0e1,d18b85c6e3a24ab98bd5b606eeaca5e5,738ad86fac3c442f9690af6cfb11d423,3815befa80dd4e3ca22144e98766e54e");
//    }
//}