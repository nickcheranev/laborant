package ru.company.laborant.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Характеристика
 *
 * @author Cheranev N.
 * created on 04.02.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class Trait {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRAIT")
    @SequenceGenerator(name = "SEQ_TRAIT", sequenceName = "SEQ_TRAIT", allocationSize = 100)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "statTypeId")
    private StatType statType;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;

    public Trait(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    @Override
    public String toString () {
        return String.format("Trait[id=%d, name='%s', description='%s']", id, name, description);
    }
}
