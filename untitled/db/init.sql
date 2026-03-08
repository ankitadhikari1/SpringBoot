-- ============================================
-- Database Initialization Script
-- Run this script in MySQL before starting
-- the Spring Boot application.
-- ============================================

CREATE DATABASE IF NOT EXISTS employee_db;
USE employee_db;

-- The 'employees' table will be auto-created by Hibernate (ddl-auto=update),
-- but here's the schema for reference:
--
-- CREATE TABLE employees (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     first_name VARCHAR(255) NOT NULL,
--     last_name VARCHAR(255) NOT NULL,
--     email VARCHAR(255) NOT NULL UNIQUE,
--     department VARCHAR(255) NOT NULL,
--     salary DOUBLE NOT NULL,
--     phone VARCHAR(255),
--     join_date DATE
-- );

-- ============================================
-- Sample Seed Data (optional)
-- ============================================
INSERT INTO employees (first_name, last_name, email, department, salary, phone, join_date) VALUES
('John', 'Doe', 'john.doe@company.com', 'Engineering', 85000.00, '+1-555-0101', '2023-01-15'),
('Jane', 'Smith', 'jane.smith@company.com', 'Marketing', 72000.00, '+1-555-0102', '2023-03-22'),
('Robert', 'Johnson', 'robert.j@company.com', 'Finance', 90000.00, '+1-555-0103', '2022-11-10'),
('Emily', 'Davis', 'emily.davis@company.com', 'Engineering', 88000.00, '+1-555-0104', '2023-06-01'),
('Michael', 'Wilson', 'michael.w@company.com', 'HR', 65000.00, '+1-555-0105', '2024-01-08'),
('Sarah', 'Brown', 'sarah.brown@company.com', 'Design', 78000.00, '+1-555-0106', '2023-09-14');

