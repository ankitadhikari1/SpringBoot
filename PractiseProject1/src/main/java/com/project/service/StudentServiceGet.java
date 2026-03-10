package com.project.service;

import com.project.entity.Student;
import com.project.interfaces.IStudentGet;
import com.project.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceGet implements IStudentGet {


    Repo repo;

    @Autowired
    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    @Override
    public Student getStudent(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Iterable<Student> getMultipleStudents(List<Integer> ids) {
        return repo.findAllById(ids);
    }

}
