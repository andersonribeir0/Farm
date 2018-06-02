package domain;

import valueObjects.MilkProduction;

import java.util.*;

public class Caddle {

    private final UUID id;
    private final String name;
    private final float weight;
    private final Date birthDate;
    private final String gender;
    private List<Caddle> breedings;
    private List<MilkProduction> milkProduction;


    public Caddle(UUID id, String name, float weight, Date birthDate, String gender, List<MilkProduction> milkProduction) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.birthDate = birthDate;
        this.gender = gender;
        this.breedings = new ArrayList<Caddle>();
        this.milkProduction = new ArrayList<MilkProduction>();
    }

    public int getAge(){
        long ageInMs = new Date().getTime() - this.birthDate.getTime();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(ageInMs);
        int years = c.get(Calendar.YEAR) - 1970;
        int months = c.get(Calendar.MONTH) + 12*years;
        return months;
    }

    public List<Caddle> getBreedings() {
        return breedings;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void addBreeding(Caddle caddle) {
        this.breedings.add(caddle);
    }

    public List<MilkProduction> getMilkProduction() {
        return milkProduction;
    }

    public void addMilkProduction(MilkProduction milkProduction) {
        this.milkProduction.add(milkProduction);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public Date getBirth() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setBreedings(List<Caddle> breedings) {
        this.breedings = breedings;
    }

    public void setMilkProduction(List<MilkProduction> milkProduction) {
        this.milkProduction = milkProduction;
    }
}
