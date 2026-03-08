package com.project.service;

import com.project.entity.Student;
import com.project.interfaces.IStudentCreate;
import com.project.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceCreate implements IStudentCreate {


    Repo repo;

    @Autowired
    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    Student student;

    @Override
    public Integer createStudent(String name, String email) {
        student = new Student();
        student.setName(name);
        student.setEmail(email);
        repo.save(student);
        System.out.println("Creating student with name: " + name + " and email: " + email);
        return student.getId();
    }
}
