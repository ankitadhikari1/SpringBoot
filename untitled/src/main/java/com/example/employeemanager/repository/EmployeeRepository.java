package com.example.employeemanager.repository;

import com.example.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Employee entity.
 * Extends JpaRepository to provide CRUD and pagination operations.
 * Custom query methods are derived from method names by Spring Data JPA.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Search employees by first name or last name (case-insensitive partial match).
     */
    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(
            String firstName, String lastName, String department);

    /**
     * Find an employee by their email address.
     */
    Optional<Employee> findByEmail(String email);
}

