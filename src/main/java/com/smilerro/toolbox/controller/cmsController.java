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
    @RequestMapping("/login")
    public String loginPage(Model model){
        return "loginCms";
    }
    @RequestMapping("/userLogin")
    public String userLogin(Model model, User user){
        String username = user.getUsername();
        String password = user.getPassword();
        user = userRepository.findByUsernameAndPassword(username, password);
        if (user!=null){
            model.addAttribute("user",user);
            return "list";
        }else{
            model.addAttribute("msg","login faild!");
            return "loginCms";
        }
    }

    @RequestMapping("/webList")
    public String userLogin(Model model){
        List<WebSite> all = webSiteRepository.findAll();
        if (all!=null){
            model.addAttribute("webList",all);
        }
        return "list";
    }

}
