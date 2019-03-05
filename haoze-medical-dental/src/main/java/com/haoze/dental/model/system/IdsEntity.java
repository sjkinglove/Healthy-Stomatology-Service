package com.haoze.dental.model.system;


/**
 * @author zj
 * @date 2018/12/6
 */
public class IdsEntity {

    private String parentId;//父id

    private String id;// 子id

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
