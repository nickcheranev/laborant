package ru.company.laborant.jpa.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ru.company.laborant.jpa.domain.Customer;
import ru.company.laborant.jpa.domain.Folder;

import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private FolderRepository folderRepository;

    @Test
    public void findById() {
        Folder folder = new Folder();
        folderRepository.save(folder);

        Customer added = new Customer("Иванов И.И.", "г.Березники, ул.Пятилетки 50-21","332-332", "618400");
        added.setFullName("fullname");
        added.setAddress("address");
        added.setPhone("phone");
        added.setPostIndex("postIndex");
        added.setFolder(folder);
        Customer saved = repository.save(added);
        Assert.isTrue(saved.getId().equals(1L));
        Optional<Customer> customer = repository.findById(1L);
        System.out.println(customer);
        Assert.isTrue(customer.isPresent());
    }
}