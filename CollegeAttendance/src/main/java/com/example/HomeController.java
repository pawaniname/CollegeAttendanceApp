/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import support.SubjectModel;

/**
 *
 * @author pawan
 */
@Controller
public class HomeController {
//    @GetMapping("/")
//    public String index() {
//        return "redirect:/Home";
//    }

    //Initialize the list with some data for index screen
//    static {
//
//    }
//        SubjectModel sm=new SubjectModel();
//    @RequestMapping(value = "/Home")
//    public String index(@ModelAttribute("model") ModelMap model) {
// 
//            // List<Class1> userList = new ArrayList<>();
//            
//            List<String> subjects = sm.getSubjects("CSE","TE");
//            System.out.println("Array SIZE ::: "+subjects.size());
//            model.addAttribute("subjectsList", subjects);
//           
//         return "Home";
//    }
//
//    @GetMapping("/Home")
//    public String formGet() {
//        return "Home";
//    }

    @PostMapping("/Home")
    public String formPost(Model model) throws IOException {

//        SubjectModel sm = new SubjectModel();
//        Map<String, Object> data = new HashMap<>();
//        data.put("subject", "Android");
//        data.put("added_by", "Admin");
//        sm.saveSubject("CSE", "TE", data);
//         model.addAttribute("user", user);
        return "Home";
    }

}
