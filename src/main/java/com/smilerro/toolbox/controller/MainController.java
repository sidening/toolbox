package com.smilerro.toolbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 10:41
 */
@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
