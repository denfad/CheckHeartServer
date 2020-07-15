package ru.denfad.healthcare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.denfad.healthcare.models.MedicalData;
import ru.denfad.healthcare.services.MedicalDataService;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@RestController
@RequestMapping(path = "/medicaldata")
public class MedicalDataController {

    private final MedicalDataService medicalDataService;

    @Autowired
    public MedicalDataController(MedicalDataService medicalDataService) {
        this.medicalDataService = medicalDataService;
    }

    @PutMapping(path = "/{id}",consumes = "application/json")
    public void addMedicalData(@PathVariable(name = "id") Integer userId, @RequestBody MedicalData medicalData){
        medicalDataService.addMedicalData(medicalData,userId);
    }

    @GetMapping(path = "/{id}",produces = "application/json")
    public MedicalData getMedicalData(@PathVariable(name = "id") Integer id){
        return medicalDataService.getMedicalData(id);
    }

    @GetMapping(path = "/user/{id}",produces = "application/json")
    public List<MedicalData> getMedicalDataByUser(@PathVariable(name = "id") Integer id){
        return medicalDataService.getMedicalDataByUser(id);
    }

}
