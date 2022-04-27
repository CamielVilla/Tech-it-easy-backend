package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.Television;
import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateTelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.service.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("user/tvs")
public class TelevisionDTOController {

    private TelevisionService televisionService;

    @Autowired
    public TelevisionDTOController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping("{id}")
    public ResponseEntity<TelevisionDTO> getTvDto (@PathVariable Long id, CreateTelevisionDTO createTelevisionDTO) {
        final Television television = televisionService.getTvById(id);
        final TelevisionDTO televisionDTO = televisionService.toDTO(television);
        return ResponseEntity.ok(televisionDTO);
    }
}
