package hello.application;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import hello.model.*;
import hello.repos.*;

@Component
@Profile("!test")
public class OurCLIRunner implements CommandLineRunner {

    private final CustomerRepository repository;

    @Autowired
    public OurCLIRunner( CustomerRepository repository ) {
        this.repository = repository;
    }

    @Override
    public void run( String... args )
            throws Exception {
        Customer zCustomer = new Customer( "Jack", "Bauer");
        System.out.println("Initial Customer:");
        System.out.println("    " + zCustomer);
        System.out.println("");

        // save a couple of customers
        Customer zCustomerPostSave = repository.save(zCustomer);
        System.out.println("Initial Customer (after save) & (post save) Customer:");
        System.out.println("  < " + zCustomer);
        System.out.println("  > " + zCustomerPostSave);
        System.out.println("");

        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        for (Customer c : repository.findAll()) {
            System.out.println("    " + c);
        }
        System.out.println("");

        // fetch an individual customer by ID
        zCustomer = repository.findOne(1L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("    " + zCustomer);
        System.out.println("");

        // fetch customers by last name
        System.out.println("Customer(s) found with findByLastName('Bauer'):");
        for (Customer c : repository.findByLastName("Bauer")) {
            System.out.println("    " + c);
        }
        System.out.println("");
    }
}
