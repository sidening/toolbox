package com.smilerro.toolbox.controller.cms;

import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cms/site")
public class CmsSiteController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WebSiteRepository webSiteRepository;

    @RequestMapping()
    public String indexPage(){
        return "cms/sonPage/site";
    }
}
