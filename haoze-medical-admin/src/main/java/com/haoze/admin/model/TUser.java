package com.haoze.admin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 用户实体
 * @author shenjun
 * @date 2019/2/27
 */
@Table(name = "T_USER")
public class TUser extends BaseEntity {

  @Id
  @Column(name = "TU_ID")
  private String tuId;//用户ID

  @Column(name = "LOGIN_NAME")
  @NotEmpty(message = "账号不能为空")
  private String loginName;//账号

  @Column(name = "USER_PWD")
  @JSONField(serialize = false)
  @NotEmpty(message = "密码不能为空")
  @Size(min = 6, message = "密码长度不能小于6")
  private String userPwd;//密码

  @Column(name = "USER_NAME")
  @NotEmpty(message = "用户名不能为空")
  private String userName;//用户姓名

  @Column(name = "LOCK_FLAG")
  private String lockFlag;//锁定标识

  @Column(name = "USER_TYPES")
  private String userTypes;//用户类型

  @Column(name = "END_DATE")
  private Date endDate;//使用截止时间

  @Column(name = "ON_LINE")
  private String onLine;//在线标识

  @Column(name = "IMAGE")
  private String image;/// 图像文件标识


  public String getTuId() {
    return tuId;
  }

  public void setTuId(String tuId) {
    this.tuId = tuId;
  }


  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }


  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getLockFlag() {
    return lockFlag;
  }

  public void setLockFlag(String lockFlag) {
    this.lockFlag = lockFlag;
  }


  public String getUserTypes() {
    return userTypes;
  }

  public void setUserTypes(String userTypes) {
    this.userTypes = userTypes;
  }


  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }


  public String getOnLine() {
    return onLine;
  }

  public void setOnLine(String onLine) {
    this.onLine = onLine;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

}
