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

        //System.out.println(service.searchVaccineById(1));

        Vaccine vac = new Vaccine();
        vac.setVaccineName("Phizer");
        vac.setVaccineCompany("Moderana");
        vac.setCost(4545.4);

        service.searchVaccineByGivenInfo(vac).forEach(System.out::println);


    }

}
