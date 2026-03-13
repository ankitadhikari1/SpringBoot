package com.project;

import com.project.dto.CustomerDTO;
import com.project.model.Customer;
import com.project.service.CustomerService;
import com.project.utils.IdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootMongoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext container = SpringApplication.run(SpringBootMongoApplication.class, args);
        CustomerService service = container.getBean(CustomerService.class);
//        CustomerDTO dto1 = new CustomerDTO(1,"Ankit","Haldwani");
//        CustomerDTO dto2 = new CustomerDTO(2,"Sarthak","Lalkuan");
//        CustomerDTO dto3 = new CustomerDTO(3,"Pooja","Delhi");
//        String output1 =service.registerCustomer(dto1);
//        System.out.println(output1);
//        System.out.println("---------------------------------");
//        String output2 =service.registerCustomer(dto1);
//        System.out.println(output2);
//        System.out.println("---------------------------------");
//        String output3 =service.registerCustomer(dto1);
//        System.out.println(output3);
//        System.out.println("---------------------------------");
//        service.findAllCustomer().forEach(v-> System.out.println(v));

        CustomerDTO dto = new CustomerDTO();
        dto.setId(IdGenerator.generateId());
        dto.setName("Deepak");
        dto.setCity("Halduchaur");
        dto.setCustNo(4);

        String output = service.registerCustomer(dto);
        System.out.println(output);
        System.out.println("---------------------------------");
        service.findAllCustomer().forEach(v-> System.out.println(v));



    }

}
