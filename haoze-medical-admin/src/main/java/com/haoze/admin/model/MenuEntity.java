package com.haoze.admin.model;

import com.haoze.common.model.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 菜单实体
 * @author shenjun
 * @date 2019-2-27
 * */
@Table(name = "T_MENU")
public class MenuEntity extends BaseEntity {

  @Id
  @Column(name = "TM_ID")
  private String tmId;//菜单ID

  @Column(name = "MENU_CODE")
  private String menuCode;//菜单编码

  @Column(name = "MENU_NAME")
  private String menuName;//菜单名

  @Column(name = "PARENT_MENU_ID")
  private String parentMenuId;//上级菜单ID

  @Column(name = "BASIC_MENU_FLAG")
  private String basicMenuFlag;//标准菜单标识

  @Column(name = "MODEL_TYPE_FLAG")
  private String modelTypeFlag;//菜单类型标识

  @Column(name = "MENU_SORT")
  private String menuSort;//菜单排序

  @Column(name = "DISPLAY_FLAG")
  private String displayFlag;//显示标识

  @Column(name = "PY_CODE")
  private String pyCode;//拼音码

  @Column(name = "WB_CODE")
  private String wbCode;//五笔码

  @Column(name = "MENU_LEVEL")
  private double menuLevel;//菜单级别

  @Column(name = "SYS_TYPE")
  private String sysType;//系统类别

  @Column(name = "MENU_URL")
  private String menuUrl;//菜单指向地址

  @Column(name = "MENU_ICON")
  private String menuIcon;//菜单图标

  @Column(name = "ACTION_TYPE")
  private String actionType;//操作类型

  @Column(name = "ROUTE_NAME")
  private String routeName;//动态路由

  @Column(name = "MENU_PERMISSION")
  private String menuPermission;//菜单权限标识


  public String getTmId() {
    return tmId;
  }

  public void setTmId(String tmId) {
    this.tmId = tmId;
  }


  public String getMenuCode() {
    return menuCode;
  }

  public void setMenuCode(String menuCode) {
    this.menuCode = menuCode;
  }


  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }


  public String getParentMenuId() {
    return parentMenuId;
  }

  public void setParentMenuId(String parentMenuId) {
    this.parentMenuId = parentMenuId;
  }


  public String getBasicMenuFlag() {
    return basicMenuFlag;
  }

  public void setBasicMenuFlag(String basicMenuFlag) {
    this.basicMenuFlag = basicMenuFlag;
  }


  public String getModelTypeFlag() {
    return modelTypeFlag;
  }

  public void setModelTypeFlag(String modelTypeFlag) {
    this.modelTypeFlag = modelTypeFlag;
  }


  public String getMenuSort() {
    return menuSort;
  }

  public void setMenuSort(String menuSort) {
    this.menuSort = menuSort;
  }


  public String getDisplayFlag() {
    return displayFlag;
  }

  public void setDisplayFlag(String displayFlag) {
    this.displayFlag = displayFlag;
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


  public double getMenuLevel() {
    return menuLevel;
  }

  public void setMenuLevel(double menuLevel) {
    this.menuLevel = menuLevel;
  }


  public String getSysType() {
    return sysType;
  }

  public void setSysType(String sysType) {
    this.sysType = sysType;
  }


  public String getMenuUrl() {
    return menuUrl;
  }

  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }


  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }


  public String getActionType() {
    return actionType;
  }

  public void setActionType(String actionType) {
    this.actionType = actionType;
  }


  public String getRouteName() {
    return routeName;
  }

  public void setRouteName(String routeName) {
    this.routeName = routeName;
  }


  public String getMenuPermission() {
    return menuPermission;
  }

  public void setMenuPermission(String menuPermission) {
    this.menuPermission = menuPermission;
  }

}
