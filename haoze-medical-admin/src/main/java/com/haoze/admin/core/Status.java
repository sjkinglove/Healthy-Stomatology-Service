package com.haoze.admin.core;
/**
 * @author shenjun
 * @date 2019/3/4
 */
public enum Status {
    SCUUESS("1", "成功"), FAILED("2", "失败"),
    INIT_CLICK_NUM("0","归零"),DEFAULT_PASSWORD("123123","默认密码"),
    OPEN_FLAG("0","开启"),CLOSE_FLAG("1","关闭");

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


    private Status(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
