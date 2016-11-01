package hello;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	// private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode( Banner.Mode.OFF);

        app.run(args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Customer customer : repository.findAll()) {
				System.out.println(customer.toString());
			}
            System.out.println("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			System.out.println("Customer found with findOne(1L):");
			System.out.println("--------------------------------");
			System.out.println(customer.toString());
            System.out.println("");

			// fetch customers by last name
			System.out.println("Customer(s) found with findByLastName('Bauer'):");
			System.out.println("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				System.out.println(bauer.toString());
			}
            System.out.println("");
		};
	}

}
