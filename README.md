# 📘 WorkFolio - Employee Management Web Application

WorkFolio is a powerful and intuitive web application designed to streamline employee data management for organizations. The application provides a user-friendly interface to perform various CRUD (Create, Read, Update, Delete) operations on employee records. Built using Java, Spring Boot, Thymeleaf, and Bootstrap, WorkFolio offers a robust and efficient solution for managing employee data. 🚀


## Table of Contents

- 📝 [Introduction](#introduction)
- ✨ [Features](#features)
- ⚙️ [Prerequisites](#prerequisites)
- 🛠️ [Installation](#installation)
- 🎯 [Usage](#usage)
- 🚀 [Technologies Used](#technologies-used)
- 🤝 [Contributing](#contributing)


## Introduction

WorkFolio aims to simplify the process of managing employee information for businesses of all sizes. It provides a comprehensive and user-friendly platform to add, view, update, and delete employee records with ease. The application empowers HR departments and administrators to maintain accurate and up-to-date employee data, enhancing organizational efficiency. 🌐💼

## Features

- ➕ **Add New Employee:** Easily add new employees to the system with essential details, including name, email, phone, address, and salary.
- 👀 **View Employee Records:** Browse through a paginated table to view all employee records, making it convenient to access and manage the information.
- 🔄 **Update Employee Details:** Effortlessly update employee information, such as name, email, phone, address, and salary, whenever required.
- ❌ **Delete Employee Records:** Remove employee data from the system when needed, ensuring data accuracy and compliance with privacy regulations.
- ✔️ **Input Validation:** Implement strict input validation to ensure correct and consistent data entry, preventing errors and data discrepancies.
- 📱 **Responsive Design:** Enjoy a seamless user experience on various devices, thanks to the application's responsive design.

## Prerequisites

Before running the WorkFolio application, make sure you have the following prerequisites in place:

- ☕ **Java Development Kit (JDK):** Version 8 or higher installed on your system.
- 🧰 **Maven:** Ensure you have the Maven build tool installed to compile and manage the project.
- 🗄️ **MySQL Database:** Have a MySQL database set up and running to store employee data.
- 🌐 **Web Browser:** Use any modern web browser to access the application.

## Installation

1. **Clone the Repository:** Begin by cloning the WorkFolio repository to your local machine using Git:

   ```bash
   git clone https://github.com/your-username/workfolio.git
   ```

2. **Navigate to the Project Directory:** Move into the project directory using the following command:

   ```bash
   cd workfolio
   ```

3. **Build the Project:** Use Maven to build the project and handle dependencies:

   ```bash
   mvn clean package
   ```

4. **Configure the Database Connection:** Update the database connection details in the `application.properties` file:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/workfolio
   spring.datasource.username=your-mysql-username
   spring.datasource.password=your-mysql-password
   ```

5. **Run the Application:** Start the WorkFolio application using Maven:

   ```bash
   mvn spring-boot:run
   ```

## Usage

1. **Access the Application:** Open your web browser and navigate to `http://localhost:8080` to access the WorkFolio application.
2. **Home Page:** The homepage displays a paginated table containing all employee records.
3. **Add New Employee:** Click on "Add New Employee" in the navigation menu to create a new employee record by providing relevant details.
4. **Edit Employee Details:** To modify an existing employee's information, click the "Edit" button next to the employee's entry in the table and update the necessary fields.
5. **Delete Employee Records:** To remove an employee's data from the system, click the "Delete" button next to the employee's entry in the table.

## Technologies Used

WorkFolio leverages a range of technologies to provide a seamless user experience and efficient management of employee data:

- ☕ **Java:** The primary programming language for building the application's backend logic.
- ⚙️ **Spring Boot:** The powerful framework used to develop the web application with minimal configuration.
- 🎨 **Thymeleaf:** A modern server-side Java template engine for rendering dynamic HTML templates.
- 🎨 **Bootstrap:** A popular CSS framework for creating responsive and visually appealing user interfaces.
- 🗄️ **MySQL:** The chosen relational database management system to store and manage employee data.
- 🧰 **Maven:** The build tool used to compile, package, and manage project dependencies.

## Contributing

Contributions to WorkFolio are highly welcome! If you encounter any issues or have suggestions for improvements, feel free to create a new issue or submit a pull request. Together, we can enhance the application and make it even better. 👨‍💻👩‍💻

Enjoy using WorkFolio and have a productive day! 😊
