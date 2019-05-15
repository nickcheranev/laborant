package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Bar;
import ru.company.laborant.jpa.domain.Foo;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface BarRepository extends JpaRepository<Bar, Integer> {
}
