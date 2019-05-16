package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.TrialResult;
import ru.company.laborant.jpa.domain.TrialResultId;

/**
 * @author Cheranev N.
 * created on 17.05.2019.
 */
public interface TrialResultRepository extends JpaRepository<TrialResult, TrialResultId> {
}
