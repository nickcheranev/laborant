package ru.company.laborant.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Template;

/**
 * @author Cheranev N.
 * created on 16.05.2019.
 */
public interface TemplateRepository extends JpaRepository<Template, Long>{
}
