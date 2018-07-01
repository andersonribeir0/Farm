package farm.service;

import farm.domain.Caddle;
import farm.dto.CaddleDTO;
import farm.repository.CaddleRepository;
import farm.resources.exceptions.ObjectNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CaddleService {

    private CaddleRepository repository;
    private final static Logger LOGGER = Logger.getLogger(CaddleService.class.getName());
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
            caddle.setWeight(caddleDTO.getWeight());
            return this.repository.insert(caddle);
        } else {
            LOGGER.warning("Não é possível inserir " + caddleDTO.toString() +", pois seu número já existe.");
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


    private void updateData(Caddle newObj, Caddle obj) {
        newObj.setId(obj.getId());
        if(newObj.getMilkProductions().isEmpty()) {
            newObj.setMilkProductions(obj.getMilkProductions());
        }
    }
}
