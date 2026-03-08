package com.project;

import com.project.dao.EmployeeDao;
import com.project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JDBCRunner implements CommandLineRunner {

    @Autowired
    private EmployeeDao dao;

    @Override
    public void run(String... args) throws Exception {
        dao.input(new Employee(2,"Rohit","Delhi"));
    }
}
