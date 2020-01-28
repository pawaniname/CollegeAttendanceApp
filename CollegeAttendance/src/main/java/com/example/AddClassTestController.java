/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.util.Map;
import model.ClassTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import support.ClassTestModel;

/**
 *
 * @author pawan
 */
@Controller
public class AddClassTestController {

    @GetMapping("/AddClassTest")
    public String formGet() {
        return "AddClassTest";
    }

    @PostMapping("/AddClassTest")
    public String formPost(ClassTest data, Model model) throws IOException {
        ClassTestModel ctm = new ClassTestModel();
        MultipartFile studentsFile = data.getMarksFile();
        Map<String, Object> classTest = ctm.readData(studentsFile.getInputStream(),data.getOutOf());
        classTest.put("added_by", "Admin");
        ctm.saveClassTest(data.getDeptName(), data.getClassName(), data.getDivName(),data.getTestName(), classTest);
        return "AddClassTest";
    }
}
