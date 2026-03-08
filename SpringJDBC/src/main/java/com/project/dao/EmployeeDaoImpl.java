package com.project.dao;

import com.project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao{
    @Autowired
    private DataSource dataSource;

    List<Employee> list = null;

    @Override
    public List<Employee> getEployeeInfo() {

        list = new ArrayList<>();

        try (Connection con = dataSource.getConnection()) {

            String query = "SELECT * FROM EmployeeInfo";
            PreparedStatement pstmt = con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setCity(rs.getString(3));

                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
