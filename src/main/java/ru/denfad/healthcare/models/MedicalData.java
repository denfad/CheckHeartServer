package ru.denfad.healthcare.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Calendar;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "medical_datas")
public class MedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ecg")
    private String ecg;

    @Column(name = "ppg")
    private String ppg;

    @Column(name = "date_time")
    private Calendar dateTime;

    @Column(name = "deviations")
    private Boolean deviations;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id",  foreignKey = @ForeignKey(name = "fk_medical_data_user_id"))
    private User user;


    public MedicalData(Integer id, String ecg, String ppg, Calendar dateTime, Boolean deviations, User user) {
        this.id=id;
        this.ecg=ecg;
        this.ppg=ppg;
        this.dateTime=dateTime;
        this.user=user;
        this.deviations=deviations;
    }

    public MedicalData(String ecg,String ppg, Calendar dateTime, Boolean deviations, User user) {
        this.ecg=ecg;
        this.ppg=ppg;
        this.dateTime=dateTime;
        this.user=user;
        this.deviations=deviations;
    }


    public MedicalData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEcg() {
        return ecg;
    }

    public void setEcg(String ecg) {
        this.ecg = ecg;
    }

    public String getPpg() {
        return ppg;
    }

    public void setPpg(String ppg) {
        this.ppg = ppg;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getDeviations() {
        return deviations;
    }

    public void setDeviations(Boolean deviations) {
        this.deviations = deviations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
