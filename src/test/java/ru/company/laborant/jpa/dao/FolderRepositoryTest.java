package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ru.company.laborant.jpa.domain.Folder;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class FolderRepositoryTest {

    @Autowired
    private FolderRepository repository;

    @Test
    public void findById() {
        Folder parent = new Folder();
        repository.save(parent);

        Folder folder = new Folder();
        folder.setParent(parent);
        Folder saved = repository.save(folder);
        Assert.isTrue(saved.getId().equals(2L));
        Assert.isTrue(repository.findById(2L).get().getId().equals(2L));
    }
}