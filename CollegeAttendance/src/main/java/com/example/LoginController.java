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
public class LoginController {
//
    @GetMapping("/")
    public String index() {
        return "redirect:/Login";
    }

    @GetMapping("/Login")
    public String formGet() {
        return "Login";
    }

    @PostMapping("/Login")
    public String formPost(User user, Model model) throws IOException {
        model.addAttribute("user", user);

        if (user.getFirstName().equals("Admin") && user.getLastName().equals("123")) {
            return "Home";
        } else {
            return "Login";
        }

    }
}
