package farm.service;

import commands.Command;
import commands.ServerCommand;
import farm.domain.Caddle;
import farm.dto.CaddleDTO;
import farm.repository.CaddleRepository;
import farm.resources.exceptions.ObjectNotFoundException;
import notifications.DomainNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaddleService extends Command {

    private CaddleRepository repository;

    @Autowired
    public CaddleService(CaddleRepository repository) {
        this.repository = repository;
    }

    public List<Caddle> findAll() {
        return this.repository.findAll();
    }

    public Caddle insert(CaddleDTO caddleDTO) {
        if (repository.findByNumber(caddleDTO.getNumber()).isEmpty()) {
            Caddle caddle = new Caddle();
            caddle.setName(caddleDTO.getName());
            caddle.setNumber(caddleDTO.getNumber());
            caddle.setBirthDate(caddleDTO.getBirthDate());
            caddle.setGender(caddleDTO.getGender());
            return this.repository.insert(caddle);
        } else {
            this.addNotification(new DomainNotification("CaddleService-Insert", "Já existe um animal com número "+caddleDTO.getNumber().toString()+"."));
            return null;
        }
    }

    public Caddle update(Caddle caddle) {
        Caddle obj = findById(caddle.getId());
        updateData(caddle, obj);
        repository.save(caddle);
        return caddle;
    }

    public Caddle findById(String id) {
        Optional<Caddle> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }



    private void updateData(Caddle newObj, Caddle obj) {
        newObj.setName(obj.getName());
        newObj.setNumber(obj.getNumber());
        newObj.setBirthDate(obj.getBirthDate());
        newObj.setGender(obj.getGender());
        newObj.setMilkProductions(obj.getMilkProductions());
        newObj.setWeight(obj.getWeight());
    }
}
