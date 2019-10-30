package com.smilerro.toolbox.controller;

import com.smilerro.toolbox.entity.User;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cms")
public class CmsController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WebSiteRepository webSiteRepository;
    @RequestMapping("/")
    public String loginPage(Model model){
        return "cms/starter";
    }
    @RequestMapping("/w")
    public String loginP(Model model){
        return "cms/index";
    }
}
