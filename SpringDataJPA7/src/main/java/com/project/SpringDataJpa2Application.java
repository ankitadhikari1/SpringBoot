package com.project;

import com.project.entity.Vaccine;
import com.project.service.VaccineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpa2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa2Application.class, args);
        VaccineService service = container.getBean(VaccineService.class);


        service.fetchByCost(9999.9).forEach(v-> System.out.println(v));
        System.out.println("---------------------------------------");
        service.fetchByCostLessThanEqual(9999.9).forEach(v-> System.out.println(v));
        System.out.println("---------------------------------------");
        service.fetchByVaccineNameEquals("phizer").forEach(v-> System.out.println(v));



    }

}
