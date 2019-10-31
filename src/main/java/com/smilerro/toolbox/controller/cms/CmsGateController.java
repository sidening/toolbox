package com.smilerro.toolbox.controller.cms;

import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.repository.GateRepository;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cms/gate")
public class CmsGateController {
    @Autowired
    GateRepository gateRepository;

    @RequestMapping()
    public String indexPage(Model model){
        List<Gate> gates = gateRepository.findAllByStatusOrderByNumAsc(1);
        model.addAttribute("gates",gates);
        return "cms/sonPage/gate";
    }
    @RequestMapping("/delete")
    public String delete(Model model,String id){
        gateRepository.deleteById(id);
        List<Gate> gates = gateRepository.findAllByStatusOrderByNumAsc(1);
        model.addAttribute("gates",gates);
        return "cms/sonPage/gate";
    }
    @RequestMapping("/save")
    public String save(Model model,Gate gate){
        gateRepository.save(gate);
        List<Gate> gates = gateRepository.findAllByStatusOrderByNumAsc(1);
        model.addAttribute("gates",gates);
        return "cms/sonPage/gate";
    }
}
