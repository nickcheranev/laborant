package ru.company.laborant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.company.laborant.jpa.dao.ObjectTrialTypeRepository;
import ru.company.laborant.jpa.dao.ProbeObjectRepository;
import ru.company.laborant.jpa.dao.TrialTypeRepository;
import ru.company.laborant.jpa.domain.ObjectTrialType;
import ru.company.laborant.jpa.domain.ObjectTrialTypeId;
import ru.company.laborant.jpa.domain.ProbeObject;
import ru.company.laborant.jpa.domain.TrialType;

/**
 * @author Cheranev N.
 * created on 14.05.2019.
 */
@RestController
public class WebController {

    @Autowired
    private TrialTypeRepository trialTypeRepository;
    @Autowired
    private ProbeObjectRepository probeObjectRepository;
    @Autowired
    private ObjectTrialTypeRepository objectTrialTypeRepository;

    @GetMapping("/add")
    public ObjectTrialType addObjectTrialType() {
        TrialType trialType = new TrialType();
        trialType.setName("trial type");
        trialTypeRepository.saveAndFlush(trialType);
        ProbeObject probeObject = new ProbeObject();
        probeObjectRepository.saveAndFlush(probeObject);
        ObjectTrialType objectTrialType = new ObjectTrialType();
        ObjectTrialTypeId objectTrialTypeId = new ObjectTrialTypeId();
        objectTrialTypeId.setObjectId(probeObject.getId());
        objectTrialTypeId.setTrialTypeId(trialType.getId());
        objectTrialType.setId(objectTrialTypeId);
        objectTrialType.setProbeObject(probeObject);
        objectTrialType.setTrialType(trialType);
        return objectTrialTypeRepository.saveAndFlush(objectTrialType);
    }

    @GetMapping("/getOTT")
    public ObjectTrialType getObjectTrialType(@RequestParam Long trialTypeId, @RequestParam Long objectId) {
        ObjectTrialTypeId id = new ObjectTrialTypeId();
        id.setTrialTypeId(trialTypeId);
        id.setObjectId(objectId);
        return objectTrialTypeRepository.getOne(id);
    }
}
