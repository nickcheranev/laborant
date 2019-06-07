package ru.company.laborant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.company.laborant.jpa.domain.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaborantApplicationTests {

	@Test
	public void contextLoads() {
		Customer customer = new Customer("yutu", "ngf", "ghnhgnhg", "nhg");

	}

}
