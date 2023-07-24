# 📘 WorkFolio - Employee Management Web Application

WorkFolio is a powerful and intuitive web application designed to streamline employee data management for organizations. The application provides a user-friendly interface to perform various CRUD (Create, Read, Update, Delete) operations on employee records. Built using Java, Spring Boot, Thymeleaf, and Bootstrap, WorkFolio offers a robust and efficient solution for managing employee data. 🚀


<div align="center">
  <img alt="Demo" src="README_IMAGES/Workfolio.png"/>
</div>

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
   git clone https://github.com/Shubh2-0/WorkFolio.git
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


| Technology             | Description                                                                                                                             |
|------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| <img src="README_IMAGES/java.png" alt="Java Icon" width="100px" style="padding: 10px;">             | Java: The primary programming language used in WorkFolio to build the backend logic and handle data processing efficiently.              |
| <img src="README_IMAGES/springb.png" alt="Spring Boot Icon" width="100px" style="padding: 10px;">       | Spring Boot: The powerful framework chosen for developing WorkFolio, allowing us to create a web application with minimal configuration.|
| <img src="README_IMAGES/thymeleaf.png" alt="Thymeleaf Icon" width="100px" style="padding: 10px;">      | Thymeleaf: A modern server-side Java template engine utilized in WorkFolio to render dynamic HTML templates and enhance user experience. |
| <img src="README_IMAGES/bootstrap.png" alt="Bootstrap Icon" width="100px" style="padding: 10px;">      | Bootstrap: A popular CSS framework integrated into WorkFolio to create responsive and visually appealing user interfaces across devices.   |
| <img src="README_IMAGES/mysql.png" alt="MySQL Icon" width="100px" style="padding: 10px;">             | MySQL: The chosen relational database management system in WorkFolio to store and manage employee data securely and efficiently.            |
| <img src="README_IMAGES/maven.png" alt="Maven Icon" width="100px" style="padding: 10px;">             | Maven: The build tool utilized in WorkFolio to compile, package, and manage project dependencies, ensuring smooth development workflows.   |
| <img src="README_IMAGES/github.png" alt="GitHub Icon" width="100px" style="padding: 10px;">           | GitHub: WorkFolio uses GitHub as a version control platform to manage code collaboration and maintain a centralized repository for the app. |
| <img src="README_IMAGES/springsecutity.png" alt="Spring Security Icon" width="100px" style="padding: 10px;"> | Spring Security: Basic Spring Security is implemented in WorkFolio to provide authentication and authorization, ensuring secure access to the application's features.|
| <img src="README_IMAGES/emmet.png" alt="Emmet Icon" width="100px" style="padding: 10px;">             | Emmet: An essential plugin in WorkFolio's text editor that significantly enhances HTML and CSS workflow, enabling faster and more efficient coding. |
| <img src="README_IMAGES/netlify.png" alt="Netlify Icon" width="100px" style="padding: 10px;">         | Netlify: WorkFolio utilizes Netlify, a cloud-based hosting service, to deploy and manage the web application, providing a seamless user experience.|
| <img src="README_IMAGES/restful.png" alt="RESTful Icon" width="100px" style="padding: 10px;">         | RESTful API: An architectural style adopted in WorkFolio for designing networked applications, enabling efficient communication between components.|
| <img src="README_IMAGES/eclipse.png" alt="Eclipse Icon" width="100px" style="padding: 10px;">         | Eclipse IDE: The preferred integrated development environment (IDE) in WorkFolio, providing advanced tools and features for Java development.  |
| <img src="README_IMAGES/lambok.png" alt="Lombok Icon" width="100px" style="padding: 10px;">           | Lombok: A helpful Java library in WorkFolio that automatically plugs into the editor and builds tools, simplifying and enhancing Java coding.   |

By leveraging this specific tech stack, WorkFolio achieves its goal of providing a seamless user experience and efficient management of employee data while maintaining a secure and reliable application environment. 🚀🔒

## Contributing

Contributions to WorkFolio are highly welcome! If you encounter any issues or have suggestions for improvements, feel free to create a new issue or submit a pull request. Together, we can enhance the application and make it even better. 👨‍💻👩‍💻

Enjoy using WorkFolio and have a productive day! 😊
