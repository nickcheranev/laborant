package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Cheranev N.
 * created on 11.05.2019.
 */
@Entity
@Data
public class TraitObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRAIT_OBJECT")
    @SequenceGenerator(name = "SEQ_TRAIT_OBJECT", sequenceName = "SEQ_TRAIT_OBJECT", allocationSize = 100)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "objectId")
    private ProbeObject probeObject;
    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;
    @ManyToOne
    @JoinColumn(name = "traitId")
    private Trait trait;
    @ManyToOne
    @JoinColumn(name = "normativeDocumentOnMethodId")
    private NormativeDocument normativeDocumentOnMethod;
    @ManyToOne
    @JoinColumn(name = "normativeDocumentOnProductId")
    private NormativeDocument normativeDocumentOnProduct;
    private String NormativeDocumentValue;
    @ManyToOne
    @JoinColumn(name = "trialTypeId")
    private TrialType trialType;
    private Integer ord;
    private String description;


}
