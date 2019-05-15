package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author Cheranev N.
 * created on 14.05.2019.
 */
@Data
@Embeddable
public class ObjectTrialTypeId implements Serializable {

    @Column(name = "object_id")
    public Long objectId;
    @Column(name = "trial_type_id")
    public Long trialTypeId;

    public ObjectTrialTypeId() {}
    public ObjectTrialTypeId(Long objectId, Long trialTypeId) {
        this.objectId = objectId;
        this.trialTypeId = trialTypeId;
    }
}
