package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Cheranev N.
 * created on 14.05.2019.
 */
@Data
@Embeddable
public class ObjectTraitId implements Serializable {

    public ObjectTrialTypeId objectTrialTypeId;
    public Long traitId;

    public ObjectTraitId(ObjectTrialTypeId objectTrialTypeId, Long traitId) {
        this.objectTrialTypeId = objectTrialTypeId;
        this.traitId = traitId;
    }

    public ObjectTraitId(Long objectId, Long trialTypeId, Long traitId) {
        this(new ObjectTrialTypeId(objectId, trialTypeId), traitId);
    }
}
