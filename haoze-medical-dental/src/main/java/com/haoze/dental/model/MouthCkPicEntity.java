package com.haoze.dental.model;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 口腔检查图片表
 * @author shenjun
 * @date 2019/3/5
 */

public class MouthCkPicEntity extends BaseEntity {

  private String tmcpId;
  private String tmcrId;
  private String simplyPic;
  private String detailPic;
  private String teethGum;
  private String teethGumName;
  private String picIntroduce;
  private String dataVersion;
  private String organizationId;


  public String getTmcpId() {
    return tmcpId;
  }

  public void setTmcpId(String tmcpId) {
    this.tmcpId = tmcpId;
  }


  public String getTmcrId() {
    return tmcrId;
  }

  public void setTmcrId(String tmcrId) {
    this.tmcrId = tmcrId;
  }


  public String getSimplyPic() {
    return simplyPic;
  }

  public void setSimplyPic(String simplyPic) {
    this.simplyPic = simplyPic;
  }


  public String getDetailPic() {
    return detailPic;
  }

  public void setDetailPic(String detailPic) {
    this.detailPic = detailPic;
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


  public String getPicIntroduce() {
    return picIntroduce;
  }

  public void setPicIntroduce(String picIntroduce) {
    this.picIntroduce = picIntroduce;
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
