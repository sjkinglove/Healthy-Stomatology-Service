package com.haoze.admin.dto.system;

public class OrganizationDTO {

    private String toId;//机构ID

    private String organizationCode;//机构编码

    private String organizationName;//机构名

    private String organizationAddress;//机构地址

    private String organizationClass;//机构类型

    private double organizationClassId;//机构类型编码

    private String pyCode;//拼音码

    private String wbCode;//五笔码

    private String stopFlag;//停用标识

    private String parentToId;//上级机构ID

    private String toSort;//排序

    private String loginName;//登录名

    private String password;

    private String roleId;

    private String roleName;

    private String phone;


    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }


    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }


    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }


    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }


    public String getOrganizationClass() {
        return organizationClass;
    }

    public void setOrganizationClass(String organizationClass) {
        this.organizationClass = organizationClass;
    }


    public double getOrganizationClassId() {
        return organizationClassId;
    }

    public void setOrganizationClassId(double organizationClassId) {
        this.organizationClassId = organizationClassId;
    }


    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }


    public String getWbCode() {
        return wbCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode;
    }


    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }


    public String getParentToId() {
        return parentToId;
    }

    public void setParentToId(String parentToId) {
        this.parentToId = parentToId;
    }


    public String getToSort() {
        return toSort;
    }

    public void setToSort(String toSort) {
        this.toSort = toSort;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
