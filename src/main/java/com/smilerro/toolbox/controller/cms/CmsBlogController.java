package com.smilerro.toolbox.controller.cms;

import com.smilerro.toolbox.entity.blog.Article;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cms/blog")
public class CmsBlogController {
    /**
     * 首页
     * @return
     */
    @RequestMapping()
    public String indexPage(){
        return "cms/sonPage/blogadd";
    }

    @RequestMapping(value = "/save")
    public String save(HttpServletRequest request, Model model,@RequestParam(value = "file") MultipartFile file){
        String lables = request.getParameter("lables");
        return "cms/sonPage/blogadd";
    }

}
