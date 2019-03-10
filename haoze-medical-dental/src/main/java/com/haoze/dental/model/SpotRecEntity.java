package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 抽查记录表
 * @author shenjun
 * @date 2019/3/5
 */
//@Table(name = "T_AREA")
public class SpotRecEntity extends BaseEntity {
//  @Id
//  @Column(name = "tsrId")
  private String tsrId;
  private double teethClosePersent;
  private double samplingNum;
  private double inputNum;
  private double sealingPersonNum;
  private double uncloseTeetgNum;
  private double sealingTeethNum;
  private double inputTeethNum;
  private String tsId;
  private String tuId;
  private String userName;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String organizationId;


  public String getTsrId() {
    return tsrId;
  }

  public void setTsrId(String tsrId) {
    this.tsrId = tsrId;
  }


  public double getTeethClosePersent() {
    return teethClosePersent;
  }

  public void setTeethClosePersent(double teethClosePersent) {
    this.teethClosePersent = teethClosePersent;
  }


  public double getSamplingNum() {
    return samplingNum;
  }

  public void setSamplingNum(double samplingNum) {
    this.samplingNum = samplingNum;
  }


  public double getInputNum() {
    return inputNum;
  }

  public void setInputNum(double inputNum) {
    this.inputNum = inputNum;
  }


  public double getSealingPersonNum() {
    return sealingPersonNum;
  }

  public void setSealingPersonNum(double sealingPersonNum) {
    this.sealingPersonNum = sealingPersonNum;
  }


  public double getUncloseTeetgNum() {
    return uncloseTeetgNum;
  }

  public void setUncloseTeetgNum(double uncloseTeetgNum) {
    this.uncloseTeetgNum = uncloseTeetgNum;
  }


  public double getSealingTeethNum() {
    return sealingTeethNum;
  }

  public void setSealingTeethNum(double sealingTeethNum) {
    this.sealingTeethNum = sealingTeethNum;
  }


  public double getInputTeethNum() {
    return inputTeethNum;
  }

  public void setInputTeethNum(double inputTeethNum) {
    this.inputTeethNum = inputTeethNum;
  }


  public String getTsId() {
    return tsId;
  }

  public void setTsId(String tsId) {
    this.tsId = tsId;
  }


  public String getTuId() {
    return tuId;
  }

  public void setTuId(String tuId) {
    this.tuId = tuId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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
