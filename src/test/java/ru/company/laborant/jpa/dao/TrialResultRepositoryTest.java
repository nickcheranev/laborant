package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import ru.company.laborant.jpa.domain.Object;
import ru.company.laborant.jpa.domain.ObjectTraitId;
import ru.company.laborant.jpa.domain.TrialResult;
import ru.company.laborant.jpa.domain.TrialResultId;

import static org.junit.Assert.*;

/**
 * @author Cheranev N.
 * created on 17.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TrialResultRepositoryTest {

    @Autowired
    private TrialResultRepository trialResultRepository;
    @Autowired
    private ObjectRepository objectRepository;

    @Test
    @Commit
    public void getOne() {

        ru.company.laborant.jpa.domain.Object object = new Object();

        TrialResult trialResult = new TrialResult();
        TrialResultId trialResultId = new TrialResultId();
        ObjectTraitId objectTraitId = new ObjectTraitId();
        trialResultId.setObjectTraitId(objectTraitId);
        trialResult.setTrialResultId(trialResultId);
        trialResultRepository.saveAndFlush(trialResult);
    }
}