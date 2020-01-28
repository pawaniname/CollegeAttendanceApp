/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pawan
 */
public class Teacher {

    private String deptName;
    private String teacherName;
    private String teacherEmail;
    private String teacherMobile;

    public Teacher(String deptName, String teacherName, String teacherEmail, String teacherMobile) {
        this.deptName = deptName;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherMobile = teacherMobile;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherMobile() {
        return teacherMobile;
    }

    public void setTeacherMobile(String teacherMobile) {
        this.teacherMobile = teacherMobile;
    }
    
}
