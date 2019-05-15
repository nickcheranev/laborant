package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.company.laborant.jpa.domain.*;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 14.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ObjectTrialTypeRepositoryTest {

    @Autowired
    private TrialTypeRepository trialTypeRepository;
    @Autowired
    private ProbeObjectRepository probeObjectRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private ObjectTrialTypeRepository objectTrialTypeRepository;

    @Test
    public void addRecord() {
        ObjectTrialType ott = new ObjectTrialType();
        ObjectTrialTypeId id = new ObjectTrialTypeId(1L, 2L /*po.getId(), tt.getId()*/);
        ott.setId(id);
        objectTrialTypeRepository.saveAndFlush(ott);
    }

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

        ObjectTrialType ott = new ObjectTrialType();
        ObjectTrialTypeId id = new ObjectTrialTypeId(po.getId(), tt.getId());
        ott.setId(id);
        ott.setMethod("method");
        ott.setFolder(folder);
        ott.setProbeObject(po);
        ott.setTrialType(tt);
        objectTrialTypeRepository.saveAndFlush(ott);

        Optional<ObjectTrialType> savedOtt = objectTrialTypeRepository.findById(id);

        Assert.isTrue(savedOtt.isPresent());
        System.out.println("\n" + savedOtt.get() + "\n");
        System.out.println("\n" + savedOtt.get().getProbeObject() + "\n");
        System.out.println("\n" + savedOtt.get().getTrialType() + "\n");



    }

}