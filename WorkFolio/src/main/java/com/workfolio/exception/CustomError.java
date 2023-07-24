package com.workfolio.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CustomError class represents a custom exception response used in the
 * WorkFolio application. It encapsulates detailed information about errors or
 * exceptions that occur during the application's operation. This class provides
 * a structured format to present meaningful error data to clients for effective
 * debugging and issue resolution.
 */

@Data
@NoArgsConstructor
public class CustomError {

	/**
	 * Timestamp when the error occurred, represented using the LocalDateTime class
	 * from Java's date and time API. This helps identify the exact date and time of
	 * the error for debugging and auditing purposes.
	 */
	private LocalDateTime timeStamp;

	/**
	 * Error message associated with the exception. It provides a brief description
	 * of the error or exception to aid developers and users in understanding the
	 * issue.
	 */
	private String message;

	/**
	 * A detailed description of the error or exception. This field provides
	 * additional context and insights into the nature of the error, helping
	 * developers diagnose the root cause.
	 */
	private String description;

	/**
	 * Constructs a new CustomError object with the specified error message and
	 * description.
	 *
	 * @param timeStamp   The timestamp when the error occurred.
	 * @param message     The error message associated with the exception.
	 * @param description A detailed description of the error or exception.
	 */
	public CustomError(LocalDateTime timeStamp, String message, String description) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.description = description;
	}

	// Getters and setters for the attributes are automatically generated using
	// Lombok's @Data annotation.
}
