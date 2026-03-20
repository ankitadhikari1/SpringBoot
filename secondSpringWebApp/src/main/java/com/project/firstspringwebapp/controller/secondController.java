package com.project.firstspringwebapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api2")
public class secondController {
    @GetMapping("/welcome")
    public String displaySomeResponse2(Model model){
        System.out.println("model is implemented by "+model.getClass().getName());
        model.addAttribute("info","hi there my name is deepak chandola");
        return "home";
    }
}
