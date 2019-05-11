package ru.company.laborant.jpa.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * @author Cheranev N.
 * created on 04.02.2017.
 */
@Entity
@Data
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FOLDER")
    @SequenceGenerator(name="SEQ_FOLDER", sequenceName="SEQ_FOLDER", allocationSize=100)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parentId")
    @Fetch(FetchMode.JOIN)
    private Folder parent;
}
