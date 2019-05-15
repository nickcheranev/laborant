package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ru.company.laborant.jpa.domain.*;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TraitObjectRepositoryTest {

    @Autowired
    private TraitObjectRepository repository;
    @Autowired
    private ProbeObjectRepository objectRepository;
    @Autowired
    private TraitRepository traitRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private NormativeDocumentRepository normativeDocumentRepository;
    @Autowired
    private TrialTypeRepository trialTypeRepository;

    @Test
    public void findById() {

        ProbeObject probeObject = new ProbeObject();
        objectRepository.save(probeObject);

        Folder folder = new Folder();
        folderRepository.save(folder);

        Trait trait = new Trait();
        traitRepository.save(trait);

        NormativeDocument ndMethod = new NormativeDocument();
        normativeDocumentRepository.save(ndMethod);

        NormativeDocument ndProduct = new NormativeDocument();
        normativeDocumentRepository.save(ndProduct);

        TrialType trialType = new TrialType();
        trialTypeRepository.save(trialType);

        TraitObject added = new TraitObject();
        added.setFolder(folder);
        added.setProbeObject(probeObject);
        added.setNormativeDocumentOnMethod(ndMethod);
        added.setNormativeDocumentOnProduct(ndProduct);
        added.setTrait(trait);
        added.setOrd(1);
        added.setDescription("description");

        TraitObject saved = repository.save(added);
        Assert.isTrue(saved.getId().equals(1L));
        Optional<TraitObject> traitObject = repository.findById(1L);
        System.out.println(traitObject);
        Assert.isTrue(traitObject.isPresent());
    }
}