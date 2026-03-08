package com.project.service;

import com.project.entity.Student;
import com.project.interfaces.IStudentUpdate;
import com.project.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceUpdate implements IStudentUpdate {

    Repo repo;

    @Autowired
    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    @Override
    public String updateStudent(Integer id, String name, String email) {

        Student student = repo.findById(id).orElse(null);
        if (student != null) {
            student.setName(name);
            student.setEmail(email);

            repo.save(student);

            return "Student updated successfully";
        }

        return "Student not found";
    }
}