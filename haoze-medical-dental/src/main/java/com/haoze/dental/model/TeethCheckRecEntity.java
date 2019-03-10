package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 牙齿检查记录表
 * @author shenjun
 * @date 2019/3/5
 */
//@Table(name = "T_AREA")
public class TeethCheckRecEntity extends BaseEntity {
//  @Id
//  @Column(name = "taId")
  private String ttcrId;
  private String tmcrId;
  private String teethCode;
  private String teethNo;
  private String teethStat;
  private String teethStatName;
  private String teethOpt;
  private String teethOptName;
  private String teethName;
  private double teethSurfNum;
  private String teethGum;
  private String teethGumName;
  private String teethGrowType;
  private String teethGrowName;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String isWgfb;
  private String isWgfbCode;
  private String finishWgfb;
  private String finishWgfbCode;
  private String dataVersion;
  private String organizationId;


  public String getTtcrId() {
    return ttcrId;
  }

  public void setTtcrId(String ttcrId) {
    this.ttcrId = ttcrId;
  }


  public String getTmcrId() {
    return tmcrId;
  }

  public void setTmcrId(String tmcrId) {
    this.tmcrId = tmcrId;
  }


  public String getTeethCode() {
    return teethCode;
  }

  public void setTeethCode(String teethCode) {
    this.teethCode = teethCode;
  }


  public String getTeethNo() {
    return teethNo;
  }

  public void setTeethNo(String teethNo) {
    this.teethNo = teethNo;
  }


  public String getTeethStat() {
    return teethStat;
  }

  public void setTeethStat(String teethStat) {
    this.teethStat = teethStat;
  }


  public String getTeethStatName() {
    return teethStatName;
  }

  public void setTeethStatName(String teethStatName) {
    this.teethStatName = teethStatName;
  }


  public String getTeethOpt() {
    return teethOpt;
  }

  public void setTeethOpt(String teethOpt) {
    this.teethOpt = teethOpt;
  }


  public String getTeethOptName() {
    return teethOptName;
  }

  public void setTeethOptName(String teethOptName) {
    this.teethOptName = teethOptName;
  }


  public String getTeethName() {
    return teethName;
  }

  public void setTeethName(String teethName) {
    this.teethName = teethName;
  }


  public double getTeethSurfNum() {
    return teethSurfNum;
  }

  public void setTeethSurfNum(double teethSurfNum) {
    this.teethSurfNum = teethSurfNum;
  }


  public String getTeethGum() {
    return teethGum;
  }

  public void setTeethGum(String teethGum) {
    this.teethGum = teethGum;
  }


  public String getTeethGumName() {
    return teethGumName;
  }

  public void setTeethGumName(String teethGumName) {
    this.teethGumName = teethGumName;
  }


  public String getTeethGrowType() {
    return teethGrowType;
  }

  public void setTeethGrowType(String teethGrowType) {
    this.teethGrowType = teethGrowType;
  }


  public String getTeethGrowName() {
    return teethGrowName;
  }

  public void setTeethGrowName(String teethGrowName) {
    this.teethGrowName = teethGrowName;
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


  public String getIsWgfb() {
    return isWgfb;
  }

  public void setIsWgfb(String isWgfb) {
    this.isWgfb = isWgfb;
  }


  public String getIsWgfbCode() {
    return isWgfbCode;
  }

  public void setIsWgfbCode(String isWgfbCode) {
    this.isWgfbCode = isWgfbCode;
  }


  public String getFinishWgfb() {
    return finishWgfb;
  }

  public void setFinishWgfb(String finishWgfb) {
    this.finishWgfb = finishWgfb;
  }


  public String getFinishWgfbCode() {
    return finishWgfbCode;
  }

  public void setFinishWgfbCode(String finishWgfbCode) {
    this.finishWgfbCode = finishWgfbCode;
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
