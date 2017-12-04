package org.bibliarij.aurus5assignment.aurus5assignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring boot application main class
 */
@EnableSwagger2
@SpringBootApplication
public class MainApplication {

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		return mapper;
	}

	/**
	 * Spring boot application main method
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
