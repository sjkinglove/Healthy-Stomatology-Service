package com.haoze.admin.service;

import com.haoze.admin.model.OrganizationEntity;
import com.haoze.common.service.Service;

public interface OrganizationService extends Service<OrganizationEntity> {
    /**
     * 根据机构ID查询机构用户数
     *
     * @return 用户数
     */
    int countUserOrganizationByToId(String toId);

    void test();
}
