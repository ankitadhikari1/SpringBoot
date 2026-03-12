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


        service.fetchByVaccineCompany("WHO").forEach(v-> System.out.println(v));
        System.out.println("----------------------------");
        service.fetchByVaccineCompany("WHO","Moderana").forEach(v-> System.out.println(v));
        System.out.println("----------------------------");
        service.fetchVaccineByCost(4545.4).forEach(v-> System.out.println(v));
        System.out.println("-----------------------------");
        int rows = service.updateThePriceByVaccineName(979797.9,"phizer");
        if(rows!=0){
            System.out.println("price updated");
        }
        else{
            System.out.println("something went wrong");
        }

    }

}
