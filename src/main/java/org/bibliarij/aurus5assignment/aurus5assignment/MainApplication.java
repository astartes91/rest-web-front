package org.bibliarij.aurus5assignment.aurus5assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring boot application main class
 */
@EnableSwagger2
@SpringBootApplication
public class MainApplication {

	/**
	 * Spring boot application main method
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
