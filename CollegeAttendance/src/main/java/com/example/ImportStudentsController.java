/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.util.Map;
import model.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import support.ImportModel;

/**
 *
 * @author pawan
 */
@Controller
public class ImportStudentsController {

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/ImportStudents";
//    }
    @GetMapping("/ImportStudents")
    public String formGet() {
        return "ImportStudents";
    }

    @PostMapping("/ImportStudents")
    public String formPost(Import data, Model model) throws IOException {
        ImportModel im = new ImportModel();
        MultipartFile studentsFile = data.getStudentsFile();
        Map<String, Object> students = im.readData(studentsFile.getInputStream());
        students.put("added_by", "Admin");
        im.saveStudents(data.getDeptName(), data.getClassName(), data.getDivName(), students);
        return "ImportStudents";
    }

}
