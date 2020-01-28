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
public class ClassTest {

    private String deptName;
    private String className;
    private String divName;
    private String testName;
    private String outOf;
    private MultipartFile marksFile;

    public ClassTest(String deptName, String className, String divName, String testName, String outOf, MultipartFile marksFile) {
        this.deptName = deptName;
        this.className = className;
        this.divName = divName;
        this.testName = testName;
        this.outOf = outOf;
        this.marksFile = marksFile;
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

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getOutOf() {
        return outOf;
    }

    public void setOutOf(String outOf) {
        this.outOf = outOf;
    }

    public MultipartFile getMarksFile() {
        return marksFile;
    }

    public void setMarksFile(MultipartFile marksFile) {
        this.marksFile = marksFile;
    }
    
}
