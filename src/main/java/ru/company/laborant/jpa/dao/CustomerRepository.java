package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);
    List<Customer> findByFullNameStartsWithIgnoreCase(String fullName);
}