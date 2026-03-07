package com.project.beanlifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BeanLifeCycleExample {


    static {
        System.out.println("this is static block");
    }

    {
        System.out.println("this is java initialisation block");
    }

    public BeanLifeCycleExample(){
        System.out.println("this is constructor");
    }


    @PostConstruct
    public void init(){
        System.out.println("this is init method");
    }

    public void disp(){
        System.out.println("this is business logic");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("this is destroy method");
    }



}
