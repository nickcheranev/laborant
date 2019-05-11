package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ru.company.laborant.jpa.domain.Customer;
import ru.company.laborant.jpa.domain.Folder;
import ru.company.laborant.jpa.domain.StatType;
import ru.company.laborant.jpa.domain.Trait;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TraitRepositoryTest {

    @Autowired
    private TraitRepository repository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private StatTypeRepository statTypeRepository;

    @Test
    public void findById() {
        Folder folder = new Folder();
        folderRepository.save(folder);

        StatType statType = new StatType();
        statTypeRepository.save(statType);

        Trait added = new Trait();
        added.setName("name");
        added.setFolder(folder);
        added.setStatType(statType);
        Trait saved = repository.save(added);
        Assert.isTrue(saved.getId().equals(1L));
        Optional<Trait> trait = repository.findById(1L);
        System.out.println(trait);
        Assert.isTrue(trait.isPresent());
    }
}