package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Cheranev N.
 * created on 16.05.2019.
 */
@Entity
@Data
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_TEMPLATE", sequenceName = "SEQ_TEMPLATE")
    private Long id;
    private String description;
    private String filePath;
    @ManyToOne
    private Folder folder;
}
