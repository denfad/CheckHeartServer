package ru.denfad.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Timer;
import java.util.TimerTask;

@Service
@Transactional
public class MedicalDataDeleter {

    private final MedicalDataService medicalDataService;

    private final Integer delay = 2000;
    @Autowired
    public MedicalDataDeleter(MedicalDataService medicalDataService) {
        this.medicalDataService = medicalDataService;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                medicalDataService.deleteDates();
            }
        }, delay, delay);
    }

}
