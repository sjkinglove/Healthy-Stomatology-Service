package com.haoze.admin.service.impl;

import com.haoze.admin.mapper.OrganizationMapper;
import com.haoze.admin.mapper.UserOrganizationMapper;
import com.haoze.admin.model.OrganizationEntity;
import com.haoze.admin.model.UserOrganizationEntity;
import com.haoze.admin.service.OrganizationService;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.ChineseCharactersCode;
import com.haoze.common.utils.UUIDUtil;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author shenjun
 * @date 2019/02/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrganizationServiceImpl extends AbstractService<OrganizationEntity> implements OrganizationService {
    @Resource
    private OrganizationMapper organizationMapper;
    @Resource
    private UserOrganizationMapper userOrganizationMapper;

    @Override
    public void update(OrganizationEntity entity) {
        int targetSort = 1;
        if (StringUtils.isNotBlank(entity.getToSort())) {
            targetSort = Integer.parseInt(entity.getToSort());
        } else {
            targetSort = Integer.parseInt(organizationMapper.selectByPrimaryKey(entity.getToId()).getToSort());
        }

        //查询该父节点下的排序
        int count = 1;
        Condition condition = new Condition(OrganizationEntity.class);
        condition.setOrderByClause("TO_SORT desc");
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("parentToId", entity.getParentToId());
        List<OrganizationEntity> sortList = organizationMapper.selectByCondition(condition);
        if(sortList.size() > 0){
            count = Integer.parseInt(sortList.get(0).getToSort());
        }

        // 查询原节点排序号
        OrganizationEntity oldSort = organizationMapper.selectByPrimaryKey(entity.getToId());
        int currentSortNo = Integer.parseInt(oldSort.getToSort());

        if (targetSort < 1) {
            targetSort = 1;
        }
        if (targetSort > count) {
            targetSort = count;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("parentId", entity.getParentToId());
        map.put("targetSortNo", targetSort);
        map.put("currentSortNo", currentSortNo);
        if(targetSort > currentSortNo){
            organizationMapper.updateSortNoForReduce(map);
        }else if(targetSort < currentSortNo){
            organizationMapper.updateSortNoForEnlarge(map);
        }

        try {
            entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getOrganizationName()));
            entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getOrganizationName()));
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        entity.setToSort(String.valueOf(targetSort));
        organizationMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void save(OrganizationEntity entity) {
        entity.setToId(UUIDUtil.randomString());
        entity.initAdd();
        if(entity.getParentToId() == null){
            entity.setParentToId("0");
        }
        //查询该父节点下的排序
        Condition condition = new Condition(OrganizationEntity.class);
        condition.setOrderByClause("TO_SORT desc");
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("parentToId", entity.getParentToId());
        List<OrganizationEntity> sortList = organizationMapper.selectByCondition(condition);
        int count = 1;
        if(sortList.size() > 0){
            count = Integer.parseInt(sortList.get(0).getToSort()) + 1;
        }
        entity.setToSort(String.valueOf(count));
        try {
            entity.setPyCode(ChineseCharactersCode.getPinyinCode(entity.getOrganizationName()));
            entity.setWbCode(ChineseCharactersCode.getWBCode(entity.getOrganizationName()));
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        //设置机构编码
        entity.setOrganizationCode("DEPT" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int)((Math.random()*9+1)*100000));
        organizationMapper.insertSelective(entity);
    }

    @Override
    public void deleteById(Object id) {
        //删除用户组织关联数据
        Condition relaCondition = new Condition(UserOrganizationEntity.class);
        Example.Criteria relaCriteria = relaCondition.createCriteria();
        relaCriteria.andEqualTo("toId", id);
        userOrganizationMapper.deleteByCondition(relaCondition);
        Condition condition = new Condition(OrganizationEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("parentToId", id);
        //删除子记录
        organizationMapper.deleteByCondition(condition);
        organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int countUserOrganizationByToId(String toId) {
        return organizationMapper.countUserOrganizationByToId(toId);
    }

    @Override
    public void test() {

    }

}
