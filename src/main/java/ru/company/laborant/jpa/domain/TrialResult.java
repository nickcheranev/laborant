package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Cheranev N.
 * created on 17.05.2019.
 */
@Entity
@Data
public class TrialResult {

    @EmbeddedId
    private TrialResultId trialResultId;

    private String realValue;
    private Boolean normativeDocumentNotMatch;
    private String dispersion;
}
