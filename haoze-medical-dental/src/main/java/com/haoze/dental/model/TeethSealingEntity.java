package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 抽样调查牙齿封闭记录表
 * @author shenjun
 * @date 2019/3/5
 */

public class TeethSealingEntity extends BaseEntity {

  private String ttsId;
  private String tpsId;
  private String teethSurfaceState;
  private String teethSurfaceStateName;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String judge;
  private String organizationId;
  private String dataVersion;


  public String getTtsId() {
    return ttsId;
  }

  public void setTtsId(String ttsId) {
    this.ttsId = ttsId;
  }


  public String getTpsId() {
    return tpsId;
  }

  public void setTpsId(String tpsId) {
    this.tpsId = tpsId;
  }


  public String getTeethSurfaceState() {
    return teethSurfaceState;
  }

  public void setTeethSurfaceState(String teethSurfaceState) {
    this.teethSurfaceState = teethSurfaceState;
  }


  public String getTeethSurfaceStateName() {
    return teethSurfaceStateName;
  }

  public void setTeethSurfaceStateName(String teethSurfaceStateName) {
    this.teethSurfaceStateName = teethSurfaceStateName;
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


  public String getJudge() {
    return judge;
  }

  public void setJudge(String judge) {
    this.judge = judge;
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
