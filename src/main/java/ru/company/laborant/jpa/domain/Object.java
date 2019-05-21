package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Объекты
 *
 * @author Cheranev N.
 * created on 11.05.2019.
 */
@Entity
@Data
@Table(name = "OBJECT")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OBJECT")
    @SequenceGenerator(name = "SEQ_OBJECT", sequenceName = "SEQ_OBJECT", allocationSize = 100)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;
    private String description;
}
