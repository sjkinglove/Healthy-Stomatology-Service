package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 人员表
 * @author shenjun
 * @date 2019/3/5
 */
@Table(name = "T_PERSON")
public class PersonEntity extends BaseEntity {
  @Id
  @Column(name = "TP_ID")
  private String tpId;

  @Column(name = "DOC_TYPE")
  private String docType;

  @Column(name = "PERSON_ACCOUNT")
  private String personAccount;

  @Column(name = "PERSON_NAME")
  private String personName;

  @Column(name = "PERSON_LOGO")
  private String personLogo;

  @Column(name = "ID_CARD")
  private String idCard;

  @Column(name = "GENDER")
  private String gender;

  @Column(name = "BIRTH_TIME")
  private Date birthTime;

  @Column(name = "NATION")
  private String nation;

  @Column(name = "MOBILE")
  private String mobile;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "CLASS_ID")
  private String classId;

  @Column(name = "SCHOOL_ID")
  private String schoolId;

  @Column(name = "AREA_ID")
  private String areaId;

  @Column(name = "AREA_NAME")
  private String areaName;

  @Column(name = "SCHOOL_NAME")
  private String schoolName;

  @Column(name = "CLASS_NAME")
  private String className;

  @Column(name = "GRADE_ID")
  private String gradeId;

  @Column(name = "GRADE_NAME")
  private String gradeName;

  @Column(name = "PY_CODE")
  private String pyCode;

  @Column(name = "WB_CODE")
  private String wbCode;

  @Column(name = "ORGANIZATION_ID")
  private String organizationId;

  @Column(name = "AGE")
  private Integer age;


  public String getTpId() {
    return tpId;
  }

  public void setTpId(String tpId) {
    this.tpId = tpId;
  }


  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }


  public String getPersonAccount() {
    return personAccount;
  }

  public void setPersonAccount(String personAccount) {
    this.personAccount = personAccount;
  }


  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }


  public String getPersonLogo() {
    return personLogo;
  }

  public void setPersonLogo(String personLogo) {
    this.personLogo = personLogo;
  }


  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }


  public String getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(String schoolId) {
    this.schoolId = schoolId;
  }


  public String getAreaId() {
    return areaId;
  }

  public void setAreaId(String areaId) {
    this.areaId = areaId;
  }


  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }


  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
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

  public Date getBirthTime() {
    return birthTime;
  }

  public void setBirthTime(Date birthTime) {
    this.birthTime = birthTime;
  }



  public String getGradeId() {
    return gradeId;
  }

  public void setGradeId(String gradeId) {
    this.gradeId = gradeId;
  }

  public String getGradeName() {
    return gradeName;
  }

  public void setGradeName(String gradeName) {
    this.gradeName = gradeName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
