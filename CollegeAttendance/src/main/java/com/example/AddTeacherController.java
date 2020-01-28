/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import support.TeacherModel;

/**
 *
 * @author pawan
 */
@Controller
public class AddTeacherController {
//    @GetMapping("/")
//    public String index() {
//        return "redirect:/AddTeacher";
//    }

    @GetMapping("/AddTeacher")
    public String formGet() {
        return "AddTeacher";
    }

    @PostMapping("/AddTeacher")
    public String formPost(Teacher teacher,Model model) throws IOException {
       
        TeacherModel sm = new TeacherModel();
        Map<String, Object> data = new HashMap<>();
        data.put("name", teacher.getTeacherName());
        data.put("email", teacher.getTeacherEmail());
        data.put("mobile", teacher.getTeacherMobile());
        data.put("added_by", "Admin");
        sm.saveTeacher(teacher.getDeptName(),teacher.getTeacherName(), data);
        // model.addAttribute(teacher.getTeacherName(), data);
        return "AddTeacher";
    }
    
}
