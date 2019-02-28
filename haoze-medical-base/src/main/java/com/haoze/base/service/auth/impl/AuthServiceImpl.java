package com.haoze.base.service.auth.impl;

import com.haoze.base.mapper.auth.AuthMapper;
import com.haoze.base.service.auth.AuthService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author yangyb
 * @date 2018/06/09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {
    @Resource
    private AuthMapper authMapper;

    @Override
    public boolean hasRole(String account, String role) {
        if (StringUtils.isEmpty(role)) {
            return true;
        } else {
            String[] rolesArray = role.split(",");
            List<String> roleList = Arrays.asList(rolesArray);
            int count = authMapper.countRole(account, roleList);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean hasPermission(String account, String permission) {
        if (StringUtils.isEmpty(permission)) {
            return true;
        } else {
            String[] permissionsArray = permission.split(",");
            List<String> permissionList = Arrays.asList(permissionsArray);
            int count = authMapper.countPermission(account, permissionList);
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
