package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 地区实体
 * @author shenjun
 * @date 2019/3/5
 */
@Table(name = "T_AREA")
public class AreaEntity extends BaseEntity {
  @Id
  @Column(name = "TA_ID")
  private String taId;

  @Column(name = "AREA_CODE")
  private String areaCode;

  @Column(name = "AREA_NAME")
  private String areaName;

  @Column(name = "parent_Ta_Id")
  private String parentTaId;

  @Column(name = "ORGANIZATION_ID")
  private String organizationId;


  public String getTaId() {
    return taId;
  }

  public void setTaId(String taId) {
    this.taId = taId;
  }


  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }


  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }


  public String getParentTaId() {
    return parentTaId;
  }

  public void setParentTaId(String parentTaId) {
    this.parentTaId = parentTaId;
  }


  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

}
