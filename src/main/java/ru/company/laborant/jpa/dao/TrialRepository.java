package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Trial;

/**
 * @author Cheranev N.
 * created on 17.05.2019.
 */
public interface TrialRepository extends JpaRepository<Trial, Long> {
}
