package com.project.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeanLifeCycleApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext container = SpringApplication.run(BeanLifeCycleApplication.class, args);
        BeanLifeCycleExample obj = container.getBean(BeanLifeCycleExample.class);
        obj.disp();
        container.close();

    }

}
