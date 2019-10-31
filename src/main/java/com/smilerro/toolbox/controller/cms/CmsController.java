package com.smilerro.toolbox.controller.cms;

import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cms")
public class CmsController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WebSiteRepository webSiteRepository;
    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String indexPage(){
        return "cms/index";
    }

    /**
     * 子页面
     * @param model
     * @return
     */
    @RequestMapping("/indexContent")
    public String indexContentPage(Model model){
        return "cms/sonPage/indexContent";
    }

}
