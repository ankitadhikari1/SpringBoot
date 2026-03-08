package com.project.repo;

import com.project.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository<Student,Integer> {
}
