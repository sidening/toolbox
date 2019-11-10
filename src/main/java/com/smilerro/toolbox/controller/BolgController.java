package com.smilerro.toolbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BolgController {

    @RequestMapping
    public String index(){
        return "blog";
    }
    @RequestMapping("article")
    public String article(){
        return "blog/article";
    }
}
