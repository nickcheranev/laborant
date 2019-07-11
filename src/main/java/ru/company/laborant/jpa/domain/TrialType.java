package ru.company.laborant.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Тип испытания
 *
 * @author Cheranev N.
 * created on 09.05.2019.
 */
@Entity
@Data
@NoArgsConstructor
public class TrialType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRIAL_TYPE")
    @SequenceGenerator(name = "SEQ_TRIAL_TYPE", sequenceName = "SEQ_TRIAL_TYPE", allocationSize = 100)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;

    public TrialType(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    @Override
    public String toString () {
        return String.format("TrialType[id=%d, name='%s', description='%s']", id, name, description);
    }
}
