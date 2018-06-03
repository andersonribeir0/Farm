package farm.dto;

import farm.domain.Caddle;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class CaddleDTO implements Serializable {

    @NotNull
    private String name;
    @NotNull
    private Integer number;
    @NotNull
    private String gender;
    @NotNull
    private Date birthDate;
    @NotNull
    private float weight;

    public CaddleDTO() {
    }

    public CaddleDTO(Caddle caddle) {
        this.name = caddle.getName();
        this.number = caddle.getNumber();
        this.gender = caddle.getGender();
        this.birthDate = caddle.getBirthDate();
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "CaddleDTO{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
