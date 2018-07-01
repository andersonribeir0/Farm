package farm.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class Caddle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private Integer number;
    private float weight;
    private Date birthDate;
    private String gender;
    private List<MilkProduction> milkProductions = new ArrayList<>();

    public Caddle(String id, String name, float weight, Date birthDate, String gender, Integer number, List<MilkProduction> milkProductions) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.birthDate = birthDate;
        this.gender = gender;
        this.number = number;
        this.milkProductions = milkProductions;
    }

    public Caddle() {
    }

    public void addMilkProduction(MilkProduction milkProduction) {
        this.milkProductions.add(milkProduction);
    }

    public List<MilkProduction> getMilkProductions() {
        return milkProductions;
    }

    public void setMilkProductions(List<MilkProduction> milkProductions) {
        this.milkProductions = milkProductions;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Caddle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                '}';
    }
}
