# Online Book Store

## Overview

This is an online book store web application where users can register, search for books, and download digital books. Admins have additional privileges to manage books and users.

## Features

### Admin Privileges

- Add New Books
- View Available Books
- Edit Book Details
- Remove Books
- Remove Users
- Promote Users to Admin
- Ban Users

### User Privileges

- Register a New Account
- Login & Logout
- Search Books by Title and Type
- View Book Details
- View Available Books
- Select and Download Books
- Update User Profile Data

## Technologies Used

### Programming Language

- Java

### Web Framework

- Spring Boot

### Build Tool

- Maven

### ORM

- Spring Data JPA

### Testing

- JUnit
- Mockito

### Database

- PostgreSQL

### API

- REST

### Security

- JWT Authentication

## Installation & Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/online-book-store.git
   cd online-book-store
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/yourdbname
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

| Endpoint                  | Method | Description                     |
| ------------------------- | ------ | ------------------------------- |
| `/api/auth/register`      | POST   | Register a new user             |
| `/api/auth/login`         | POST   | User login                      |
| `/api/books`              | GET    | Get all books                   |
| `/api/books/{id}`         | GET    | Get book details by ID          |
| `/api/books`              | POST   | Add a new book (Admin)          |
| `/api/books/{id}`         | PUT    | Edit book details (Admin)       |
| `/api/books/{id}`         | DELETE | Remove a book (Admin)           |
| `/api/users/{id}/promote` | PUT    | Promote a user to admin (Admin) |
| `/api/users/{id}/ban`     | PUT    | Ban a user (Admin)              |

## License

This project is licensed under the MIT License.

## Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue.

## Contact

For any questions or support, please reach out via

ezedinadefa\@gmail.com

