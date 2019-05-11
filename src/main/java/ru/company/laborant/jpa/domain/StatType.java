package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Cheranev N.
 * created on 09.05.2019.
 */
@Entity
@Data
public class StatType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STAT_TYPE")
    @SequenceGenerator(name = "SEQ_STAT_TYPE", sequenceName = "SEQ_STAT_TYPE", allocationSize = 100)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;
}
