/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author pawan
 */
public class Import {
    private String deptName; 
    private String className; 
    private String divName; 
    private MultipartFile studentsFile; 

    public Import(String deptName, String className, String divName, MultipartFile studentsFile) {
        this.deptName = deptName;
        this.className = className;
        this.divName = divName;
        this.studentsFile = studentsFile;
    }
    public MultipartFile getStudentsFile() {
        return studentsFile;
    }

    public void setStudentsFile(MultipartFile studentsFile) {
        this.studentsFile = studentsFile;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }
    
}
