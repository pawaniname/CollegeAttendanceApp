/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import model.Subject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import support.SubjectModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author pawan
 */
@Controller
public class AddSubjectController {

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/AddSubject";
//    }

    @GetMapping("/AddSubject")
    public String formGet() {
        return "AddSubject";
    }

    @PostMapping("/AddSubject")
    public String formPost(Subject subject, Model model) throws IOException {
        try {
            if (subject != null) {
                SubjectModel sm = new SubjectModel();
                Map<String, Object> data = new HashMap<>();
                data.put("added_by", "Admin");
                sm.saveSubject(subject.getDeptName(), subject.getClassName(),subject.getSubjectName(), data);
            }
            //model.addAttribute("user", user);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return "AddSubject";

    }
}
