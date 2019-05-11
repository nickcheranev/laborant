package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Cheranev N.
 * created on 04.02.2017.
 */
@Entity
@Data
public class Trait {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRAIT")
    @SequenceGenerator(name = "SEQ_TRAIT", sequenceName = "SEQ_TRAIT", allocationSize = 100)
    private Long id;
    private String name;
    private String memo;
    @ManyToOne
    @JoinColumn(name = "statTypeId")
    private StatType statType;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;
}
