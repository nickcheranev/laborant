package ru.company.laborant.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Заказчики
 *
 * @author Cheranev N.
 * created on 04.02.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER")
    @SequenceGenerator(name = "SEQ_CUSTOMER", sequenceName = "SEQ_CUSTOMER", allocationSize = 100)
    private Long id;

    private String fullName;
    private String address;
    private String phone;
    private String postIndex;

    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;


    public Customer(String fullName, String address, String phone, String postIndex) {

        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.postIndex = postIndex;
    }
    @Override
    public String toString() {
        return String.format("Customer[id=%d, fullName='%s', address='%s', phone='%s', postIndex='%s']", id,
                fullName, address, phone, postIndex);
    }
}
