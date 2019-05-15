package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Folder;
import ru.company.laborant.jpa.domain.ProbeObject;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
public interface ProbeObjectRepository extends JpaRepository<ProbeObject, Long> {
    Optional<ProbeObject> findById(Long id);
}
