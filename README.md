# Spring Boot H2 Unit Test Demo

This is a simple Spring Boot application built for learning purposes. The main goal is to **demonstrate how to use an in-memory H2 database with JUnit tests** in a CRUD-based user management system.

---

## 🔍 Project Goal

- Learn how to integrate **H2 database** for testing
- Practice **unit testing** and **Spring Data JPA**
- Use **MapStruct** for mapping between DTO and Entity
- Build a clean and maintainable **CRUD application for User**

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- H2 In-Memory Database
- MapStruct 1.5.5
- Lombok
- Maven

---

## 📦 Features

- Create, Read, Update, and Delete users
- Use MapStruct to map between Entity and DTO
- Run JUnit tests with in-memory H2 database
- Clean architecture with layered structure (Controller → Service → Repository)

---

## ⚙️ How to Run

### Run the app

```bash
./mvnw spring-boot:run
