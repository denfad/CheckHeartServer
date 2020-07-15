package ru.denfad.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denfad.healthcare.models.Diagnose;
import ru.denfad.healthcare.models.User;
import ru.denfad.healthcare.repository.DiagnoseRepository;
import ru.denfad.healthcare.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class DiagnoseService {


    private final DiagnoseRepository diagnoseRepository;
    private final UserRepository userRepository;

    @Autowired
    public DiagnoseService(DiagnoseRepository diagnoseRepository, UserRepository userRepository) {
        this.diagnoseRepository = diagnoseRepository;
        this.userRepository = userRepository;
    }

    public void saveDiagnose(Diagnose diagnose, Integer userId){
        User user = userRepository.getOne(userId);
        user.addDiagnoseSet(diagnose);
        userRepository.save(user);

    }

    public List<Diagnose> getDiagnoseByUserId(Integer userId){
        return diagnoseRepository.getDiagnoseByUser(userId);
    }
}
