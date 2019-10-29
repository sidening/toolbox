package com.smilerro.toolbox.controller;

import com.smilerro.toolbox.entity.Category;
import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.GateRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 10:41
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    WebSiteRepository webSiteRepository;
    @Autowired
    GateRepository gateRepository;
    @RequestMapping("/")
    public String index(Model model){
        //1. slogan
        model.addAttribute("slogan","一念清净 ,烈焰成池. . .");
        //2. gate
        List<Gate> gates = gateRepository.findAllByStatusOrderByNumAsc(1);
        model.addAttribute("gates",gates);
        //end. return page
        return "index";
    }

    @GetMapping("/gateData")
    @ResponseBody
    public List gate() {
        List<WebSite> webSites = webSiteRepository.findAll();
        Map<String, Map> res = new HashMap();
        List resList = new ArrayList();
        for (WebSite webSite : webSites) {
            Category category = webSite.getCategory();
            Gate gate = category.getGate();
            String id = gate.getId();
            Map<String , List> map = res.get(id)==null?new HashMap(): res.get(id);
            res.put(id,map);
            List list = map.get(category.getName())==null?new ArrayList():map.get(category.getName());
            map.put(category.getName(),list);
            list.add(webSite);
        }
        for (Map.Entry<String ,Map> entry:res.entrySet()) {
            Map value = entry.getValue();
            String key = entry.getKey();
            value.put("id",key);
            resList.add(value);
        }
        return resList;
    }





}
