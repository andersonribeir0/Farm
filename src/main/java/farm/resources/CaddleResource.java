package farm.resources;

import farm.domain.Caddle;
import farm.domain.MilkProduction;
import farm.dto.CaddleDTO;
import farm.dto.MilkProductionDTO;
import farm.resources.baseResponse.BaseResponse;
import farm.service.CaddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="caddle")
public class CaddleResource {

    private CaddleService caddleService;

    @Autowired
    public CaddleResource(CaddleService caddleService) {
        this.caddleService = caddleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<BaseResponse> findAll() {
        List<Caddle> caddles = this.caddleService.findAll();
        return ResponseEntity.ok().body(new BaseResponse(caddles, true));
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<BaseResponse> findById(@PathVariable String id) {
        Caddle caddle =  this.caddleService.findById(id);
        if (caddle != null) {
            return ResponseEntity.ok().body(new BaseResponse(caddle, true));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> add(@RequestBody CaddleDTO caddle) {
        Caddle obj = caddleService.insert(caddle);
        if(obj == null){
            return ResponseEntity.badRequest().body(new BaseResponse(obj, false));
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(new BaseResponse(obj, true));
    }

    @RequestMapping(value="/{id}" ,method=RequestMethod.PUT)
    public ResponseEntity edit(@RequestBody Caddle caddle, @PathVariable String id) {
        Caddle obj = caddle;
        obj.setId(id);
        caddleService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}/milkProductions", method=RequestMethod.PUT)
    public ResponseEntity addMilkProductions(@RequestBody MilkProductionDTO milkProduction, @PathVariable String id) {
        Caddle caddle = caddleService.findById(id);
        MilkProduction newMilkProduction = new MilkProduction(milkProduction.getDate(), milkProduction.getQuantity());
        caddle.addMilkProduction(newMilkProduction);
        caddleService.update(caddle);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}/milkProductions", method = RequestMethod.GET)
    public ResponseEntity findMilkProductionsByCaddleId(@PathVariable String id){
        Caddle caddle = caddleService.findById(id);
        List<MilkProduction> milkProduction = caddle.getMilkProductions();
        if (milkProduction.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(new BaseResponse(milkProduction, true));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCaddle(@PathVariable String id) {
        boolean deleted = caddleService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}


