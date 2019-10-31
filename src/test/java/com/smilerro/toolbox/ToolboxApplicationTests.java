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
import java.util.Collections;
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
        String s = "11,22,33,44,55";
        List<Integer> list = new ArrayList();
        int num=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c !=','){
                num = num*10+c-48;
            }else{
               list.add(num);
               num =0;
            }
        }
        list.add(num);
        for (Object o:list) {
            System.out.println(o);
        }
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
    @Test
    void addCate(){
        int[] arr = {1,3,5,2,7};
        //1.从[0-结尾]数据中 把最大值交换到 0 位置
        for (int i = 0; i < arr.length; i++) {
            //如果当前位置的值大于0位置的值 , 交换
            if(arr[i]>arr[0]){
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
        //2.从[1-结尾]数据中 把最大值交换到 1 位置
        for (int i = 1; i < arr.length; i++) {
            //如果当前位置的值大于1位置的值 , 交换
            if(arr[i]>arr[1]){
                int temp = arr[i];
                arr[i] = arr[1];
                arr[1] = temp;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            int n = j;
            //1.从[n-结尾]数据中 把最大值交换到 n 位置
            for (int i = n; i < arr.length; i++) {
                //如果当前位置的值大于n位置的值 , 交换
                if(arr[i]>arr[n]){
                    int temp = arr[n];
                    arr[n] = arr[i];
                    arr[i] = temp;
                }
            }

        }

        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
