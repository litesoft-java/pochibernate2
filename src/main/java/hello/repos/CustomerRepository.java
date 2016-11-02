package hello.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hello.model.*;

@SuppressWarnings("WeakerAccess")
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
