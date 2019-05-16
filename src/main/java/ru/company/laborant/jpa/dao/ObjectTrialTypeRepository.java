package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.ObjectTrialType;
import ru.company.laborant.jpa.domain.ObjectTrialTypeId;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface ObjectTrialTypeRepository extends JpaRepository<ObjectTrialType, ObjectTrialTypeId> {
    Optional<ObjectTrialType> findById(ObjectTrialTypeId id);
}
