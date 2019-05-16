package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.TrialType;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface TrialTypeRepository extends JpaRepository<TrialType, Long> {
    Optional<TrialType> findById(Long id);
}
