package farm.service;

import farm.domain.Caddle;
import farm.domain.MilkProduction;
import farm.event.EventDispatcher;
import farm.event.MilkProductionCreatedEvent;
import farm.repository.CaddleRepository;
import farm.resources.exceptions.ObjectNotFoundException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class CaddleService {

    private CaddleRepository repository;
    private EventDispatcher eventDispatcher;

    @Autowired
    public CaddleService(
            CaddleRepository repository,
            EventDispatcher eventDispatcher
    ) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    public List<Caddle> findAll() {
        return this.repository.findAll();
    }

    public Caddle insert(final Caddle caddle) {
        if (repository.findByNumber(caddle.getNumber()).isEmpty()) {
            Caddle targetCaddle = new Caddle(
                    caddle.getName(),
                    caddle.getNumber(),
                    caddle.getWeight(),
                    caddle.getBirthDate(),
                    caddle.getGender()
            );
            return this.repository.insert(targetCaddle);
        } else {
            log.warning("Não é possível inserir " + caddle.toString() +", pois seu número já existe.");
            return null;
        }
    }

    public Caddle update(final Caddle caddle) {
        Caddle obj = findById(caddle.getId());
        updateData(caddle, obj);
        repository.save(caddle);
        return caddle;
    }

    public Caddle findById(String id) {
        final Optional<Caddle> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public boolean deleteById(String id) {
        Caddle caddle = findById(id);
        if(caddle == null) {
            return false;
        }
        repository.delete(caddle);
        return true;
    }

    public void addMilkProduction(String id, MilkProduction milkProduction) {
        Caddle caddle = this.findById(id);
        MilkProduction newMilkProduction = new MilkProduction(milkProduction.getDate(), milkProduction.getQuantity());
        caddle = caddle.addMilkProduction(newMilkProduction);
        this.update(caddle);
        eventDispatcher.send(
                new MilkProductionCreatedEvent(
                        id,
                        milkProduction.getDate(),
                        milkProduction.getQuantity()
                )
        );
    }

    private void updateData(Caddle newObj, Caddle obj) {
        newObj.setId(obj.getId());
        if(newObj.getMilkProductions().isEmpty()) {
            List<MilkProduction> milkProductions = new ArrayList<>(obj.getMilkProductions());
            newObj.addMilkProductions(milkProductions);
        }
    }
}
