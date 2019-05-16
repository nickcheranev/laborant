package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Cheranev N.
 * created on 14.05.2019.
 */
@Data
@Embeddable
public class ObjectTrialTypeId implements Serializable {

    public Long objectId;
    public Long trialTypeId;

    public ObjectTrialTypeId() {
    }

    public ObjectTrialTypeId(Long objectId, Long trialTypeId) {
        this.objectId = objectId;
        this.trialTypeId = trialTypeId;
    }
}
