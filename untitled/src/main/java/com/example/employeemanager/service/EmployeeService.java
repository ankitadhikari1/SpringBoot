package com.example.employeemanager.service;

import com.example.employeemanager.model.Employee;

import java.util.List;

/**
 * Service interface defining business operations for Employee management.
 * Follows the Interface Segregation Principle — exposes only what controllers need.
 */
public interface EmployeeService {

    /** Retrieve all employees ordered by ID descending (newest first). */
    List<Employee> getAllEmployees();

    /** Retrieve a single employee by ID. Throws ResourceNotFoundException if not found. */
    Employee getEmployeeById(Long id);

    /** Create a new employee record. */
    Employee createEmployee(Employee employee);

    /** Update an existing employee by ID. Throws ResourceNotFoundException if not found. */
    Employee updateEmployee(Long id, Employee employeeDetails);

    /** Delete an employee by ID. Throws ResourceNotFoundException if not found. */
    void deleteEmployee(Long id);

    /** Search employees by name or department (case-insensitive partial match). */
    List<Employee> searchEmployees(String query);
}

