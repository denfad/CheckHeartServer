package ru.denfad.healthcare.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;


//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "sec")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "height")
    private Integer height;

    @Column(name = "save_data")
    private Boolean saveData;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<MedicalData> medicalDataSet;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Diagnose> diagnoseSet;

    public User(String login, String password, String name, Integer age, Integer weight,  Integer height, Boolean saveData, Set<MedicalData> medicalData) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.saveData=saveData;
        this.medicalDataSet = medicalData;
    }

    public User(Integer id, String login, String password, String name, Integer age, Integer weight, Integer height, Boolean saveData, Set<MedicalData> medicalData) {
        this.id=id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.saveData=saveData;
        this.medicalDataSet = medicalData;
    }
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getSaveData() {
        return saveData;
    }

    public void setSaveData(Boolean saveData) {
        this.saveData = saveData;
    }

    public Set<MedicalData> getMedicalDataSet() {
        return medicalDataSet;
    }

    public void setMedicalDataSet(Set<MedicalData> medicalData) {
        this.medicalDataSet = medicalData;
    }

    public void addMedicalDataSet(MedicalData medicalData){
        medicalData.setUser(this);
        this.medicalDataSet.add(medicalData);
    }

    public Set<Diagnose> getDiagnoseSet() {
        return diagnoseSet;
    }

    public void setDiagnoseSet(Set<Diagnose> diagnoseSet) {
        this.diagnoseSet = diagnoseSet;
    }

    public void addDiagnoseSet(Diagnose diagnose){
        diagnose.setUser(this);
        this.diagnoseSet.add(diagnose);
    }
}
