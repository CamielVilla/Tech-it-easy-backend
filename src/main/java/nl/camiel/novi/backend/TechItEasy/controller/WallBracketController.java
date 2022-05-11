package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateWallBracketDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.WallBracket;
import nl.camiel.novi.backend.TechItEasy.service.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @PostMapping
    public ResponseEntity<WallBracket> addWallBracket (@RequestBody CreateWallBracketDTO createWallBracketDTO){
        WallBracket wallBracket = wallBracketService.addWallBracket(createWallBracketDTO);
        return ResponseEntity.ok(wallBracket);
    }

    @GetMapping("{id}/televisions")
    public ResponseEntity<Set<TelevisionDTO>> showAllTelevisionDtosFromWallBracket (@PathVariable Long id){
        return ResponseEntity.ok(wallBracketService.showAllTelevisionDtosFromWallBracket(id));
    }

}
