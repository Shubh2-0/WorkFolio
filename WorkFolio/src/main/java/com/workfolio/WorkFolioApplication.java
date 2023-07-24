package com.workfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class that starts the WorkFolio application.
 * <p>
 * This class serves as the entry point to the WorkFolio application. It
 * initializes the Spring Boot framework and configures the necessary components
 * to run the application.
 * </p>
 * <p>
 * The WorkFolio application is a platform that allows employees to showcase
 * their work portfolio. It enables users to add, update, and delete their work
 * samples, personal details, and achievements. The application provides a
 * user-friendly interface for both employees and potential employers to explore
 * and evaluate the employees' skills and accomplishments.
 * </p>
 * <p>
 * To start the WorkFolio application, simply execute the main method in this
 * class. It will initialize the Spring Boot context, which in turn loads the
 * required components and starts the embedded web server. The application can
 * be accessed through the defined endpoints and web pages.
 * </p>
 * <p>
 * The WorkFolioApplication class uses the {@link SpringBootApplication}
 * annotation, which is a composite annotation that combines
 * {@link org.springframework.context.annotation.Configuration @Configuration},
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration @EnableAutoConfiguration},
 * and
 * {@link org.springframework.context.annotation.ComponentScan @ComponentScan}
 * annotations. This simplifies the configuration and startup process of the
 * Spring Boot application.
 * </p>
 *
 * @see SpringBootApplication
 */
@SpringBootApplication
public class WorkFolioApplication {

	/**
	 * The main method to start the WorkFolio application.
	 * <p>
	 * This method is the entry point of the WorkFolio application. It is
	 * responsible for starting the Spring Boot framework, which initializes the
	 * application context and sets up the necessary components to run the
	 * application. The embedded web server will be started, and the application
	 * will be accessible through the specified endpoints and web pages.
	 * </p>
	 *
	 * @param args The command-line arguments passed to the application (unused in
	 *             this context).
	 */
	public static void main(String[] args) {
		SpringApplication.run(WorkFolioApplication.class, args);
	}
}
