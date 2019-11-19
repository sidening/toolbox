package com.smilerro.toolbox.controller;

import com.smilerro.toolbox.entity.blog.Article;
import com.smilerro.toolbox.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    ArticleRepository articleRepository;
    @RequestMapping
    public String index(Model model){
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles",articles);
        return "blog/list";
    }
    @RequestMapping("/0")
    public String aa(Model model){
        return "0";
    }
}
