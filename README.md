# Student Management System (Full Stack)

A full-stack **Student Management System** built using **Java, Spring Boot, JDBC, MySQL**, and a **web-based UI** using **HTML, CSS, and JavaScript**.  
The application supports **complete CRUD operations** through REST APIs and an interactive browser-based interface.

---

##  Features

- Add new students
- View all students
- Update student details
- Delete students
- Web UI connected to backend via REST APIs
- Secure database configuration using environment variables

---

## Tech Stack

### Backend
- Java
- Spring Boot
- JDBC
- MySQL
- REST APIs

### Frontend
- HTML
- CSS
- JavaScript (Fetch API)

### Tools
- IntelliJ IDEA
- Postman
- Git & GitHub

---

## Project Structure

student-management-system
- controller   (REST controllers)
- service      (Business logic)
- dao          (Database access - JDBC)
- model        (Entity classes)
- util         (Utility & DB config)
- static       (HTML, CSS, JS - UI)
- pom.xml
- README.md


---

##REST API Endpoints

| Method | Endpoint           | Description         |
|--------|--------------------|---------------------|
| POST   | `/students`        | Add a new student   |
| GET    | `/students`        | Get all students    |
| PUT    | `/students/{id}`   | Update student      |
| DELETE | `/students/{id}`   | Delete student      |

---

## Database Configuration

The database password is **not hardcoded**.  
It is read securely using an **environment variable**.

### Environment Variable

DB_PASSWORD=your_mysql_password
### Used in Code
```java
System.getenv("DB_PASSWORD");

How to Run the Project

Clone the repository

git clone https://github.com/voidirl/student-management-system-java.git


Open the project in IntelliJ IDEA

Set the environment variable

DB_PASSWORD=your_mysql_password


Run the Spring Boot application

Open in browser

http://localhost:8080/index.html
```

Testing

  REST APIs tested using Postman

  Frontend communicates with backend using Fetch API

Learning Outcomes

  Built RESTful APIs using Spring Boot

  Integrated JDBC with MySQL

 Implemented full CRUD operations

  Connected frontend with backend

  Debugged real-world Spring Boot issues

Followed clean architecture & Git best practices
