package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheranev N.
 * created on 15.05.2019.
 */
@Entity
@Data
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "foo", fetch = FetchType.EAGER)
    private Set<Bar> bars = new HashSet<>();

}
