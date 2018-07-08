package farm.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
public class Caddle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private final String name;
    private final Integer number;
    private final float weight;
    private final Date birthDate;
    private final String gender;
    private final List<MilkProduction> milkProductions;

    public Caddle() {
        this(null, null, 0, 0L, null, null, null);
    }

    public Caddle(String id, String name, Integer number, float weight, Date birthDate, String gender, List<MilkProduction> milkProductions) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.weight = weight;
        this.birthDate = birthDate;
        this.gender = gender;
        this.milkProductions = milkProductions;
    }

    public Caddle(String name, Integer number, float weight, Date birthDate, String gender) {
        this.name = name;
        this.number = number;
        this.weight = weight;
        this.birthDate = birthDate;
        this.gender = gender;
        this.milkProductions = new ArrayList<>();
    }

    public Caddle addMilkProduction(final MilkProduction milkProduction) {
        List<MilkProduction> milkProductions = new ArrayList<>(this.getMilkProductions());
        milkProductions.add(milkProduction);

        Caddle newCaddle = new Caddle(
            this.getId(),
            this.getName(),
            this.getNumber(),
            this.getWeight(),
            this.getBirthDate(),
            this.getGender(),
            milkProductions
        );

        return newCaddle;
    }

    public Caddle addMilkProductions(final List<MilkProduction> milkProduction) {
        List<MilkProduction> milkProductions = new ArrayList<>(this.getMilkProductions());
        milkProductions.addAll(milkProduction);

        Caddle newCaddle = new Caddle(
                this.getId(),
                this.getName(),
                this.getNumber(),
                this.getWeight(),
                this.getBirthDate(),
                this.getGender(),
                milkProductions
        );

        return newCaddle;
    }
}
