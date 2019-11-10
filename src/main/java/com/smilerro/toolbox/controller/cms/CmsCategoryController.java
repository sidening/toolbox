package com.smilerro.toolbox.controller.cms;

import com.smilerro.toolbox.entity.Category;
import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.CategoryRepository;
import com.smilerro.toolbox.repository.GateRepository;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cms/category")
public class CmsCategoryController {
    @Autowired
    GateRepository gateRepository;
    @Autowired
    WebSiteRepository webSiteRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping()
    public String indexPage(Model model){
        List<Gate> gates = gateRepository.findAll();
        List<Category> categorys = categoryRepository.findAll();
        model.addAttribute("categorys",categorys);
        model.addAttribute("gates",gates);
        return "cms/sonPage/category";
    }


    @RequestMapping("/delete")
    public String delete(Model model, String id){
        categoryRepository.deleteById(id);
        List<Gate> gates = gateRepository.findAll();
        List<Category> categorys = categoryRepository.findAll();
        model.addAttribute("categorys",categorys);
        model.addAttribute("gates",gates);
        return "cms/sonPage/category";
    }
    @RequestMapping("/save")
    public String save(Model model,Category category){
        categoryRepository.save(category);
        List<Gate> gates = gateRepository.findAll();
        List<Category> categorys = categoryRepository.findAll();
        model.addAttribute("categorys",categorys);
        model.addAttribute("gates",gates);
        return "cms/sonPage/category";
    }
    @RequestMapping("/options")
    @ResponseBody
    public  List<Category> options(String gateId){
        List<Category> categories = categoryRepository.findByGate_Id(gateId);
        return categories;
    }
}
