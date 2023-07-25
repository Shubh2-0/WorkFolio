package com.workfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.workfolio.entity.Employee;
import com.workfolio.exception.EmployeeException;
import com.workfolio.repository.EmployeeRepository;

/**
 * The EmployeeServiceImpl class is the implementation of the EmployeeService
 * interface, providing methods to manage employee data and perform various
 * operations. It interacts with the underlying database through the
 * EmployeeRepository.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Adds a new employee to the database if an employee with the same id or email
	 * doesn't already exist. Throws an EmployeeException with an appropriate
	 * message if an employee with the same id or email is found.
	 *
	 * @param e The Employee object to be added.
	 * @throws EmployeeException if an employee with the same id or email already
	 *                           exists.
	 */
	@Override
	public void addEmployee(Employee e) throws EmployeeException {

		if (employeeRepository.findById(e.getId()).isPresent())
			throw new EmployeeException("the employee already present with that id");

		else if (employeeRepository.findByEmail(e.getEmail()) != null)
			throw new EmployeeException("the employee already present with that email");

		else
			employeeRepository.save(e);

	}

	/**
	 * Retrieves a list of all employees from the database.
	 *
	 * @return The list of all employees.
	 * @throws EmployeeException if an error occurs while retrieving the employees.
	 */
	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {

		List<Employee> employees = employeeRepository.findAll();

		return employees;
	}

	/**
	 * Retrieves an employee from the database based on the provided id.
	 *
	 * @param id The id of the employee to retrieve.
	 * @return The Employee object with the specified id.
	 * @throws EmployeeException if no employee is found with the given id.
	 */
	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeException("no employee found with that id : " + id));

	}

	/**
	 * Deletes an employee from the database based on the provided id.
	 *
	 * @param id The id of the employee to delete.
	 * @throws EmployeeException if no employee is found with the given id.
	 */

	@Override
	public void deleteEmployee(int id) throws EmployeeException {

		Optional<Employee> optional = employeeRepository.findById(id);

		if (optional.isEmpty())
			throw new EmployeeException("no employee found with that id");

		employeeRepository.deleteById(id);

	}

	/**
	 * Retrieves a paginated list of employees from the database.
	 *
	 * @param currentPage The current page number.
	 * @param size        The number of items per page.
	 * @return A Page object containing the list of employees for the specified page
	 *         and size.
	 * @throws EmployeeException if an error occurs while retrieving the employees.
	 */
	@Override
	public Page<Employee> getEmployeeByPaginate(int currentPage, int size) throws EmployeeException {

		PageRequest p = PageRequest.of(currentPage, size);
		return employeeRepository.findAll(p);

	}

	/**
	 * Updates an existing employee in the database based on the provided Employee
	 * object. Only properties that are not null will be updated, ensuring partial
	 * updates are possible.
	 *
	 * @param e The Employee object containing the updated data.
	 * @throws EmployeeException if no employee is found with the given id or if the
	 *                           email is already taken.
	 */
	@Override
	public void updateEmployee(Employee e) throws EmployeeException {

		Optional<Employee> optional = employeeRepository.findById(e.getId());

		if (optional.isEmpty())
			throw new EmployeeException("no employee preasent with this id :" + e.getId());

		Employee emp = optional.get();

		if (e.getAddress() != null)
			emp.setAddress(e.getAddress());

		if (e.getSalary() > 5000 && e.getSalary() < 200000)
			emp.setSalary(e.getSalary());

		if (e.getName() != null)
			emp.setName(e.getName());

		if (e.getEmail() != null) {

			Optional<Employee> optional2 = Optional.ofNullable(employeeRepository.findByEmail(e.getEmail()));

			if (optional2.isEmpty())
				emp.setEmail(e.getEmail());

		}

		if (e.getPhone() != null && e.getPhone().length() == 10)
			emp.setPhone(e.getPhone());

		employeeRepository.save(emp);

	}

	/**
	 * Trims the leading and trailing spaces from the properties of the Employee
	 * object.
	 *
	 * @param emp The Employee object to trim.
	 */
	@Override
	public void trimProperties(Employee emp) {

		emp.setAddress(emp.getAddress().trim());
		emp.setEmail(emp.getEmail().trim());
		emp.setName(emp.getName().trim());
		emp.setPhone(emp.getPhone().trim());

	}
}
