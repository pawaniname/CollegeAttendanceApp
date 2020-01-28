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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author pawan
 */
@Controller
public class FormController {
//    @GetMapping("/")
//    public String index() {
//        return "redirect:/Form";
//    }

    @GetMapping("/Form")
    public String formGet() {
        return "Form";
    }

    @PostMapping("/Form")
    public String formPost(User user, Model model) throws IOException {
//       try{
//        SubjectModel sm = new SubjectModel();
//        Map<String, Object> data = new HashMap<>();
//        data.put("subject", "Android");
//        data.put("added_by", "Admin");
//        sm.saveSubject("CSE", "TE", data);
//       }catch(Exception ex){
//           
//       }
        // System.out.println("User name ---------->> fro FORM _______>> " + user.getFirstName());

        model.addAttribute("user", user);
        return "Form";
    }
}
