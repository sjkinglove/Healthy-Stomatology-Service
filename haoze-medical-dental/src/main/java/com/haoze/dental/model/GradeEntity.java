package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 年级实体
 * @author shenjun
 * @date 2019/3/5
 */

public class GradeEntity extends BaseEntity {

  private String tgId;
  private String dataVersion;
  private String gradeCode;
  private String gradeName;
  private String gradeNo;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String tsId;
  private String organizationId;


  public String getTgId() {
    return tgId;
  }

  public void setTgId(String tgId) {
    this.tgId = tgId;
  }


  public String getDataVersion() {
    return dataVersion;
  }

  public void setDataVersion(String dataVersion) {
    this.dataVersion = dataVersion;
  }


  public String getGradeCode() {
    return gradeCode;
  }

  public void setGradeCode(String gradeCode) {
    this.gradeCode = gradeCode;
  }


  public String getGradeName() {
    return gradeName;
  }

  public void setGradeName(String gradeName) {
    this.gradeName = gradeName;
  }


  public String getGradeNo() {
    return gradeNo;
  }

  public void setGradeNo(String gradeNo) {
    this.gradeNo = gradeNo;
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


  public String getTsId() {
    return tsId;
  }

  public void setTsId(String tsId) {
    this.tsId = tsId;
  }


  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

}
