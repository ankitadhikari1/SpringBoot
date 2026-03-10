package com.project;

import com.project.entity.Vaccine;
import com.project.service.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpa3Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa3Application.class, args);
        VaccineService service = container.getBean(VaccineService.class);

       // service.fetchDetailsBySorting(true,"vaccineName","vaccineCompany").forEach(System.out::println);

        service.fetchDetailsByPagenation(2);



    }

}
