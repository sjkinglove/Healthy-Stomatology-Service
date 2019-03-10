package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 班级实体
 * @author shenjun
 * @date 2019/3/5
 */

public class ClassEntity extends BaseEntity {

  private String tcId;
  private String dataVersion;
  private String tsId;
  private String classCode;
  private String className;
  private String classDue;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String tgId;
  private String organizationId;


  public String getTcId() {
    return tcId;
  }

  public void setTcId(String tcId) {
    this.tcId = tcId;
  }


  public String getDataVersion() {
    return dataVersion;
  }

  public void setDataVersion(String dataVersion) {
    this.dataVersion = dataVersion;
  }


  public String getTsId() {
    return tsId;
  }

  public void setTsId(String tsId) {
    this.tsId = tsId;
  }


  public String getClassCode() {
    return classCode;
  }

  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public String getClassDue() {
    return classDue;
  }

  public void setClassDue(String classDue) {
    this.classDue = classDue;
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


  public String getTgId() {
    return tgId;
  }

  public void setTgId(String tgId) {
    this.tgId = tgId;
  }


  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

}
