package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Customer;
import ru.company.laborant.jpa.domain.TraitObject;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface TraitObjectRepository extends JpaRepository<TraitObject, Long>{
    Optional<TraitObject> findById(Long id);
}
