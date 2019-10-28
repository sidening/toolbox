package com.smilerro.toolbox;

import com.smilerro.toolbox.entity.Category;
import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.entity.User;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.CategoryRepository;
import com.smilerro.toolbox.repository.GateRepository;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ToolboxApplicationTests {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    WebSiteRepository webSiteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GateRepository gateRepository;
    @Test
    void addWebSide() {
        List<Category> categories = categoryRepository.findAll();
        List<WebSite> webSites = new ArrayList<>();
        for (Category cate : categories) {
            for (int i = 0; i < 10; i++) {
                WebSite webSite = new WebSite();
                webSite.setLink("www.baidu.com");
                webSite.setName("test_website");
                webSite.setStatus(1);
                webSite.setCategory(cate);
                webSites.add(webSite);
            }
        }
        webSiteRepository.saveAll(webSites);
    }

    @Test
    void addUser() {


    }
    @Test
    void addGate() {
        for (int i = 1; i < 5; i++) {
            Gate gate = new Gate();
            gate.setName("分类"+i);
            gate.setNum(i);
            gate.setStatus(1);
            gateRepository.save(gate);
        }

    }
    @Test
    void addCategory() {
        List<Gate> gates = gateRepository.findAll();

        List<Category> categorys = new ArrayList<>();
        for (Gate gate:gates) {
            for (int i = 0; i <2; i++) {
                Category category = new Category();
                category.setGate(gate);
                category.setName("小分类"+i);
                categorys.add(category);
            }
        }
        categoryRepository.saveAll(categorys);

    }

}
