package com.project.controller;


import com.project.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @GetMapping("/courseinfo")
    public String getCourseInfo(Model model){
        model.addAttribute("cid","T1");
        model.addAttribute("cname","Devops");
        model.addAttribute("price","49999 INR");
        return "course";
    }

    @GetMapping("/coursedetails")
    public String getCourseDetails(Model model){
        Course course = new Course();
        course.setCid(1);
        course.setCname("Devops with AWS");
        course.setPrice(59999.9);
        model.addAttribute("course",course);
        return "coursedetails";
    }
}
