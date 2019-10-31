package com.smilerro.toolbox.controller.cms;

import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cms/site")
public class CmsSiteController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WebSiteRepository webSiteRepository;

    @RequestMapping()
    public String indexPage(Model model){

        List<WebSite> sites = webSiteRepository.findAll();
        model.addAttribute("sites",sites);
        return "cms/sonPage/site";
    }


    @RequestMapping("/delete")
    public String delete(Model model, String id){
        webSiteRepository.deleteById(id);
        List<WebSite> sites = webSiteRepository.findAll();
        model.addAttribute("sites",sites);
        return "cms/sonPage/site";
    }
    @RequestMapping("/save")
    public String save(Model model,WebSite site){
        webSiteRepository.save(site);
        List<WebSite> gates = webSiteRepository.findAll();
        model.addAttribute("sites",gates);
        return "cms/sonPage/site";
    }
}
