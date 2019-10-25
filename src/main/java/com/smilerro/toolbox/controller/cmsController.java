package com.smilerro.toolbox.controller;

import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cms")
public class cmsController {
    @Autowired
    WebSiteRepository webSiteRepository;
    @RequestMapping("/add")
    public String add(Model model){
        List<WebSite> all = webSiteRepository.findAll();
        model.addAttribute("webSites",all);
        return "index";
    }

}
