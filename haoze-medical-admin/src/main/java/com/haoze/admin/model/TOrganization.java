package com.haoze.admin.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 机构实体
 * @author shenjun
 * @date 2019/2/27
 */
@Table(name = "T_ORGANIZATION")
public class TOrganization extends BaseEntity {

  @Id
  @Column(name = "TO_ID")
  private String toId;//机构ID

  @Column(name = "ORGANIZATION_CODE")
  private String organizationCode;//机构编码

  @Column(name = "ORGANIZATION_NAME")
  private String organizationName;//机构名

  @Column(name = "ORGANIZATION_ADDRESS")
  private String organizationAddress;//机构地址

  @Column(name = "ORGANIZATION_CLASS")
  private String organizationClass;//机构类型

  @Column(name = "ORGANIZATION_CLASS_ID")
  private double organizationClassId;//机构类型ID

  @Column(name = "PY_CODE")
  private String pyCode;//拼音码

  @Column(name = "WB_CODE")
  private String wbCode;//五笔码

  @Column(name = "STOP_FLAG")
  private String stopFlag;//停用标识

  @Column(name = "PARENT_TO_ID")
  private String parentToId;//上级机构ID

  @Column(name = "TO_SORT")
  private String toSort;//排序


  public String getToId() {
    return toId;
  }

  public void setToId(String toId) {
    this.toId = toId;
  }


  public String getOrganizationCode() {
    return organizationCode;
  }

  public void setOrganizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
  }


  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }


  public String getOrganizationAddress() {
    return organizationAddress;
  }

  public void setOrganizationAddress(String organizationAddress) {
    this.organizationAddress = organizationAddress;
  }


  public String getOrganizationClass() {
    return organizationClass;
  }

  public void setOrganizationClass(String organizationClass) {
    this.organizationClass = organizationClass;
  }


  public double getOrganizationClassId() {
    return organizationClassId;
  }

  public void setOrganizationClassId(double organizationClassId) {
    this.organizationClassId = organizationClassId;
  }


  public String getPyCode() {
    return pyCode;
  }

  public void setPyCode(String pyCode) {
    this.pyCode = pyCode;
  }


  public String getWbCode() {
    return wbCode;
  }

  public void setWbCode(String wbCode) {
    this.wbCode = wbCode;
  }


  public String getStopFlag() {
    return stopFlag;
  }

  public void setStopFlag(String stopFlag) {
    this.stopFlag = stopFlag;
  }


  public String getParentToId() {
    return parentToId;
  }

  public void setParentToId(String parentToId) {
    this.parentToId = parentToId;
  }


  public String getToSort() {
    return toSort;
  }

  public void setToSort(String toSort) {
    this.toSort = toSort;
  }

}
