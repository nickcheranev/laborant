package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Trait;

import java.util.List;
import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface TraitRepository extends JpaRepository<Trait, Long> {
    Optional<Trait> findById(Long id);
    List<Trait> findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String s, String s1);
}
