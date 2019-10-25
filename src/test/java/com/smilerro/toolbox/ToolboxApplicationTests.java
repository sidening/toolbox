package com.smilerro.toolbox;

import com.smilerro.toolbox.entity.User;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToolboxApplicationTests {
    @Autowired
    WebSiteRepository webSiteRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    void contextLoads() {
        for (int i = 0; i < 15; i++) {

            WebSite webSite = new WebSite();
            webSite.setName("必应搜索");
            webSite.setLink("www.bing.com");
            webSiteRepository.save(webSite);
        }
    }

    @Test
    void addUser() {

        User webSite = new User();
        webSite.setUsername("admin");
        webSite.setPassword("admin");
        userRepository.save(webSite);

    }

}
