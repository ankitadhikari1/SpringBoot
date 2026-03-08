import axios from 'axios';

/**
 * Axios instance configured for the Employee API.
 * Base URL points to the Spring Boot backend.
 */
const API = axios.create({
  baseURL: 'http://localhost:8080/api/employees',
  headers: {
    'Content-Type': 'application/json',
  },
});

/**
 * Fetch all employees.
 * @returns {Promise<Array>} List of employee objects
 */
export const getAllEmployees = () => API.get('/');

/**
 * Fetch a single employee by ID.
 * @param {number} id - Employee ID
 * @returns {Promise<Object>} Employee object
 */
export const getEmployeeById = (id) => API.get(`/${id}`);

/**
 * Create a new employee.
 * @param {Object} employee - Employee data
 * @returns {Promise<Object>} Created employee
 */
export const createEmployee = (employee) => API.post('/', employee);

/**
 * Update an existing employee.
 * @param {number} id - Employee ID
 * @param {Object} employee - Updated employee data
 * @returns {Promise<Object>} Updated employee
 */
export const updateEmployee = (id, employee) => API.put(`/${id}`, employee);

/**
 * Delete an employee by ID.
 * @param {number} id - Employee ID
 * @returns {Promise<void>}
 */
export const deleteEmployee = (id) => API.delete(`/${id}`);

/**
 * Search employees by query (matches name or department).
 * @param {string} query - Search term
 * @returns {Promise<Array>} Matching employees
 */
export const searchEmployees = (query) => API.get(`/search?query=${query}`);

