package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Cheranev N.
 * created on 04.02.2017.
 */
@Entity
@Data
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
}
