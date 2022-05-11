package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.dto.CiModuleDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateCiModuleDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.CiModule;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;
import nl.camiel.novi.backend.TechItEasy.service.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cimodules")
public class CiModuleController {

    private final  CiModuleService ciModuleService;

    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @PostMapping
    public ResponseEntity<CiModule> addCiModule (@RequestBody CreateCiModuleDTO createCiModuleDTO) {
        CiModule ciModule = ciModuleService.addCiModule(createCiModuleDTO);
        return ResponseEntity.ok(ciModule);
    }


    @GetMapping("{id}")
    public ResponseEntity<CiModuleDTO> getCiModuleDtoById (@PathVariable Long id){
        CiModuleDTO ciModuleDTO = ciModuleService.GetCiModuleDtoById(id);
        return ResponseEntity.ok(ciModuleDTO);
    }

}
