package com.smilerro.toolbox;

import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToolboxApplicationTests {
    @Autowired
    WebSiteRepository webSiteRepository;
    @Test
    void contextLoads() {
        for (int i = 0; i < 15; i++) {

            WebSite webSite = new WebSite();
            webSite.setName("必应搜索");
            webSite.setLink("www.bing.com");
            webSiteRepository.save(webSite);
        }
    }

}
