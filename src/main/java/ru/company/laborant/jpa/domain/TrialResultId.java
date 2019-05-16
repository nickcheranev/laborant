package ru.company.laborant.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Cheranev N.
 * created on 17.05.2019.
 */
@Data
@NoArgsConstructor
@Embeddable
public class TrialResultId implements Serializable {

    private ObjectTraitId objectTraitId;
    private Long trialId;

    public TrialResultId(ObjectTraitId objectTraitId, Long trialId) {
        this.objectTraitId = objectTraitId;
        this.trialId = trialId;
    }
}
