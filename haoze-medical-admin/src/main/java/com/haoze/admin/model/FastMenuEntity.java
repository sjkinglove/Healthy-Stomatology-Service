package com.haoze.admin.model;

import com.haoze.common.model.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 快速通道实体
 * @author shenjun
 * @date 2019/2/27
 */
@Table(name = "T_FAST_MENU")
public class FastMenuEntity extends BaseEntity {
  @Id
  @Column(name = "TFM_ID")
  private String tfmId;//快速通道ID

  @Column(name = "TM_ID")
  private String tmId;//菜单ID

  @Column(name = "TR_ID")
  private String trId;//角色ID

  @Column(name = "TO_ID")
  private String toId;//快速菜单排序

  @Column(name = "FAST_MENU_NAME")
  private String fastMenuName;//快速菜单名

  @Column(name = "OPEN_STATE")
  private String openState;//启用状态

  @Column(name = "CLICK_NUM")
  private double clickNum;//点击次数

  @Column(name = "FAST_MENU_SORT")
  private String fastMenuSort;//快速菜单排序

  @Column(name = "REMARK")
  private String remark;//快速菜单排序

  @Column(name = "FAST_MENU_URL")
  private String fastMenuUrl;//快速菜单排序

  public String getTfmId() {
    return tfmId;
  }

  public void setTfmId(String tfmId) {
    this.tfmId = tfmId;
  }


  public String getTmId() {
    return tmId;
  }

  public void setTmId(String tmId) {
    this.tmId = tmId;
  }



  public String getFastMenuName() {
    return fastMenuName;
  }

  public void setFastMenuName(String fastMenuName) {
    this.fastMenuName = fastMenuName;
  }


  public String getOpenState() {
    return openState;
  }

  public void setOpenState(String openState) {
    this.openState = openState;
  }


  public double getClickNum() {
    return clickNum;
  }

  public void setClickNum(double clickNum) {
    this.clickNum = clickNum;
  }


  public String getFastMenuSort() {
    return fastMenuSort;
  }

  public void setFastMenuSort(String fastMenuSort) {
    this.fastMenuSort = fastMenuSort;
  }

  public void initUpdate(){
    this.setModifyTime(new Date());
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getTrId() {
    return trId;
  }

  public void setTrId(String trId) {
    this.trId = trId;
  }

  public String getToId() {
    return toId;
  }

  public void setToId(String toId) {
    this.toId = toId;
  }

  public String getFastMenuUrl() {
    return fastMenuUrl;
  }

  public void setFastMenuUrl(String fastMenuUrl) {
    this.fastMenuUrl = fastMenuUrl;
  }
}
