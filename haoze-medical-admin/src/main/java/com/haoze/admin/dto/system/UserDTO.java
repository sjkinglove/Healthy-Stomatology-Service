package com.haoze.admin.dto.system;

import java.util.Date;
import java.util.List;

public class UserDTO {

    private String id;

    private String name;// 用户姓名

    private String account;// 系统用户登录名

    private String password;// 用户密码

    private String organizationId;// 机构ID

    private String lockFlag;// 锁定标识

    private String userTypes;// 用户类型标识

    private Date endDate;// 失效日期

    private String userLine;// 在线标识

    private String image;// 图像文件标识

    private String dataVersion;//数据版本

    private Date createTime;

    private Date modifyTime;

    // 用户的角色Id
    private String roleId;

    // 用户的角色code
    private String roleCode;

    // 用户的部门idArr
    private String organizationIds;

    // 用户的角色名
    private String roleName;

    // 用户的角色对应的权限code
    private List<String> permissionCodeList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(String userTypes) {
        this.userTypes = userTypes;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUserLine() {
        return userLine;
    }

    public void setUserLine(String userLine) {
        this.userLine = userLine;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getPermissionCodeList() {
        return permissionCodeList;
    }

    public void setPermissionCodeList(List<String> permissionCodeList) {
        this.permissionCodeList = permissionCodeList;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }


    public void initAdd() {
        this.setDataVersion("1.0");
        this.setCreateTime(new Date());
        this.setModifyTime(new Date());
    }

    public void initUpdate() {
        this.setModifyTime(new Date());
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationIds() {
        return organizationIds;
    }

    public void setOrganizationIds(String organizationIds) {
        this.organizationIds = organizationIds;
    }
}
