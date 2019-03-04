package com.haoze.admin.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色实体
 * @author shenjun
 * @date 2019/2/27
 */
@Table(name = "T_ROLE")
public class RoleEntity extends BaseEntity {

  @Id
  @Column(name = "TR_ID")
  private String trId;//角色ID

  @Column(name = "ROLE_CODE")
  private String roleCode;//角色代码

  @Column(name = "ROLE_NAME")
  private String roleName;//角色名

  @Column(name = "STOP_FLAG")
  private String stopFlag;//停用标识

  @Column(name = "PY_CODE")
  private String pyCode;//拼音码

  @Column(name = "WB_CODE")
  private String wbCode;//五笔码

  @Column(name = "ROLE_LEVEL")
  private String roleLevel;//角色等级

  @Column(name = "REMARK")
  private String remark;//角色等级


  public String getTrId() {
    return trId;
  }

  public void setTrId(String trId) {
    this.trId = trId;
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


  public String getStopFlag() {
    return stopFlag;
  }

  public void setStopFlag(String stopFlag) {
    this.stopFlag = stopFlag;
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

  public String getRoleLevel() {
    return roleLevel;
  }

  public void setRoleLevel(String roleLevel) {
    this.roleLevel = roleLevel;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
