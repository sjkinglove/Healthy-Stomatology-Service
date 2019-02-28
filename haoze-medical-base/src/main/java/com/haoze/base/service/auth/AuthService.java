package com.haoze.base.service.auth;


/**
 * @author yangyb
 * @date 2018/06/09
 */
public interface AuthService {

    boolean hasRole(String account, String role);

    boolean hasPermission(String account, String permission);
}
