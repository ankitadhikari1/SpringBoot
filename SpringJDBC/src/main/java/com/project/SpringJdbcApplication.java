package com.project;

import com.project.dao.EmployeeDaoImpl;
import com.project.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext container = SpringApplication.run(SpringJdbcApplication.class, args);
        EmployeeDaoImpl obj = container.getBean(EmployeeDaoImpl.class);
        List<Employee> list = obj.getEployeeInfo();

        for(Employee e : list){
            System.out.println(e);
        }


    }

}
