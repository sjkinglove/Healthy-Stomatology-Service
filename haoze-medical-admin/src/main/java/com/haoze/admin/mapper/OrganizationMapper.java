package com.haoze.admin.mapper;


import com.haoze.admin.model.TOrganization;
import com.haoze.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface OrganizationMapper extends MyMapper<TOrganization> {

    void updateSortNoForEnlarge(Map<String, Object> map);

    void updateSortNoForReduce(Map<String, Object> map);

    int countUserOrganizationByToId(@Param("deptId") String deptId);

    String test();
}
