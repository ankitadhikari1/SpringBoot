package com.project.service;

import com.project.entity.Student;
import com.project.interfaces.IStudentDelete;
import com.project.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceDelete implements IStudentDelete {

    Repo repo;

    @Autowired
    public void setRepo(Repo repo) {
        this.repo = repo;
    }


    @Override
    public String deleteStudent(Integer id) {
        Student s = repo.findById(id).orElse(null);
        if(s!=null){
            repo.deleteById(id);
            return "Student deleted with name : "+s.getName()+" and email :"+s.getEmail();
        }
        return "Data with "+id+" not found";
    }
}
