/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author pawan
 */
@Controller
public class AddClassController {
    
//    @GetMapping("/")
//    public String index() {
//        return "redirect:/AddClass";
//    }
    @GetMapping("/AddClass")
    public String formGet() {
        return "AddClass";
    }

    @PostMapping("/AddClass")
    public String formPost(Model model) throws IOException {
       
//        SubjectModel sm = new SubjectModel();
//        Map<String, Object> data = new HashMap<>();
//        data.put("subject", "Android");
//        data.put("added_by", "Admin");
//        sm.saveSubject("CSE", "TE", data);
//         model.addAttribute("user", user);
        return "AddClass";
    }
    
}
