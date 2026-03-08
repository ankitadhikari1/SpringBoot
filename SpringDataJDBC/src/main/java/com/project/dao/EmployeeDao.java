package com.project.dao;


import com.project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class EmployeeDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //private String query = "INSERT INTO EMPLOYEE(id,name,city) values(1,'Ankit','Haldwani')";

    private String query = "INSERT INTO EMPLOYEE(id,name,city) values(?,?,?)";

    public void input(Employee emp){
        jdbcTemplate.update(query,emp.getId(),emp.getName(),emp.getCity());
        System.out.println("data inserted");
    }
}
