package ru.company.laborant.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Cheranev N.
 * created on 11.05.2019.
 */
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ObjectTrialType implements Serializable {

    @MapsId("trialTypeId")
    @ManyToOne
    @JoinColumn(name = "trial_type_id", referencedColumnName = "id")
    private TrialType trialType;
    @MapsId("objectId")
    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private Object probeObject;
    @EmbeddedId
    private ObjectTrialTypeId id;
    private String method;
    private String description;
    private Integer ord;

    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;
}
