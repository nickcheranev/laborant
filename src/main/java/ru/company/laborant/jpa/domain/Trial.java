package ru.company.laborant.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Cheranev N.
 * created on 16.05.2019.
 */
@Entity
@Data
public class Trial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_NAME", sequenceName = "SEQ_TRIAL")
    private Long id;

    @ManyToOne
    private Object object;
    @ManyToOne
    private TrialType trialType;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Template template;

    private String method;
    private String protocolNumber;
   // @Temporal(TemporalType.DATE)
    private LocalDate protocolDate;
   // @Temporal(TemporalType.DATE)
    private LocalDate startDate;
   // @Temporal(TemporalType.DATE)
    private LocalDate finDate;
    private String reason;
    private String sampleSelectTimeAndLocation;
    private String sampleDeliveryCondition;
    private LocalDate sampleDeliveryDate;
    private String sampleSelectExecutor;
    private String sampleNumber;
   // @Temporal(TemporalType.DATE)
    private LocalDate sampleOutDate;
    private String description;
    private String dateAndActNumber;
    private Integer options; // битовые поля, признаки
    private Integer notMatchNumber;
}
