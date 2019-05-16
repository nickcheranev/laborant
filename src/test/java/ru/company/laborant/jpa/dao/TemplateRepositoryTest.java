package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ru.company.laborant.jpa.domain.Template;

import static org.junit.Assert.*;

/**
 * @author Cheranev N.
 * created on 16.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TemplateRepositoryTest {

    @Autowired
    private TemplateRepository templateRepository;
    @Test
    public void add() {
        Template template = new Template();
        Template template1 = templateRepository.saveAndFlush(template);
        Assert.notNull(template1);
        Template template2 = templateRepository.getOne(template1.getId());
        Assert.notNull(template2);
    }

}