package com.smilerro.toolbox.controller;

import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 10:41
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    WebSiteRepository webSiteRepository;
    @RequestMapping("/")
    public String index(Model model){
        List<WebSite> all = webSiteRepository.findAll();
        model.addAttribute("webSites",all);
        return "index";
    }
}
