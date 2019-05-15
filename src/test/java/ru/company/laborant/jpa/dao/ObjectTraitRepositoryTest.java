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
    private ProbeObjectRepository probeObjectRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private ObjectTraitRepository objectTraitRepository;

    @Test
    // @Commit
    public void findById() {
        Folder folder = new Folder();
        folderRepository.save(folder);

        TrialType tt = new TrialType();
        tt.setName("name");
        tt.setFolder(folder);
        trialTypeRepository.saveAndFlush(tt);

        ProbeObject po = new ProbeObject();
        po.setName("object");
        po.setFolder(folder);
        probeObjectRepository.saveAndFlush(po);

        // 1
        Trait trait1 = new Trait();
        trait1.setName("trait 1");
        trait1.setFolder(folder);
        traitRepository.saveAndFlush(trait1);
        // 2
        Trait trait2 = new Trait();
        trait2.setName("trait 2");
        trait2.setFolder(folder);
        traitRepository.saveAndFlush(trait2);

        ObjectTrait ot1 = new ObjectTrait();
        ObjectTraitId id1 = new ObjectTraitId(po.getId(), tt.getId(), trait1.getId());
        ot1.setId(id1);
        ot1.setProbeObject(po);
        ot1.setTrialType(tt);
       // ot1.getTraits().add(trait1);
        ObjectTrait savedOt1 = objectTraitRepository.saveAndFlush(ot1);

//        Assert.isTrue(savedOt1.isPresent());
//        System.out.println("\n" + savedOtt.get() + "\n");
//        System.out.println("\n" + savedOtt.get().getProbeObject() + "\n");
//        System.out.println("\n" + savedOtt.get().getTrialType() + "\n");



    }

}