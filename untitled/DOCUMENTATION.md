# 🏢 Employee Management Application

## Complete Full-Stack Documentation

> **Tech Stack:** React + Vite + Tailwind CSS (Frontend) | Spring Boot + JPA (Backend) | MySQL (Database)

---

## 📑 Table of Contents

1. [Project Overview](#-project-overview)
2. [Architecture & Design Principles](#-architecture--design-principles)
3. [Project Structure](#-project-structure)
4. [Database Layer](#-database-layer)
5. [Backend (Spring Boot) Flow](#-backend-spring-boot-flow)
6. [Frontend (React) Flow](#-frontend-react-flow)
7. [API Endpoints](#-api-endpoints)
8. [Data Flow - End to End](#-data-flow---end-to-end)
9. [Setup & Running Instructions](#-setup--running-instructions)
10. [Design Decisions](#-design-decisions)

---

## 📋 Project Overview

This is a full-stack **Employee Management System** that allows users to:

- ✅ **Create** new employee records
- ✅ **Read/View** all employees in a card-based grid layout
- ✅ **Update** existing employee information
- ✅ **Delete** employees with confirmation
- ✅ **Search** employees by name or department (real-time)

### Employee Data Model

| Field       | Type       | Constraints                    |
|-------------|------------|--------------------------------|
| id          | Long       | Auto-generated primary key     |
| firstName   | String     | Required                       |
| lastName    | String     | Required                       |
| email       | String     | Required, unique, valid format |
| department  | String     | Required                       |
| salary      | Double     | Required, must be positive     |
| phone       | String     | Optional                       |
| joinDate    | LocalDate  | Optional                       |

---

## 🏗 Architecture & Design Principles

### Layered Architecture (Backend)

```
┌─────────────────────────────────────────────────┐
│                  Client (React)                  │
└───────────────────────┬─────────────────────────┘
                        │ HTTP (REST API)
┌───────────────────────▼─────────────────────────┐
│              Controller Layer                     │
│         (EmployeeController.java)                │
│    Handles HTTP requests, input validation       │
└───────────────────────┬─────────────────────────┘
                        │
┌───────────────────────▼─────────────────────────┐
│               Service Layer                       │
│   (EmployeeService / EmployeeServiceImpl)        │
│    Business logic, data transformation           │
└───────────────────────┬─────────────────────────┘
                        │
┌───────────────────────▼─────────────────────────┐
│             Repository Layer                      │
│         (EmployeeRepository.java)                │
│    Data access via Spring Data JPA               │
└───────────────────────┬─────────────────────────┘
                        │
┌───────────────────────▼─────────────────────────┐
│              MySQL Database                       │
│           (employee_db.employees)                │
└─────────────────────────────────────────────────┘
```

### Design Principles Applied

| Principle | Application |
|-----------|-------------|
| **Single Responsibility (SRP)** | Each class has one purpose: Controller handles HTTP, Service handles logic, Repository handles data |
| **Interface Segregation (ISP)** | `EmployeeService` interface exposes only what controllers need |
| **Dependency Inversion (DIP)** | Controller depends on `EmployeeService` interface, not `EmployeeServiceImpl` |
| **Separation of Concerns** | Frontend, Backend, and Database are independent layers |
| **DRY (Don't Repeat Yourself)** | Reusable `EmployeeForm` component for both Create and Edit |
| **Component-Based Design** | React UI broken into small, reusable components |

---

## 📁 Project Structure

```
untitled/
├── pom.xml                                    # Maven build config (Spring Boot)
├── db/
│   └── init.sql                               # Database creation & seed data
├── DOCUMENTATION.md                           # This file
│
├── src/main/
│   ├── java/com/example/employeemanager/
│   │   ├── EmployeeManagerApplication.java    # Spring Boot entry point
│   │   ├── config/
│   │   │   └── CorsConfig.java                # CORS policy for React dev server
│   │   ├── controller/
│   │   │   └── EmployeeController.java        # REST API endpoints
│   │   ├── exception/
│   │   │   ├── GlobalExceptionHandler.java    # Centralized error handling
│   │   │   └── ResourceNotFoundException.java # Custom 404 exception
│   │   ├── model/
│   │   │   └── Employee.java                  # JPA Entity
│   │   ├── repository/
│   │   │   └── EmployeeRepository.java        # Data access layer
│   │   └── service/
│   │       ├── EmployeeService.java           # Service interface
│   │       └── impl/
│   │           └── EmployeeServiceImpl.java   # Service implementation
│   └── resources/
│       └── application.properties             # Spring Boot configuration
│
└── frontend/                                  # React Application (Vite)
    ├── package.json
    ├── vite.config.js                         # Vite + Tailwind plugin config
    ├── index.html
    └── src/
        ├── main.jsx                           # React entry point
        ├── App.jsx                            # Root component with routing
        ├── index.css                          # Tailwind CSS imports
        ├── services/
        │   └── EmployeeService.js             # Axios API client
        ├── components/
        │   ├── Navbar.jsx                     # Top navigation bar
        │   ├── SearchBar.jsx                  # Search input with clear
        │   ├── EmployeeCard.jsx               # Individual employee card
        │   ├── EmployeeList.jsx               # Grid of employee cards
        │   └── EmployeeForm.jsx               # Reusable create/edit form
        └── pages/
            ├── HomePage.jsx                   # Main dashboard (list + search)
            ├── AddEmployeePage.jsx            # Add new employee page
            └── EditEmployeePage.jsx           # Edit existing employee page
```

---

## 🗄 Database Layer

### Schema

The database is **MySQL**. The table is auto-created by Hibernate (`ddl-auto=update`).

```sql
CREATE DATABASE IF NOT EXISTS employee_db;

CREATE TABLE employees (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name  VARCHAR(255) NOT NULL,
    last_name   VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE,
    department  VARCHAR(255) NOT NULL,
    salary      DOUBLE NOT NULL,
    phone       VARCHAR(255),
    join_date   DATE
);
```

### Configuration (`application.properties`)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update     # Auto-creates/updates tables
spring.jpa.show-sql=true                 # Logs SQL queries to console
```

### Seed Data

The `db/init.sql` file contains 6 sample employees for initial testing. You can run it manually or let the app start with an empty database and add employees via the UI.

---

## ⚙ Backend (Spring Boot) Flow

### 1. Entry Point — `EmployeeManagerApplication.java`

- Annotated with `@SpringBootApplication` (combines `@Configuration`, `@EnableAutoConfiguration`, `@ComponentScan`)
- Spring Boot auto-discovers all beans in `com.example.employeemanager` and sub-packages

### 2. Model — `Employee.java`

- JPA `@Entity` mapped to `employees` table
- Plain Java POJO with explicit getters, setters, constructors, `equals()`, `hashCode()`, and `toString()`
- **Bean Validation** annotations (`@NotBlank`, `@Email`, `@Positive`) for server-side validation
- `@Id` + `@GeneratedValue(IDENTITY)` for auto-incrementing primary key

### 3. Repository — `EmployeeRepository.java`

- Extends `JpaRepository<Employee, Long>` — gives us free CRUD: `save()`, `findById()`, `findAll()`, `delete()`
- Custom query method: `findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrDepartmentContainingIgnoreCase()` — Spring Data JPA auto-generates the SQL from the method name
- `findByEmail()` for looking up duplicates

### 4. Service Layer — `EmployeeService.java` + `EmployeeServiceImpl.java`

- **Interface** defines the contract: `getAllEmployees`, `getEmployeeById`, `createEmployee`, `updateEmployee`, `deleteEmployee`, `searchEmployees`
- **Implementation** contains the business logic:
  - `getAllEmployees()` — returns all, sorted by ID descending (newest first)
  - `getEmployeeById()` — finds by ID or throws `ResourceNotFoundException`
  - `createEmployee()` — persists new employee via repository
  - `updateEmployee()` — fetches existing, updates all fields, saves
  - `deleteEmployee()` — fetches existing, deletes from DB
  - `searchEmployees()` — delegates to repository search method

### 5. Controller — `EmployeeController.java`

- `@RestController` + `@RequestMapping("/api/employees")`
- Uses `@CrossOrigin(origins = "http://localhost:5173")` for Vite dev server
- All endpoints return `ResponseEntity<>` with appropriate HTTP status codes
- `@Valid` annotation triggers Bean Validation on request body

### 6. Exception Handling — `GlobalExceptionHandler.java`

- `@RestControllerAdvice` — intercepts exceptions globally
- Handles:
  - `ResourceNotFoundException` → 404 with message
  - `MethodArgumentNotValidException` → 400 with field-level errors
  - Generic `Exception` → 500 with message

### 7. CORS Configuration — `CorsConfig.java`

- Allows React dev server (`http://localhost:5173`) to call the API
- Permits `GET`, `POST`, `PUT`, `DELETE`, `OPTIONS` methods
- Allows all headers and credentials

---

## 🎨 Frontend (React) Flow

### 1. Entry Point — `main.jsx`

```
main.jsx → renders <App /> → into DOM #root
```

### 2. Routing — `App.jsx`

Uses `react-router-dom` with three routes:

| Path | Component | Purpose |
|------|-----------|---------|
| `/` | `HomePage` | Employee list dashboard |
| `/add` | `AddEmployeePage` | Create new employee form |
| `/edit/:id` | `EditEmployeePage` | Edit existing employee form |

The `<Navbar />` is rendered above `<Routes>` and appears on every page.

### 3. API Service — `services/EmployeeService.js`

- Creates an **Axios instance** with `baseURL: http://localhost:8080/api/employees`
- Exports functions: `getAllEmployees`, `getEmployeeById`, `createEmployee`, `updateEmployee`, `deleteEmployee`, `searchEmployees`
- Each function returns a Promise (Axios response)

### 4. Components

#### `Navbar.jsx`
- Sticky top navigation with gradient background
- Active route highlighting using `useLocation()`
- Responsive — icons only on mobile, icon+text on desktop

#### `SearchBar.jsx`
- Controlled input with search icon and clear button
- Calls parent callback on every keystroke (real-time search)

#### `EmployeeCard.jsx`
- Displays: avatar initials, name, department badge, email, phone, salary, join date
- Color-coded department badges and avatar backgrounds
- Edit/Delete buttons appear on hover (smooth transition)
- Uses `react-icons` for consistent iconography

#### `EmployeeList.jsx`
- Responsive grid: 1 column (mobile) → 2 columns (tablet) → 3 columns (desktop)
- Loading spinner state
- Empty state with helpful message

#### `EmployeeForm.jsx` (Reusable)
- Works for both **Create** and **Edit** modes via `isEdit` prop
- Pre-fills data in edit mode via `initialData` prop
- Client-side validation with real-time error clearing
- Server-side error handling (maps API error responses to form fields)
- Department dropdown with predefined options
- Cancel button navigates back to home

### 5. Pages

#### `HomePage.jsx`
- **On Mount:** Fetches all employees, calculates stats (total count, department count)
- **Search:** Calls API search endpoint on query change, clears on empty
- **Delete:** Confirmation dialog → API delete → removes from local state
- Displays stats summary in header

#### `AddEmployeePage.jsx`
- Renders `EmployeeForm` in create mode
- On submit: calls `createEmployee` API → navigates to home

#### `EditEmployeePage.jsx`
- Reads `id` from URL params via `useParams()`
- On mount: fetches employee by ID → populates form
- On submit: calls `updateEmployee` API → navigates to home
- Handles loading and error states (employee not found)

---

## 🔌 API Endpoints

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/api/employees` | List all employees | — | `200` + `Employee[]` |
| `GET` | `/api/employees/{id}` | Get single employee | — | `200` + `Employee` |
| `POST` | `/api/employees` | Create employee | `Employee` JSON | `201` + `Employee` |
| `PUT` | `/api/employees/{id}` | Update employee | `Employee` JSON | `200` + `Employee` |
| `DELETE` | `/api/employees/{id}` | Delete employee | — | `204` No Content |
| `GET` | `/api/employees/search?query=` | Search employees | — | `200` + `Employee[]` |

### Sample Request Body (POST / PUT)

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@company.com",
  "department": "Engineering",
  "salary": 85000,
  "phone": "+1-555-0101",
  "joinDate": "2024-01-15"
}
```

### Error Response Format

```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "messages": {
    "firstName": "First name is required",
    "email": "Please provide a valid email address"
  }
}
```

---

## 🔄 Data Flow - End to End

### Example: Creating a New Employee

```
User fills form → clicks "Add Employee"
        │
        ▼
EmployeeForm.jsx
  - Client-side validation (checks required fields)
  - Calls onSubmit(formData)
        │
        ▼
AddEmployeePage.jsx
  - Calls createEmployee(data) from EmployeeService.js
        │
        ▼
EmployeeService.js (Axios)
  - POST http://localhost:8080/api/employees
  - Body: { firstName, lastName, email, ... }
        │
        ▼ HTTP Request
        │
EmployeeController.java
  - @PostMapping → createEmployee(@Valid @RequestBody Employee)
  - @Valid triggers Bean Validation
        │
        ▼
EmployeeServiceImpl.java
  - createEmployee() → employeeRepository.save(employee)
        │
        ▼
EmployeeRepository.java (JPA)
  - Hibernate generates: INSERT INTO employees (...) VALUES (...)
        │
        ▼
MySQL Database
  - Row inserted into `employees` table
  - Auto-generated ID returned
        │
        ▼ Response bubbles back up
        │
EmployeeController → 201 Created + Employee JSON
  → Axios → AddEmployeePage → navigate('/')
    → HomePage fetches fresh list → renders updated grid
```

### Example: Search Flow

```
User types "Eng" in search bar
        │
        ▼
SearchBar.jsx → onQueryChange("Eng")
        │
        ▼
HomePage.jsx → handleSearch("Eng")
  → searchEmployees("Eng") from API service
        │
        ▼
GET /api/employees/search?query=Eng
        │
        ▼
EmployeeController → searchEmployees("Eng")
        │
        ▼
EmployeeServiceImpl → repository.findBy...("Eng", "Eng", "Eng")
        │
        ▼
Hibernate SQL:
  SELECT * FROM employees
  WHERE first_name LIKE '%Eng%'
     OR last_name LIKE '%Eng%'
     OR department LIKE '%Eng%'
        │
        ▼
Returns matching employees → rendered in grid
```

---

## 🚀 Setup & Running Instructions

### Prerequisites

- **Java 17+** (for Spring Boot)
- **Maven 3.8+** (for building the backend)
- **Node.js 18+** and **npm** (for the React frontend)
- **MySQL 8.0+** (database server)

### Step 1: Database Setup

```bash
# Login to MySQL
mysql -u root -p

# Create the database (or let Spring Boot auto-create it)
CREATE DATABASE IF NOT EXISTS employee_db;

# (Optional) Load seed data
source db/init.sql;
```

### Step 2: Configure Database Credentials

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.username=root        # ← Your MySQL username
spring.datasource.password=root        # ← Your MySQL password
```

### Step 3: Run the Spring Boot Backend

```bash
# From the project root directory
./mvnw spring-boot:run

# OR with Maven installed globally
mvn spring-boot:run
```

The API server starts at **http://localhost:8080**

### Step 4: Run the React Frontend

```bash
# Navigate to the frontend directory
cd frontend

# Install dependencies (if not done)
npm install

# Start the dev server
npm run dev
```

The React app starts at **http://localhost:5173**

### Step 5: Open the Application

Navigate to **http://localhost:5173** in your browser. The app will connect to the Spring Boot API at port 8080.

---

## 🎯 Design Decisions

### Why Spring Boot?
- Auto-configuration reduces boilerplate
- Embedded Tomcat server — no external server needed
- Spring Data JPA simplifies data access enormously
- Bean Validation integrates seamlessly with controllers

### Why React + Vite?
- Vite provides instant HMR (Hot Module Replacement) for fast development
- React's component model is perfect for reusable UI pieces
- React Router provides client-side navigation without full page reloads

### Why Tailwind CSS?
- Utility-first approach enables rapid UI development
- No context-switching between CSS files and components
- Consistent design system with built-in spacing, colors, and responsive breakpoints
- Smaller production CSS bundle (tree-shakes unused utilities)

### Why MySQL?
- Industry-standard relational database
- Strong ACID compliance for data integrity
- Excellent JPA/Hibernate support
- Easy to set up and widely available

### Why Layered Architecture?
- **Testability** — each layer can be unit-tested independently
- **Maintainability** — changes in one layer don't cascade to others
- **Scalability** — easy to add caching, pagination, or swap database

### Why Interface + Implementation for Service?
- Follows **Dependency Inversion Principle**
- Controller depends on abstraction, not concrete implementation
- Makes it trivial to swap implementations or mock for testing

---

## 📝 Future Enhancements

- [ ] **Pagination** — Add paginated API responses for large datasets
- [ ] **Authentication** — Add Spring Security with JWT tokens
- [ ] **Docker** — Containerize backend, frontend, and MySQL
- [ ] **File Upload** — Employee profile photo upload
- [ ] **Dashboard Analytics** — Charts showing department distribution, salary ranges
- [ ] **Export** — Export employee data to CSV/Excel
- [ ] **Dark Mode** — Toggle dark theme in the UI
- [ ] **Unit Tests** — JUnit tests for service layer, React Testing Library for components

