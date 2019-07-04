package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.company.laborant.jpa.domain.Customer;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer>findAllByFullNameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrPostIndexContainingIgnoreCase(String s1, String s2, String s3, String s4);
}