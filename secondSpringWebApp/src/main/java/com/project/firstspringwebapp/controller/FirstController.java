package com.project.firstspringwebapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping("api1")
public class FirstController {

    @GetMapping("/welcome")
    public String displaySomeResponse2(Model model){
        System.out.println("model is implemented by "+model.getClass().getName());
         model.addAttribute("info","hi there my name is ankit adhikari");
        return "home";
    }

    @GetMapping("/skill")
    public String displaySomeMessage(Model model){
        System.out.println("model is implemented by "+model.getClass().getName());
        model.addAttribute("focus","focus is the most important skill");
        return "focus";
    }

    @GetMapping("/info")
    public String displaySomeinfo(Map<String,Object> map){
        System.out.println("model is implemented by "+map.getClass().getName());
        map.put("infoo","focus is the most important snafkndadsknfm,");
        return "idk";
    }

}
