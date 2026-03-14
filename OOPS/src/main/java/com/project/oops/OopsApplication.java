package com.project.oops;

import com.project.oops.service.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OopsApplication {

    public static void main(String[] args) {


        SpringApplication.run(OopsApplication.class, args);




        Student s1 = new Student();

        s1.setId(1);
        s1.setName("Ankit");
        s1.setEmail("ankit@gmail.com");
        s1.setMarks(44);


        System.out.println(s1);






    }

}
