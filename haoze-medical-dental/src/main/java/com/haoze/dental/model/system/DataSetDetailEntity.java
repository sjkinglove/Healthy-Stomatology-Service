package com.haoze.dental.model.system;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据集明细实体
 * @author fcx
 * @date 2019年2月19日09:01:32
 */
@Table(name = "SYS_DATA_SET_DETAIL")
public class DataSetDetailEntity extends BaseEntity {

    @Id
    @Column(name = "DATASETDETAIL_ID", nullable = false)
    private String datasetdetailId; // 数据集明细数据ID

    @Column(name = "DATASET_ID")
    private String datasetId; // 数据集数据ID

    @Column(name = "INTERNAL_IDENTIFIER")
    private String internalIdentifier; // 内部标识符

    @Column(name = "ELEMENT_ID")
    private String elementId; // 数据元数据ID

    @Column(name = "ELEMENT_REMARK")
    private String elementRemark; // 定义

    @Column(name = "SERIAL_NO")
    private String serialNo; // 排序号

    public String getDatasetdetailId() {
        return datasetdetailId;
    }

    public void setDatasetdetailId(String datasetdetailId) {
        this.datasetdetailId = datasetdetailId;
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public String getInternalIdentifier() {
        return internalIdentifier;
    }

    public void setInternalIdentifier(String internalIdentifier) {
        this.internalIdentifier = internalIdentifier;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getElementRemark() {
        return elementRemark;
    }

    public void setElementRemark(String elementRemark) {
        this.elementRemark = elementRemark;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
