package com.project.controller;


import com.project.service.IGreetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @Autowired
    private IGreetings greetService;

    @GetMapping("greet")
    public String generateWish(Model model){

        System.out.println("entered in function");
        String greeting=greetService.generateWish("Ankit");
        model.addAttribute("wishThem",greeting);
        return "wish";
    }



}
