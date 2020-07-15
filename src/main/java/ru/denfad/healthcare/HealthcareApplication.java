package ru.denfad.healthcare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.denfad.healthcare.repository.MedicalDataRepository;
import ru.denfad.healthcare.services.MedicalDataService;

import java.util.Timer;
import java.util.TimerTask;


@SpringBootApplication
public class HealthcareApplication {


    public static void main(String[] args) {
        SpringApplication.run(HealthcareApplication.class, args);
    }

}
