package com.haoze.common.model;


import javax.persistence.Column;
import java.util.Date;

/**
 * @author yangyb
 * @date 2018/12/6
 */
public class BaseEntity {

    @Column(name = "DATA_VERSION")
    protected String dataVersion;//数据版本

    @Column(name = "GMT_CREATE")
    protected Date createTime;

    @Column(name = "GMT_MODIFY")
    protected Date modifyTime;


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



    public void initAdd() {
        this.setDataVersion("1.0");
        this.setCreateTime(new Date());
        this.setModifyTime(new Date());
    }

    public void initUpdate() {
        this.setModifyTime(new Date());
    }
}
