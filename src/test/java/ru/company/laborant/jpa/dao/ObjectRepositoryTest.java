package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ru.company.laborant.jpa.domain.Folder;
import ru.company.laborant.jpa.domain.Object;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ObjectRepositoryTest {

    @Autowired
    private ObjectRepository repository;
    @Autowired
    private FolderRepository folderRepository;

    @Test
    public void findById() {
        Folder folder = new Folder();
        folderRepository.save(folder);

        Object added = new Object();
        added.setName("name");
        added.setFolder(folder);
        Object saved = repository.save(added);
        Assert.isTrue(saved.getId().equals(1L));
        Optional<Object> probeObject = repository.findById(1L);
        System.out.println(probeObject);
        Assert.isTrue(probeObject.isPresent());
    }
}