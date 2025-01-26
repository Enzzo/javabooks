package ru.vasilev.simpleapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class SimpleAppApplication {

	@Value("${profile}")
	private String profile;
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleAppApplication.class, args);
	}
	
	@GetMapping("/{firstName}")
	public String helloGET(@PathVariable("firstName") String firstName, 
			@RequestParam("lastName") String lastName) {
		return String.format("{\"message\": \"Hello %s %s\",\n \"profile\" : \"%s\"}", firstName, lastName, profile);
	}
}

@Data
class HelloRequest{
	private final String firstName;
	private final String lastName;
}