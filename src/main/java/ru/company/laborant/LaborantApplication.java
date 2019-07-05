package ru.company.laborant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.company.laborant.jpa.dao.CustomerRepository;
import ru.company.laborant.jpa.dao.TrialTypeRepository;
import ru.company.laborant.jpa.domain.Customer;
import ru.company.laborant.jpa.domain.TrialType;

@SpringBootApplication
public class LaborantApplication {
	private static final Logger log = LoggerFactory.getLogger(LaborantApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LaborantApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CustomerRepository repository, TrialTypeRepository trialTypeRepository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer", "222222", "222222"));
			repository.save(new Customer("Chloe", "O'Brian", "555", "555"));
			repository.save(new Customer("Kim", "Bauer", "333","333"));
			trialTypeRepository.save((new TrialType("Химическое", "Пациент подвергается химическому воздействию")));
		};
	}
}