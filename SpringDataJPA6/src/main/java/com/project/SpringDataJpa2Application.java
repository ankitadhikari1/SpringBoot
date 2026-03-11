package com.project;

import com.project.entity.Vaccine;
import com.project.service.VaccineService;
import com.project.view.ResultView1;
import com.project.view.ResultView2;
import com.project.view.ResultView3;
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


        service.fetchByCostLessThan(5467889.7, ResultView1.class).forEach(v-> System.out.println(v.getVaccineName()+" "+v.getVaccineCompany()));
        System.out.println("----------------------------------------");
        service.fetchByCostLessThan(5467889.7, ResultView2.class).forEach(v-> System.out.println(v.getVaccineName()+" "+v.getCost()));
        System.out.println("----------------------------------------");
        service.fetchByCostLessThan(5467889.7, ResultView3.class).forEach(v-> System.out.println(v.getVaccineName()+" "+v.getId()));
        System.out.println("----------------------------------------");


    }

}
