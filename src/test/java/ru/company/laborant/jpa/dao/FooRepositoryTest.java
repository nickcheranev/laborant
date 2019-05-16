package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import ru.company.laborant.jpa.domain.Bar;
import ru.company.laborant.jpa.domain.Foo;

/**
 * @author Cheranev N.
 * created on 15.05.2019.
 */
//@RunWith(SpringRunner.class)
//@DataJpaTest
public class FooRepositoryTest {

//    @Autowired
//    private FooRepository fooRepository;
//    @Autowired
//    private BarRepository barRepository;
//
//    @Test
//    @Commit
//    public void test() {
//
//        Bar bar1 = new Bar();
//        barRepository.saveAndFlush(bar1);
//        Bar bar2 = new Bar();
//        barRepository.saveAndFlush(bar2);
//
//        Foo foo = new Foo();
//        //bar1.setFoo(foo);
//        //bar1.setFoo(foo);
//        foo.getBars().add(bar1);
//        foo.getBars().add(bar2);
//        fooRepository.saveAndFlush(foo);
//        System.out.println(foo);
//        System.out.println(((Bar)(foo.getBars().toArray()[0])).getFoo());
//
//        Bar bar3 = barRepository.getOne(1);
//        System.out.println(bar3);
//    }
}