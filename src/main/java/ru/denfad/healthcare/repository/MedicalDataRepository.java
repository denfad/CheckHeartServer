package ru.denfad.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.denfad.healthcare.models.MedicalData;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface MedicalDataRepository extends JpaRepository<MedicalData,Integer> {

    @Query("select md from MedicalData md where md.user.id = :id")
    List<MedicalData> getMedicalDataByUser(@Param("id") Integer id);

    @Query("select md from MedicalData md where md.user.saveData = false and md.deviations = false")
    List<MedicalData> getMedicalDataForDelete();

    @Modifying
    @Query("delete from MedicalData  md  where  md.user.saveData = false and md.deviations = false")
    List<MedicalData> delete(@Param("calendar") Calendar calendar);
}
