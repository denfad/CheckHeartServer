package ru.denfad.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denfad.healthcare.models.MedicalData;
import ru.denfad.healthcare.models.User;
import ru.denfad.healthcare.repository.MedicalDataRepository;
import ru.denfad.healthcare.repository.UserRepository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@Transactional
public class MedicalDataService {

    private final MedicalDataRepository medicalDataRepository;
    private final UserRepository userRepository;
    @Autowired
    public MedicalDataService(MedicalDataRepository medicalDataRepository, UserRepository userRepository) {
        this.medicalDataRepository = medicalDataRepository;
        this.userRepository = userRepository;
    }

    public void addMedicalData(MedicalData medicalData, Integer userId){
        Calendar dateTime = new GregorianCalendar();
        medicalData.setDateTime(dateTime);
        User user = userRepository.getOne(userId);
        user.addMedicalDataSet(medicalData);
        userRepository.save(user);
    }

    public MedicalData getMedicalData(Integer id){
       return medicalDataRepository.getOne(id);
    }

    public void deleteMedicalData(Integer id){
        medicalDataRepository.deleteById(id);
    }
    public List<MedicalData> getMedicalDataByUser(Integer id){
        return medicalDataRepository.getMedicalDataByUser(id);
    }

    public List<MedicalData> getMedicalDataForDelete(){
        return medicalDataRepository.getMedicalDataForDelete();
    }

    public void deleteDates(){
        Calendar c = new GregorianCalendar();
        c.add(Calendar.SECOND, -1);
        medicalDataRepository.delete(c);
    }

}
