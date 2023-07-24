package com.workfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	private Integer id;

	/**
	 * Name of the employee.
	 */
	@Null(message = "Name should not be null")
	@Size(min = 2, max = 50, message = "Name should consist of a minimum of 2 characters and a maximum of 50 characters.")
	@NotBlank(message = "Invalid Employee Name")
	private String name;

	/**
	 * The address of the employee.
	 */
	private String address;

	/**
	 * Email address of the employee. It must be unique and cannot be null.
	 */
	@NotNull(message = "email should not be null")
	@Email(message = "Invalid Email")
	@NotBlank(message = "Invalid Employee Name")
	@Column(unique = true, nullable = false)
	private String email;

	/**
	 * Phone number of the employee. It must be a valid phone number without country
	 * code.
	 */
	@NotNull(message = "Employee number should not be null")
	@Size(min = 10, max = 10, message = "please provide a valid phone number without country code")
	@NotBlank(message = "Invalid Employee Number")
	private String phone;

	/**
	 * Salary of the employee. It must be a positive value and at least 5000.
	 */
	@NotNull(message = "Employee salary should not be null")
	@Positive(message = "Salary must be a positive value")
	@Min(value = 5000, message = "Salary must be at least 5000")
	private Double salary;

}
