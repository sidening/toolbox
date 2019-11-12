package com.smilerro.toolbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping
    public String index(Model model){
        model.addAttribute("page","Home");
        return "1";
    }
    @RequestMapping("/0")
    public String aa(Model model){
        return "0";
    }
}
