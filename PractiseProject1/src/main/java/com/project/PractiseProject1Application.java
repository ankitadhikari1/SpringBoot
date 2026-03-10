package com.project;

import com.project.entity.Student;
import com.project.service.StudentServiceCreate;
import com.project.service.StudentServiceDelete;
import com.project.service.StudentServiceGet;
import com.project.service.StudentServiceUpdate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PractiseProject1Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext container =
                SpringApplication.run(PractiseProject1Application.class, args);

        Scanner sc = new Scanner(System.in);

        StudentServiceCreate createService = container.getBean(StudentServiceCreate.class);
        StudentServiceGet getService = container.getBean(StudentServiceGet.class);
        StudentServiceUpdate updateService = container.getBean(StudentServiceUpdate.class);
        StudentServiceDelete deleteService = container.getBean(StudentServiceDelete.class);

        System.out.println("Welcome to Student CRUD Application");

        while (true) {

            System.out.println("\nSelect an option");
            System.out.println("1 - Create Student");
            System.out.println("2 - Get Student");
            System.out.println("3 - Update Student");
            System.out.println("4 - Delete Student");
            System.out.println("5- Get multiple students");
            System.out.println("5 - Quit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.println("Enter name");
                String name = sc.nextLine();

                System.out.println("Enter email");
                String email = sc.nextLine();

                Integer id = createService.createStudent(name, email);

                System.out.println("Student created with id: " + id);
            }

            else if (choice == 2) {

                System.out.println("Enter id");
                int id = sc.nextInt();

                Student s = getService.getStudent(id);

                if (s != null)
                    System.out.println(s);
                else
                    System.out.println("Student not found");
            }

            else if (choice == 3) {

                System.out.println("Enter id");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter name");
                String name = sc.nextLine();

                System.out.println("Enter email");
                String email = sc.nextLine();

                String status = updateService.updateStudent(id, name, email);

                System.out.println(status);
            }

            else if (choice == 4) {

                System.out.println("Enter id to delete");
                int id = sc.nextInt();

                String status = deleteService.deleteStudent(id);

                System.out.println(status);
            }
            else if(choice == 5){
                System.out.println("enter number of students to get");
                int n = sc.nextInt();
                System.out.println("Enter ids to get multiple students");
                List<Integer> id = new ArrayList<>();
                for(int i=0; i<n; i++){
                    id.add(sc.nextInt());
                }

                getService.getMultipleStudents(id).forEach(v-> System.out.println(v));
                break;
            }

            else if (choice == 6) {

                System.out.println("Exiting application...");
                break;
            }

            else {
                System.out.println("Invalid option");
            }
        }

        sc.close();
        container.close();
    }
}