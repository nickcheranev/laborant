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
public class ObjectTrait implements Serializable {

    @EmbeddedId
    private ObjectTraitId id;

    @MapsId("trialTypeId")
    @ManyToOne
    // @JoinColumn(name = "trial_type_id", referencedColumnName = "id")
    private TrialType trialType;

    @MapsId("objectId")
    @ManyToOne
    // @JoinColumn(name = "object_id", referencedColumnName = "id")
    private Object object;

    @MapsId("traitId")
    @ManyToOne
    // @JoinColumn(name = "trait_id", referencedColumnName = "id")
    private Trait trait;

    @ManyToOne
    private NormativeDocument normativeDocumentProduct;

    @ManyToOne
    private NormativeDocument normativeDocumentMethod;

    @ManyToOne
   // @JoinColumn(name = "folderId")
    private Folder folder;
}
