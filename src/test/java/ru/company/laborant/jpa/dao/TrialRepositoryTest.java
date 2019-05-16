package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ru.company.laborant.jpa.domain.Trial;

/**
 * @author Cheranev N.
 * created on 17.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TrialRepositoryTest {

    @Autowired
    private TrialRepository trialRepository;

    @Test
    @Commit
    public void add() {
        Trial trial = new Trial();
        Trial trial1 = trialRepository.saveAndFlush(trial);
        Assert.notNull(trial1);
        Trial trial2 = trialRepository.getOne(trial1.getId());
        Assert.notNull(trial2);
    }
}