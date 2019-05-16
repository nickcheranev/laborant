package ru.company.laborant.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Cheranev N.
 * created on 14.05.2019.
 */
@Data
@NoArgsConstructor
@Embeddable
public class ObjectTraitId implements Serializable {

    private ObjectTrialTypeId objectTrialTypeId;
    private Long traitId;

    public ObjectTraitId(ObjectTrialTypeId objectTrialTypeId, Long traitId) {
        this.objectTrialTypeId = objectTrialTypeId;
        this.traitId = traitId;
    }

    public ObjectTraitId(Long objectId, Long trialTypeId, Long traitId) {
        this(new ObjectTrialTypeId(objectId, trialTypeId), traitId);
    }
}
