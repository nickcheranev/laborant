package ru.company.laborant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.company.laborant.jpa.dao.CustomerRepository;
import ru.company.laborant.jpa.domain.Customer;

@SpringBootApplication
public class LaborantApplication {
	private static final Logger log = LoggerFactory.getLogger(LaborantApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LaborantApplication.class, args);
	}
}
