package com.workfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workfolio.entity.Employee;

/**
 * EmployeeRepository interface is a Spring Data JPA repository that handles
 * data access for the Employee entity. It extends the JpaRepository, providing
 * out-of-the-box CRUD (Create, Read, Update, Delete) operations for the
 * Employee entity. This interface enables easy and efficient interaction with
 * the underlying database for Employee-related operations.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/**
	 * Custom method to find an Employee by their email address. This method allows
	 * searching for an Employee based on their unique email.
	 *
	 * @param email The email address of the Employee to be found.
	 * @return The Employee entity with the specified email, or null if not found.
	 */
	public Employee findByEmail(String email);
}
