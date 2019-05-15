package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Customer;
import ru.company.laborant.jpa.domain.Foo;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface FooRepository extends JpaRepository<Foo, Integer> {
}
