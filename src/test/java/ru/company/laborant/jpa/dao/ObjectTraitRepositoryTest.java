package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.company.laborant.jpa.domain.*;
import ru.company.laborant.jpa.domain.Object;

/**
 * @author Cheranev N.
 * created on 14.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ObjectTraitRepositoryTest {

    @Autowired
    private TraitRepository traitRepository;
    @Autowired
    private TrialTypeRepository trialTypeRepository;
    @Autowired
    private ObjectRepository objectRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private ObjectTraitRepository objectTraitRepository;
    @Autowired
    private NormativeDocumentRepository normativeDocumentRepository;

    @Test
    // @Commit
    public void findById() {
        Folder folder = new Folder();
        folderRepository.save(folder);

        TrialType trialType = new TrialType();
        trialType.setName("name");
        trialType.setFolder(folder);
        trialTypeRepository.saveAndFlush(trialType);

        Object object = new Object();
        object.setName("object");
        object.setFolder(folder);
        objectRepository.saveAndFlush(object);

        Trait trait = new Trait();
        trait.setName("trait");
        trait.setFolder(folder);
        traitRepository.saveAndFlush(trait);

        NormativeDocument normativeDocumentMethod = new NormativeDocument();
        normativeDocumentMethod.setName("normativeDocumentMethod");
        normativeDocumentMethod.setFolder(folder);
        normativeDocumentRepository.saveAndFlush(normativeDocumentMethod);

        NormativeDocument normativeDocumentProduct = new NormativeDocument();
        normativeDocumentProduct.setName("normativeDocumentProduct");
        normativeDocumentProduct.setFolder(folder);
        normativeDocumentRepository.saveAndFlush(normativeDocumentProduct);

        ObjectTrait objectTrait = new ObjectTrait();
        ObjectTraitId id1 = new ObjectTraitId(object.getId(), trialType.getId(), trait.getId());
        objectTrait.setId(id1);
        objectTrait.setObject(object);
        objectTrait.setTrialType(trialType);
        objectTrait.setTrait(trait);
        objectTrait.setNormativeDocumentMethod(normativeDocumentMethod);
        objectTrait.setNormativeDocumentProduct(normativeDocumentProduct);
        ObjectTrait savedOt1 = objectTraitRepository.saveAndFlush(objectTrait);

        System.out.println("\n" + savedOt1 + "\n");
    }

}