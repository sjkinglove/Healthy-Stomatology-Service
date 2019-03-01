package com.haoze.admin.service.impl;

import com.haoze.admin.mapper.MenuMapper;
import com.haoze.admin.model.TMenu;

import com.haoze.admin.model.TRoleMenu;
import com.haoze.admin.service.MenuService;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.UUIDUtil;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author shenjun
 * @date 2019/02/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends AbstractService<TMenu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<String> listByRoleId(String id) {
        return menuMapper.listByRoleId(id);
    }

    @Override
    public void saveRoleMenuRela(String roleId, String menuIds) {
        menuMapper.clearRoleMenuRela(roleId);
        if (!"".equals(menuIds)) {
            String[] menuIdArr = menuIds.split(",");
            for (String id : menuIdArr) {
                TRoleMenu entity = new TRoleMenu();
                entity.initAdd();
                entity.setTrmId(UUIDUtil.randomString());
                entity.setTrId(roleId);
                entity.setTmId(id);
                menuMapper.insertRoleMenuRela(entity);
            }
        }
    }

    @Override
    public void update(TMenu entity) {
        int targetSort = new Integer(entity.getMenuSort());
        //查询该父节点下的排序
        int count = 1;
        Condition condition = new Condition(TMenu.class);
        condition.setOrderByClause("MENU_SORT desc");
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("parentMenuId", entity.getParentMenuId());
        List<TMenu> sortList = menuMapper.selectByCondition(condition);
        if (sortList.size() > 0) {
            count = Integer.parseInt(sortList.get(0).getMenuSort());
        }
        // 查询原节点排序号
        TMenu oldSort = menuMapper.selectByPrimaryKey(entity.getTmId());
        int currentSortNo = Integer.parseInt(oldSort.getMenuSort());

        if (targetSort < 1) {
            targetSort = 1;
        }
        if (targetSort > count) {
            targetSort = count;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("parentId", entity.getParentMenuId());
        map.put("targetSortNo", targetSort);
        map.put("currentSortNo", currentSortNo);
        if (targetSort > currentSortNo) {
            menuMapper.updateSortNoForReduce(map);
        } else if (targetSort < currentSortNo) {
            menuMapper.updateSortNoForEnlarge(map);
        }

        try {
            entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getMenuName()));
            entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getParentMenuId()));
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        entity.setMenuSort(String.valueOf(targetSort));
        menuMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<TMenu> selectMenuByUserRole(String account) {
        return menuMapper.selectMenuByUserRole(account);
    }

    @Override
    public void deleteById(Object id) {
        Condition condition = new Condition(TMenu.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("parentMenuId", id);
        menuMapper.deleteByCondition(condition);
        menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int countMenuRoleByMenuId(String menuId) {
        return menuMapper.countMenuRoleByMenuId(menuId);
    }
}
