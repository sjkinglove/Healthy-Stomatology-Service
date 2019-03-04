package com.haoze.admin.dto.system;

/**
 * 快速通道实体
 * @author shenjun
 * @date 2019/2/27
 */

public class FastMenuDTO {

    private String tfmId;//快速通道ID

    private String tmId;//菜单ID

    private String tuId;//用户ID

    private String fastMenuName;//快速菜单名

    private String openState;//启用状态

    private double clickNum;//点击次数

    private String fastMenuSort;//快速菜单排序

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


    public String getTuId() {
        return tuId;
    }

    public void setTuId(String tuId) {
        this.tuId = tuId;
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



}
