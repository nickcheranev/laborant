package ru.company.laborant.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
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

    public Object(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    @Override
    public String toString () {
        return String.format("Trait[id=%d, name='%s']", id, name);
    }
}