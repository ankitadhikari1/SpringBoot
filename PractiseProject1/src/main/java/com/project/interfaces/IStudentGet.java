package com.project.interfaces;

import com.project.entity.Student;

import java.util.List;

public interface IStudentGet {
    public Student getStudent(Integer id);
    public Iterable<Student> getMultipleStudents(List<Integer> ids);
}
