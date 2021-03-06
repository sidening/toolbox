package com.smilerro.toolbox.controller.cms;

import com.smilerro.toolbox.entity.Category;
import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.CategoryRepository;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
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
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping()
    public String indexPage(Model model ,WebSite webSite){
        List<WebSite> sites = null;
        if (webSite.getCategory()==null||webSite.getCategory().getGate()==null){
            sites = webSiteRepository.findAll();
        }else{
            Example<WebSite> example = Example.of(webSite);
            sites = webSiteRepository.findAll(example);
        }
        List<Category> categorys = categoryRepository.findAll();
        model.addAttribute("sites",sites);
        model.addAttribute("categorys",categorys);
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
