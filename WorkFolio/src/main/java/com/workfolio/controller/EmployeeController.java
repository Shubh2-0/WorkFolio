package com.workfolio.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.workfolio.entity.Employee;
import com.workfolio.exception.EmployeeException;
import com.workfolio.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

/**
 * Controller class for managing Employee-related operations and views in the
 * WorkFolio application. This class handles HTTP requests and responses related
 * to employee management, such as adding, updating, and deleting employees. It
 * also provides pagination support to display a list of employees in a
 * paginated manner. The EmployeeController interacts with the EmployeeService,
 * which is responsible for business logic and data access related to employees.
 *
 * The controller includes methods to display the home page, which lists all
 * employees in a paginated manner, and also provides a form to add a new
 * employee. Additionally, it supports updating and deleting employees by their
 * unique IDs. The class uses JavaServer Pages (JSP) templates for rendering
 * views and Spring MVC's Model object to pass data to the views. It handles
 * user input and validation using the @Valid annotation in conjunction with the
 * Employee entity's validation rules.
 *
 * This controller class promotes good software design practices by following
 * the Single Responsibility Principle (SRP) and separating concerns. It
 * delegates business logic and data access responsibilities to the
 * EmployeeService class, which ensures loose coupling and maintainability of
 * the application. Furthermore, it leverages Spring's dependency injection
 * capability (@Autowired) to obtain an instance of the EmployeeService class,
 * promoting modularity and testability.
 *
 * The EmployeeController class also interacts with the HttpSession object to
 * store success messages, which can be used to provide user feedback after
 * successful operations (e.g., adding or updating an employee). These success
 * messages are displayed to users on the index page of the application.
 *
 * Overall, the EmployeeController plays a critical role in the WorkFolio
 * application, allowing users to interact with employee data, perform CRUD
 * (Create, Read, Update, Delete) operations, and view paginated lists of
 * employees. It ensures a smooth user experience and acts as a bridge between
 * the front-end (views) and back-end (services and data access) components of
 * the application.
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	/**
	 * Handles the HTTP GET request for the home page of the WorkFolio application.
	 * This method retrieves a list of all employees from the EmployeeService and
	 * adds them to the model attribute. It then calls the findPaginatedHandler
	 * method to display the list of employees in a paginated manner on the index
	 * page. The paginated list is retrieved based on the page number passed as a
	 * path variable. The method also handles any EmployeeException that may occur
	 * during the retrieval of employee data, ensuring proper error handling. The
	 * list of employees and the paginated details are added to the model to be
	 * displayed in the view.
	 *
	 * @param m the Model object to pass data to the view
	 * @return the name of the view template to be rendered (index.html)
	 * @throws EmployeeException if an error occurs during the retrieval of employee
	 *                           data
	 */
	@GetMapping("/home")
	public String homeHandler(Model m) throws EmployeeException {
		List<Employee> employees = service.getAllEmployee();
		m.addAttribute("employees", employees);
		return findPaginatedHandler(0, m);
	}

	/**
	 * Handles the HTTP GET request to display the form for adding a new employee in
	 * the WorkFolio application. This method returns the name of the view template
	 * (addEmployee.html) that contains the form to collect user input for adding a
	 * new employee. The form allows users to enter details such as employee name,
	 * designation, salary, etc., to create a new employee record. This method is
	 * responsible for rendering the form view, which is displayed to the user when
	 * they wish to add a new employee.
	 *
	 * @return the name of the view template to be rendered (addEmployee.html)
	 */
	@GetMapping("/add")
	public String addEmployeeFormHandler() {
		return "addEmployee";
	}

	/**
	 * Handles the HTTP POST request to add a new employee to the WorkFolio
	 * application. This method takes an Employee object as input and adds a new
	 * employee to the database using the EmployeeService. The @Valid annotation
	 * ensures that the input data is validated against the validation rules
	 * specified in the Employee entity. If the data is valid, the new employee is
	 * added to the database with a randomly generated unique ID (using
	 * ThreadLocalRandom). A success message is stored in the HttpSession to provide
	 * feedback to the user after successful addition of the employee. The method
	 * then retrieves the updated list of all employees and adds them to the model
	 * attribute to be displayed on the index page.
	 *
	 * @param emp     the Employee object representing the details of the new
	 *                employee to be added
	 * @param session the HttpSession to store the success message
	 * @param m       the Model object to pass data to the view
	 * @return the name of the view template to be rendered (index.html) with the
	 *         updated list of employees
	 * @throws EmployeeException if an error occurs during the addition of the new
	 *                           employee
	 */
	@PostMapping("/register")
	public String addNewEmployeehandler(@Valid @ModelAttribute Employee emp, HttpSession session, Model m)
			throws EmployeeException {
		emp.setId(ThreadLocalRandom.current().nextInt(198));
		service.addEmployee(emp);
		session.setAttribute("msg", "Employee successfully added....");
		List<Employee> employees = service.getAllEmployee();
		m.addAttribute("employees", employees);
		return "index";
	}

	/**
	 * Handles the HTTP GET request to update an existing employee in the WorkFolio
	 * application. This method takes the unique ID of the employee to be updated as
	 * a path variable and retrieves the corresponding employee details from the
	 * EmployeeService. The employee details are then trimmed using the service's
	 * trimProperties method to remove any leading or trailing white spaces. The
	 * updated employee object is then passed to the service for updating the
	 * employee in the database. The method adds the updated employee to the model
	 * attribute to be displayed in the updateEmployee view, where users can make
	 * changes to the employee details. This method is responsible for rendering the
	 * updateEmployee.html view template.
	 *
	 * @param id      the unique ID of the employee to be updated
	 * @param session the HttpSession to store the success message
	 * @param m       the Model object to pass data to the view
	 * @return the name of the view template to be rendered (updateEmployee.html)
	 *         with the employee details to be updated
	 * @throws EmployeeException if an error occurs during the retrieval or update
	 *                           of the employee details
	 */
	@GetMapping("/update/{id}")
	public String updateEmployeeHandler(@PathVariable int id, HttpSession session, Model m) throws EmployeeException {
		Employee e = service.getEmployeeById(id);
		service.trimProperties(e);
		service.updateEmployee(e);
		m.addAttribute("emp", e);
		return "updateEmployee";
	}

	/**
	 * Handles the HTTP GET request to update an existing employee with modified
	 * details in the WorkFolio application. This method takes an Employee object as
	 * input, which contains the updated details of the employee to be saved. The
	 * employee details are first trimmed using the service's trimProperties method
	 * to remove any leading or trailing white spaces. The updated employee object
	 * is then passed to the service for updating the employee in the database. A
	 * success message is stored in the HttpSession to provide feedback to the user
	 * after successful update of the employee. The method then retrieves the
	 * updated list of all employees and adds them to the model attribute to be
	 * displayed on the index page.
	 *
	 * @param employee the Employee object representing the updated details of the
	 *                 employee
	 * @param session  the HttpSession to store the success message
	 * @param m        the Model object to pass data to the view
	 * @return the name of the view template to be rendered (index.html) with the
	 *         updated list of employees
	 * @throws EmployeeException if an error occurs during the update of the
	 *                           employee details
	 */
	@GetMapping("/update")
	public String updateEmployeeHandler2(@ModelAttribute Employee employee, HttpSession session, Model m)
			throws EmployeeException {
		service.trimProperties(employee);
		service.updateEmployee(employee);
		session.setAttribute("msg", "Employee successfully updated....");
		List<Employee> employees = service.getAllEmployee();
		m.addAttribute("employees", employees);
		return "index";
	}

	/**
	 * Handles the HTTP GET request to delete an existing employee from the
	 * WorkFolio application. This method takes the unique ID of the employee to be
	 * deleted as a path variable and calls the EmployeeService to delete the
	 * employee with the corresponding ID from the database. A success message is
	 * stored in the HttpSession to provide feedback to the user after successful
	 * deletion of the employee. The method then redirects the user to the home page
	 * to display the updated list of employees after the deletion.
	 *
	 * @param id      the unique ID of the employee to be deleted
	 * @param session the HttpSession to store the success message
	 * @return a redirect response to the home page (index.html) after the deletion
	 * @throws EmployeeException if an error occurs during the deletion of the
	 *                           employee
	 */
	@GetMapping("/delete/{id}")
	public String deleteEmployeehandler(@PathVariable int id, HttpSession session) throws EmployeeException {
		service.deleteEmployee(id);
		session.setAttribute("msg", "Employee data deleted successfully...");
		return "redirect:/";
	}

	/**
	 * Handles the HTTP GET request for paginated display of employees in the
	 * WorkFolio application. This method takes the page number as a path variable
	 * and calls the EmployeeService to retrieve a paginated list of employees based
	 * on the page number and the number of employees per page (in this case, 2
	 * employees per page). The paginated list of employees is then added to the
	 * model attribute, along with information about the current page number, total
	 * number of pages, and total number of items (employees) available. This
	 * information is used to display pagination links in the index.html view.
	 *
	 * @param pageno the page number to retrieve the paginated list of employees
	 * @param m      the Model object to pass data to the view
	 * @return the name of the view template to be rendered (index.html) with the
	 *         paginated list of employees
	 * @throws EmployeeException if an error occurs during the retrieval of
	 *                           paginated employee data
	 */
	@GetMapping("/page/{pageno}")
	public String findPaginatedHandler(@PathVariable int pageno, Model m) throws EmployeeException {

		Page<Employee> emplist = service.getEmployeeByPaginate(pageno, 2);
		m.addAttribute("emp", emplist);
		m.addAttribute("currentPage", pageno);
		m.addAttribute("totalPages", emplist.getTotalPages());
		m.addAttribute("totalItem", emplist.getTotalElements());
		return "index";
	}

}