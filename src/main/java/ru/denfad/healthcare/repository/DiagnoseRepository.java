package ru.denfad.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denfad.healthcare.models.Diagnose;
import ru.denfad.healthcare.models.MedicalData;

import java.util.List;

@Repository
public interface DiagnoseRepository extends JpaRepository<Diagnose,Integer> {

    @Query("select d from Diagnose d where d.user.id = :id")
    List<Diagnose> getDiagnoseByUser(@Param("id") Integer id);

}
