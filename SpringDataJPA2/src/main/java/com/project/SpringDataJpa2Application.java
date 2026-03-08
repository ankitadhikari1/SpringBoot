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
//        String status = service.registerVaccineInfo(new Vaccine("phizer", "Moderana", 4545.4));
//        System.out.println(status);

//            Vaccine vac1 = new Vaccine("polio","WHO",999.9);
//        Vaccine vac2 = new Vaccine("CovidShield","Astrazenica",9999.9);
//        Vaccine vac3= new Vaccine("Covaxin","Bharatbio",9899.9);
//
//        List<Vaccine> vaccines = new ArrayList<>();
//        vaccines.add(vac1);
//        vaccines.add(vac2);
//        vaccines.add(vac3);
//
//        service.registerMultipleVaccineInfo(vaccines).forEach(v-> System.out.println(v));
//

        long count = service.vaccineCount();
        System.out.println("total vaccine in dataBase "+count);

         Boolean flag=service.checkVaccineAvailability(8);
         if(flag){
             System.out.println("vaccine is available");
         }
         else{
             System.out.println("vaccine not available");
        }

         service.getAllVaccineInfo().forEach(System.out::println);






    }

}
