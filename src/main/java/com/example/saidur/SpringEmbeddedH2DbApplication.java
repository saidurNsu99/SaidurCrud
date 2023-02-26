package com.example.saidur;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringEmbeddedH2DbApplication {
	@Autowired
	private ObjectMapper objectMapper;
	public static void main(String[] args) {
		SpringApplication.run(SpringEmbeddedH2DbApplication.class, args);
	}

	@PostConstruct
	public void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
	}
}
