package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.entity.CiModule;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Remote;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;
import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateTelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.WallBracket;
import nl.camiel.novi.backend.TechItEasy.service.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tvs")
public class TelevisionController {

private final TelevisionService televisionService;

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
    public ResponseEntity<Television> updateTv(@Valid @RequestBody CreateTelevisionDTO createTelevisionDTO, @PathVariable Long id) {
    Television television = televisionService.updateTv(createTelevisionDTO, id);
    return ResponseEntity.ok(television);
    };

    @PutMapping("{id}/remote")
    public ResponseEntity<String> addRemoteToTv (@RequestBody Remote remote, @PathVariable Long id) {
        televisionService.addRemoteToTelevision(id, remote.getId());
        return ResponseEntity.ok("remote added");
    }

    @PutMapping("{id}/cimodule")
    public ResponseEntity<TelevisionDTO> addCiModuleToTv (@RequestBody CiModule ciModule, @PathVariable Long id){
        televisionService.addCiModuleToTelevision(id, ciModule.getId());
        return ResponseEntity.ok(televisionService.getTvById(id));
    }

    @PutMapping("{id}/wallbracket")
    public ResponseEntity<TelevisionDTO> addWallBracketToTelevision(@RequestBody WallBracket wallBracket, @PathVariable Long id){
        televisionService.addWallBracketToTelevision(id, wallBracket.getId());
        return ResponseEntity.ok(televisionService.getTvById(id));
    }

    @GetMapping("{id}/wallbrackets")
    public ResponseEntity<Set<WallBracket>> getAllWallBracketsFromTelevisionById (@PathVariable Long id){
        return ResponseEntity.ok(televisionService.getAllWallBracketsFromTelevision(id));
    }

}
