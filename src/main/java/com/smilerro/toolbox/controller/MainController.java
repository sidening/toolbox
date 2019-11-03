package com.smilerro.toolbox.controller;

import com.smilerro.toolbox.entity.Category;
import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.GateRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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

    @RequestMapping("/gateData")
    @ResponseBody
    public String gate(String gateId) {
        if (gateId.startsWith("#")){
            gateId =gateId.substring(1);
        }
        String res = "";
        Gate example = new Gate();
        example.setId(gateId);
        List<WebSite> webSites = webSiteRepository.findByCategory_Gate(example);
        Map<String, String> map = new HashMap();
        for (WebSite webSite : webSites) {
            String name = webSite.getCategory().getName();
            String s = map.get(name);
            if(s==null||s.equals("")){
                s = "</br></br><p><span class=\"glyphicon glyphicon-menu-down\">"+name+"</p>";
            }
            s = s+"&nbsp<a target=\"_blank\" class=\"btn btn-default btn-sm\" href=\""+webSite.getLink()+"\">"+webSite.getName()+"</a>";
            map.put(name,s);
        }
        //'<p><span class="glyphicon glyphicon-menu-down">'+j+'</p>'
        //'<a target="_blank" class="btn btn-default btn-sm" href="http://'+htem.link+'">'+htem.name+'</a>'
        Collection<String> values = map.values();
        for (String str :values) {
            res = res+str;
        }
        return res;
    }





}
