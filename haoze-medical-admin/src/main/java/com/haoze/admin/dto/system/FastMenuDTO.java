package com.haoze.admin.dto.system;

import java.util.Date;

/**
 * 快速通道实体
 * @author shenjun
 * @date 2019/2/27
 */

public class FastMenuDTO {

    private String tfmId;//快速通道ID

    private String tmId;//菜单ID

    private String trId;//角色ID

    private String toId;//机构ID

    private String fastMenuName;//快速菜单名

    private String openState;//启用状态

    private double clickNum;//点击次数

    private String fastMenuSort;//快速菜单排序

    private String dataVersion;//数据版本

    private Date createTime;//创建时间

    private Date modifyTime;//修改时间

    private String remark;//备注

    private String menuUrl;//菜单地址

    private String menuType;//菜单类型

    private String tuId;//用户ID

    private String fastMenuUrl;//快捷菜单地址

    private String fastMenuType;//快捷菜单类型

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

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void initUpdate(){
        this.setModifyTime(new Date());
    }

    public void initAdd() {
        this.setDataVersion("1.0");
        this.setCreateTime(new Date());
        this.setModifyTime(new Date());
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
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

    public String getTuId() {
        return tuId;
    }

    public void setTuId(String tuId) {
        this.tuId = tuId;
    }

    public String getFastMenuUrl() {
        return fastMenuUrl;
    }

    public void setFastMenuUrl(String fastMenuUrl) {
        this.fastMenuUrl = fastMenuUrl;
    }

    public String getFastMenuType() {
        return fastMenuType;
    }

    public void setFastMenuType(String fastMenuType) {
        this.fastMenuType = fastMenuType;
    }
}
