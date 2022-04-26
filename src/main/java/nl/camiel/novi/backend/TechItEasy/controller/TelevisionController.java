package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.CreateTelevision;
import nl.camiel.novi.backend.TechItEasy.domain.Television;
import nl.camiel.novi.backend.TechItEasy.domain.UpdateTelevision;
import nl.camiel.novi.backend.TechItEasy.service.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tvs")
public class TelevisionController {



private TelevisionService televisionService;

    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<Television>> getTvs(){
    final List<Television> tvList = televisionService.getAllTvs();
    return ResponseEntity.ok(tvList);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Television> getTv(@PathVariable Long id) {
       final Television television = televisionService.getTvById(id);
        return ResponseEntity.ok(television);
    }

    @PostMapping
    public ResponseEntity<Television> addTv(@RequestBody  CreateTelevision createTelevision){
        final Television television = televisionService.addTv(createTelevision);
        return ResponseEntity.ok(television);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTv(@PathVariable Long id) {
    televisionService.deleteTv(id);
    return ResponseEntity.ok("Tv with id " + id + " deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateTv(@RequestBody UpdateTelevision updateTelevision, @PathVariable Long id) {
    final Television television = televisionService.updateTvPriceAndSold(updateTelevision, id);
    return ResponseEntity.ok("Television updated");
    };



}
