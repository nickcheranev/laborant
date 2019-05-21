package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Сотрудники
 *
 * @author Cheranev N.
 * created on 04.02.2017.
 */
@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
    @SequenceGenerator(name = "SEQ_EMPLOYEE", sequenceName = "SEQ_EMPLOYEE", allocationSize = 100)
    private Long id;
    private String fullName;
    private String address;
    private String phone;
    private String postIndex;
    private String description;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;
}
