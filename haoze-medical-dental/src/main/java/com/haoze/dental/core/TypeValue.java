package com.haoze.dental.core;
/**
 * @author shenjun
 * @date 2019/3/4
 */
public enum TypeValue {
    TYPE_ZERO("0","0"),
    TYPE_ONE("1","1"),
    TYPE_TWO("2","2"),
    TYPE_THREE("3","3"),
    TYPE_FOUR("4","4"),
    TYPE_FIVE("5","5");



    private String value;

    private String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    private TypeValue(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
