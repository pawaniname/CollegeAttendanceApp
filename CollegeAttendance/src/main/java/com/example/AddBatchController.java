/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Batch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import support.BatchModel;

/**
 *
 * @author pawan
 */
@Controller
public class AddBatchController {

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/AddClass";
//    }
    @GetMapping("/AddBatch")
    public String formGet() {
        return "AddBatch";
    }

    @PostMapping("/AddBatch")
    public String formPost(Batch batch, Model model) throws IOException {
        BatchModel bm = new BatchModel();
        Map<String, Object> data = new HashMap<>();
        data.put("added_by", "Admin");
        bm.saveBatches(batch.getDeptName(), batch.getClassName(), batch.getDivName(), batch.getBatchName(), data);
        //model.addAttribute("user", user);
        return "AddBatch";
    }
}
