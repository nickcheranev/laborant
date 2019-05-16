package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.ObjectTrait;
import ru.company.laborant.jpa.domain.ObjectTraitId;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface ObjectTraitRepository extends JpaRepository<ObjectTrait, ObjectTraitId> {
    Optional<ObjectTrait> findById(ObjectTraitId id);
}
