package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Customer;
import ru.company.laborant.jpa.domain.StatType;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface StatTypeRepository extends JpaRepository<StatType, Long>{
    Optional<StatType> findById(Long id);
}
