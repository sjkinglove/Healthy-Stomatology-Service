package com.haoze.admin.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户机构实体
 * @author shenjun
 * @date 2019/2/27
 */
@Table(name = "T_USER_ORGANIZATION")
public class UserOrganizationEntity extends BaseEntity {

  @Id
  @Column(name = "TUO_ID")
  private String tuoId;//用户机构ID

  @Column(name = "TO_ID")
  private String toId;//机构ID

  @Column(name = "TU_ID")
  private String tuId;//用户ID

  @Column(name = "DEFAULT_FLAG")
  private String defaultFlag;//默认机构标识


  public String getTuoId() {
    return tuoId;
  }

  public void setTuoId(String tuoId) {
    this.tuoId = tuoId;
  }


  public String getToId() {
    return toId;
  }

  public void setToId(String toId) {
    this.toId = toId;
  }


  public String getTuId() {
    return tuId;
  }

  public void setTuId(String tuId) {
    this.tuId = tuId;
  }


  public String getDefaultFlag() {
    return defaultFlag;
  }

  public void setDefaultFlag(String defaultFlag) {
    this.defaultFlag = defaultFlag;
  }

}
