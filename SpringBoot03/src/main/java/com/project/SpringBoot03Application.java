package com.project;

import com.project.service.Amazon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot03Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(SpringBoot03Application.class, args);
        Amazon obj = container.getBean(Amazon.class);
        Boolean status = obj.deliverProduct(5000.0);
        if(status){
            System.out.println("delivery successfull");
        }
        else{
            System.out.println("delivery unsucessfull");
        }


    }

}
