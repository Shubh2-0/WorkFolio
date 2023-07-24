package com.workfolio.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * GlobalExceptionHandler class handles exceptions globally for the WorkFolio
 * application. It intercepts specific types of exceptions and provides custom
 * error responses for better error handling and reporting. This centralized
 * exception handling helps improve the application's robustness and
 * maintainability.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Exception handler for EmployeeException. This method is triggered when an
	 * EmployeeException is thrown, typically from the EmployeeController class. It
	 * constructs a custom error response containing relevant error details and
	 * returns it as a ResponseEntity.
	 *
	 * @param me  The MethodArgumentNotValidException representing the
	 *            EmployeeException.
	 * @param req The WebRequest associated with the exception.
	 * @return A ResponseEntity containing a CustomError object representing the
	 *         error response.
	 */
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<CustomError> customerExceptionHandler(MethodArgumentNotValidException me, WebRequest req) {
		CustomError ed = new CustomError();
		ed.setDescription(req.getDescription(false));
		ed.setTimeStamp(LocalDateTime.now());
		ed.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(ed, HttpStatus.BAD_GATEWAY);
	}

	/**
	 * General exception handler for Exception class. This method is triggered when
	 * any other unhandled exception occurs within the application. It constructs a
	 * custom error response containing relevant error details and returns it as a
	 * ResponseEntity.
	 *
	 * @param ex  The Exception representing the unhandled exception.
	 * @param req The WebRequest associated with the exception.
	 * @return A ResponseEntity containing a CustomError object representing the
	 *         error response.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomError> ExceptionHandler(Exception ex, WebRequest req) {
		CustomError ed = new CustomError();
		ed.setDescription(req.getDescription(false));
		ed.setTimeStamp(LocalDateTime.now());
		ed.setMessage(ex.getMessage());
		return new ResponseEntity<>(ed, HttpStatus.BAD_GATEWAY);
	}
}
