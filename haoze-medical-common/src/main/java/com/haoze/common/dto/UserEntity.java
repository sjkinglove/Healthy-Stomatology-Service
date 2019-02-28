package com.haoze.common.dto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author yangyb
 * @date 2018/12/6
 */
@Table(name = "sys_user")
public class UserEntity {

    // 用户名
    @Column(name = "name")
    @NotEmpty(message = "用户名不能为空")
    private String name;

    // 账号
    @Column(name = "account")
    @NotEmpty(message = "账号不能为空")
    private String account;

    // 邮箱
    @Column(name = "email")
    @Email
    private String email;

    // 手机号
    @Column(name = "phone_number")
    private String phoneNumber;

    // 密码
    @Column(name = "password")
    @JSONField(serialize = false)
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能小于6")
    private String password;

    // 备注
    @Column(name = "resume")
    private String resume;

    // 上一次登录时间
    @Column(name = "login_time")
    private Date loginTime;

    /*---------- 以下字段来自联表查询 ------------*/
    // 用户的角色Id
    @Transient
    private String roleId;

    // 用户的角色code
    @Transient
    private String roleCode;

    // 用户的部门id
    @Transient
    private String departmentId;

    // 用户的部门idArr
    @Transient
    private String departmentIds;

    // 用户的角色Id
    @Transient
    private String monitorCount;

    // 用户的角色名
    @Transient
    private String roleName;

    // 用户的角色对应的权限code
    @Transient
    private List<String> permissionCodeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMonitorCount() {
        return monitorCount;
    }

    public void setMonitorCount(String monitorCount) {
        this.monitorCount = monitorCount;
    }

    public List<String> getPermissionCodeList() {
        return permissionCodeList;
    }

    public void setPermissionCodeList(List<String> permissionCodeList) {
        this.permissionCodeList = permissionCodeList;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(String departmentIds) {
        this.departmentIds = departmentIds;
    }
}