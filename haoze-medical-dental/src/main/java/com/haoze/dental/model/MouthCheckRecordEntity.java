package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 口腔检查记录实体
 * @author shenjun
 * @date 2019/3/5
 */

public class MouthCheckRecordEntity extends BaseEntity {

  private String tmcrId;
  private String checkCode;
  private String checkTypeName;
  private String idCard;
  private double teethTotal;
  private String problemTeeth;
  private double teethCount;
  private String resultSign;
  private String resultSignName;
  private String finalReport;
  private String checkPersonName;
  private String checkPersonId;
  private String bookPersonName;
  private String bookPersonId;
  private java.sql.Timestamp gmtCreate;
  private java.sql.Timestamp gmtModify;
  private String tcrId;
  private String tpId;
  private String nextCheck;
  private String nextCheckCode;
  private String dataVersion;
  private String organizationId;


  public String getTmcrId() {
    return tmcrId;
  }

  public void setTmcrId(String tmcrId) {
    this.tmcrId = tmcrId;
  }


  public String getCheckCode() {
    return checkCode;
  }

  public void setCheckCode(String checkCode) {
    this.checkCode = checkCode;
  }


  public String getCheckTypeName() {
    return checkTypeName;
  }

  public void setCheckTypeName(String checkTypeName) {
    this.checkTypeName = checkTypeName;
  }


  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }


  public double getTeethTotal() {
    return teethTotal;
  }

  public void setTeethTotal(double teethTotal) {
    this.teethTotal = teethTotal;
  }


  public String getProblemTeeth() {
    return problemTeeth;
  }

  public void setProblemTeeth(String problemTeeth) {
    this.problemTeeth = problemTeeth;
  }


  public double getTeethCount() {
    return teethCount;
  }

  public void setTeethCount(double teethCount) {
    this.teethCount = teethCount;
  }


  public String getResultSign() {
    return resultSign;
  }

  public void setResultSign(String resultSign) {
    this.resultSign = resultSign;
  }


  public String getResultSignName() {
    return resultSignName;
  }

  public void setResultSignName(String resultSignName) {
    this.resultSignName = resultSignName;
  }


  public String getFinalReport() {
    return finalReport;
  }

  public void setFinalReport(String finalReport) {
    this.finalReport = finalReport;
  }


  public String getCheckPersonName() {
    return checkPersonName;
  }

  public void setCheckPersonName(String checkPersonName) {
    this.checkPersonName = checkPersonName;
  }


  public String getCheckPersonId() {
    return checkPersonId;
  }

  public void setCheckPersonId(String checkPersonId) {
    this.checkPersonId = checkPersonId;
  }


  public String getBookPersonName() {
    return bookPersonName;
  }

  public void setBookPersonName(String bookPersonName) {
    this.bookPersonName = bookPersonName;
  }


  public String getBookPersonId() {
    return bookPersonId;
  }

  public void setBookPersonId(String bookPersonId) {
    this.bookPersonId = bookPersonId;
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


  public String getTcrId() {
    return tcrId;
  }

  public void setTcrId(String tcrId) {
    this.tcrId = tcrId;
  }


  public String getTpId() {
    return tpId;
  }

  public void setTpId(String tpId) {
    this.tpId = tpId;
  }


  public String getNextCheck() {
    return nextCheck;
  }

  public void setNextCheck(String nextCheck) {
    this.nextCheck = nextCheck;
  }


  public String getNextCheckCode() {
    return nextCheckCode;
  }

  public void setNextCheckCode(String nextCheckCode) {
    this.nextCheckCode = nextCheckCode;
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
