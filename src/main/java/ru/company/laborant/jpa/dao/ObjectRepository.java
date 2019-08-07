package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Object;

import java.util.List;
import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface ObjectRepository extends JpaRepository<Object, Long> {
    Optional<Object> findById(Long id);
    List<Object> findAllByNameContainingIgnoreCase(String s);
}
