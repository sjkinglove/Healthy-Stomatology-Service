package com.haoze.dental.entity;

import com.haoze.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "SYS_CLASS")
public class ClassInfo extends BaseEntity {

    /*班级ID*/
    @Id
    @Column(name = "CLASS_ID", nullable = false)
    private String classId;
    /*班级唯一标识码*/
    @Column(name = "CLASS_CODE")
    private String classCode;
    /*班级名*/
    @Column(name = "CLASS_NAME")
    private String className;
    /*第几届班级*/
    @Column(name = "CLASS_DUE")
    private String classDue;
    /*学校ID*/
    @Column(name = "SCHOOL_ID")
    private String schoolId;
    /*地区ID*/
    @Column(name = "AREA_ID")
    private String areaId;


    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDue() {
        return classDue;
    }

    public void setClassDue(String classDue) {
        this.classDue = classDue;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }



}
