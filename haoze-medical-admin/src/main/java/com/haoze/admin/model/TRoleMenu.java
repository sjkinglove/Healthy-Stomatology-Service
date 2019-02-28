package com.haoze.admin.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色菜单实体
 * @author shenjun
 * @date 2019/2/27
 */
@Table(name = "T_ROLE_MENU")
public class TRoleMenu extends BaseEntity {
  @Id
  @Column(name = "TRM_ID")
  private String trmId;//角色菜单ID

  @Column(name = "TR_ID")
  private String trId;//角色ID

  @Column(name = "TM_ID")
  private String tmId;//菜单ID


  public String getTrmId() {
    return trmId;
  }

  public void setTrmId(String trmId) {
    this.trmId = trmId;
  }


  public String getTrId() {
    return trId;
  }

  public void setTrId(String trId) {
    this.trId = trId;
  }


  public String getTmId() {
    return tmId;
  }

  public void setTmId(String tmId) {
    this.tmId = tmId;
  }

}
