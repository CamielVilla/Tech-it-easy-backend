package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.Television;
import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateTelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.service.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<TelevisionDTO>> getTvs(){
    final List<TelevisionDTO> tvList = televisionService.getAllTvs();
    return ResponseEntity.ok(tvList);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<TelevisionDTO> getTv(@PathVariable Long id) {
        final TelevisionDTO televisionDTO = televisionService.getTvById(id);
        return ResponseEntity.ok(televisionDTO);
    }

    @PostMapping
    public ResponseEntity<Television> addTv(@Valid @RequestBody CreateTelevisionDTO createTelevisionDTO) {
            final Television television = televisionService.addTv(createTelevisionDTO);
            return ResponseEntity.ok(television);


        }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTv(@PathVariable Long id) {
    televisionService.deleteTv(id);
    return ResponseEntity.ok("Tv with id " + id + " deleted");
    }



    @PutMapping("{id}")
    public ResponseEntity<Television> updateTv(@Valid @RequestBody CreateTelevisionDTO televisionDTO, @PathVariable Long id) {
    Television television = televisionService.updateTv(televisionDTO, id);
    return ResponseEntity.ok(television);
    };



}
