package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学校实体
 * @author shenjun
 * @date 2019/3/5
 */

public class SchoolEntity extends BaseEntity {

  private String tsId;
  private String dataVersion;
  private String schoolCode;
  private String schoolName;
  private String taId;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String organizationId;


  public String getTsId() {
    return tsId;
  }

  public void setTsId(String tsId) {
    this.tsId = tsId;
  }


  public String getDataVersion() {
    return dataVersion;
  }

  public void setDataVersion(String dataVersion) {
    this.dataVersion = dataVersion;
  }


  public String getSchoolCode() {
    return schoolCode;
  }

  public void setSchoolCode(String schoolCode) {
    this.schoolCode = schoolCode;
  }


  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }


  public String getTaId() {
    return taId;
  }

  public void setTaId(String taId) {
    this.taId = taId;
  }


  public java.sql.Timestamp getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(java.sql.Timestamp gmtCreate) {
    this.gmtCreate = gmtCreate;
  }


  public java.sql.Timestamp getGmtModify() {
    return gmtModify;
  }

  public void setGmtModify(java.sql.Timestamp gmtModify) {
    this.gmtModify = gmtModify;
  }


  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

}
