package farm.service;

import farm.domain.Caddle;
import farm.domain.MilkProduction;

import java.util.List;

public interface CaddleService {
    List<Caddle> findAll();
    Caddle insert(final Caddle caddle);
    Caddle update(final Caddle caddle);
    Caddle findById(String id);
    boolean deleteById(String id);
    void addMilkProduction(String id, MilkProduction milkProduction);
}
