package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Cheranev N.
 * created on 15.05.2019.
 */
@Entity
@Data
public class Bar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Foo foo;
}
