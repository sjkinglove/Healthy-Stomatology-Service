package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人员抽查表
 * @author shenjun
 * @date 2019/3/5
 */

public class PersonSpotEntity extends BaseEntity {

  private String tpsId;
  private String tsrId;
  private String tpId;
  private String sealingTeethState;
  private String sealingTeethStateCode;
  private double sealingTeethPersent;
  private String deleteFalg;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String organizationId;
  private String dataVersion;


  public String getTpsId() {
    return tpsId;
  }

  public void setTpsId(String tpsId) {
    this.tpsId = tpsId;
  }


  public String getTsrId() {
    return tsrId;
  }

  public void setTsrId(String tsrId) {
    this.tsrId = tsrId;
  }


  public String getTpId() {
    return tpId;
  }

  public void setTpId(String tpId) {
    this.tpId = tpId;
  }


  public String getSealingTeethState() {
    return sealingTeethState;
  }

  public void setSealingTeethState(String sealingTeethState) {
    this.sealingTeethState = sealingTeethState;
  }


  public String getSealingTeethStateCode() {
    return sealingTeethStateCode;
  }

  public void setSealingTeethStateCode(String sealingTeethStateCode) {
    this.sealingTeethStateCode = sealingTeethStateCode;
  }


  public double getSealingTeethPersent() {
    return sealingTeethPersent;
  }

  public void setSealingTeethPersent(double sealingTeethPersent) {
    this.sealingTeethPersent = sealingTeethPersent;
  }


  public String getDeleteFalg() {
    return deleteFalg;
  }

  public void setDeleteFalg(String deleteFalg) {
    this.deleteFalg = deleteFalg;
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


  public String getDataVersion() {
    return dataVersion;
  }

  public void setDataVersion(String dataVersion) {
    this.dataVersion = dataVersion;
  }

}
