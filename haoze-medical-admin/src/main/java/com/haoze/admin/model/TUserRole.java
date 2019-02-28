package com.haoze.admin.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色实体
 * @author shenjun
 * @date 2019/2/27
 */
@Table(name = "T_USER_ROLE")
public class TUserRole extends BaseEntity {

  @Id
  @Column(name = "TUR_ID")
  private String turId;//用户角色ID

  @Column(name = "TU_ID")
  private String tuId;//用户ID

  @Column(name = "TR_ID")
  private String trId;//角色ID

  @Column(name = "USER_ROLE_SORT")
  private String userRoleSort;//排序


  public String getTurId() {
    return turId;
  }

  public void setTurId(String turId) {
    this.turId = turId;
  }


  public String getTuId() {
    return tuId;
  }

  public void setTuId(String tuId) {
    this.tuId = tuId;
  }


  public String getTrId() {
    return trId;
  }

  public void setTrId(String trId) {
    this.trId = trId;
  }


  public String getUserRoleSort() {
    return userRoleSort;
  }

  public void setUserRoleSort(String userRoleSort) {
    this.userRoleSort = userRoleSort;
  }

}
