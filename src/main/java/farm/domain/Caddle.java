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
    private List<MilkProduction> milkProductions = new ArrayList<>();

    public Caddle() {
        this(null, null, 0, null, null, null);
    }

    public Caddle(String name, Integer number, float weight, Date birthDate, String gender, List<MilkProduction> milkProductions) {
        this.name = name;
        this.number = number;
        this.weight = weight;
        this.birthDate = birthDate;
        this.gender = gender;
        this.milkProductions = milkProductions;
    }

    public void addMilkProduction(final MilkProduction milkProduction) {
        if(this.milkProductions == null) {
            this.milkProductions = new ArrayList<>();
        }
        this.milkProductions.add(milkProduction);
    }
}
