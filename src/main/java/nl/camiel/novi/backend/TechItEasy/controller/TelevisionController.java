package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.models.Television;
import nl.camiel.novi.backend.TechItEasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tvs")
public class TelevisionController {

   // Television lg = new Television(2L, "Smart", "LG", "Lg", 4555.22, 55.2, 34.0, "QLED", "Perfect", true, true, true, true, true, true, 4555, 444);

    private TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTvs() {
        final List<Television> allTvs = televisionRepository.findAll();
        return ResponseEntity.ok(allTvs);
    }

//    @PostMapping
//    public ResponseEntity<Television> addTv(@RequestBody Television television) {
//    television.getName();
//    return ResponseEntity.created(null).build();
//    }

}
