package ru.company.laborant.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name = "trial_type_id", referencedColumnName = "id")
    private TrialType trialType;
    @MapsId("objectId")
    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private ProbeObject probeObject;

//    private Set<Trait> traits = new HashSet<>();
//    @OneToMany(mappedBy = "object", cascade = CascadeType.ALL, orphanRemoval = true)
//    public Set<Trait> getTraits() {
//        return traits;
//    }

    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;
}
