package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 牙面检查记录实体
 * @author shenjun
 * @date 2019/3/5
 */

public class TeethSurfaceRecordEntity extends BaseEntity {

  private String ttsrId;
  private String ttcrId;
  private String teethSurfaceState;
  private String teethSurfaceStatName;
  private String teethSurfaceCode;
  private String teethSurfaceName;
  private String sealingCase;
  private String sealingCaseCode;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String dataVersion;
  private String organizationId;


  public String getTtsrId() {
    return ttsrId;
  }

  public void setTtsrId(String ttsrId) {
    this.ttsrId = ttsrId;
  }


  public String getTtcrId() {
    return ttcrId;
  }

  public void setTtcrId(String ttcrId) {
    this.ttcrId = ttcrId;
  }


  public String getTeethSurfaceState() {
    return teethSurfaceState;
  }

  public void setTeethSurfaceState(String teethSurfaceState) {
    this.teethSurfaceState = teethSurfaceState;
  }


  public String getTeethSurfaceStatName() {
    return teethSurfaceStatName;
  }

  public void setTeethSurfaceStatName(String teethSurfaceStatName) {
    this.teethSurfaceStatName = teethSurfaceStatName;
  }


  public String getTeethSurfaceCode() {
    return teethSurfaceCode;
  }

  public void setTeethSurfaceCode(String teethSurfaceCode) {
    this.teethSurfaceCode = teethSurfaceCode;
  }


  public String getTeethSurfaceName() {
    return teethSurfaceName;
  }

  public void setTeethSurfaceName(String teethSurfaceName) {
    this.teethSurfaceName = teethSurfaceName;
  }


  public String getSealingCase() {
    return sealingCase;
  }

  public void setSealingCase(String sealingCase) {
    this.sealingCase = sealingCase;
  }


  public String getSealingCaseCode() {
    return sealingCaseCode;
  }

  public void setSealingCaseCode(String sealingCaseCode) {
    this.sealingCaseCode = sealingCaseCode;
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


  public String getDataVersion() {
    return dataVersion;
  }

  public void setDataVersion(String dataVersion) {
    this.dataVersion = dataVersion;
  }


  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

}
