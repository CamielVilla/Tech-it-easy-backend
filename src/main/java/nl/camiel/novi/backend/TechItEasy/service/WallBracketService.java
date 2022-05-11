package nl.camiel.novi.backend.TechItEasy.service;

import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateWallBracketDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.WallBracketDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;
import nl.camiel.novi.backend.TechItEasy.domain.entity.WallBracket;
import nl.camiel.novi.backend.TechItEasy.repositories.TelevisionRepository;
import nl.camiel.novi.backend.TechItEasy.repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WallBracketService {


    private final WallBracketRepository wallBracketRepository;
    private final TelevisionRepository televisionRepository;
    private final TelevisionService televisionService;

    public WallBracketService(WallBracketRepository wallBracketRepository, TelevisionRepository televisionRepository, TelevisionService televisionService) {
        this.wallBracketRepository = wallBracketRepository;
        this.televisionRepository = televisionRepository;
        this.televisionService = televisionService;
    }

    public WallBracketDTO toWallBracketDTO (WallBracket wallBracket){
    WallBracketDTO wallBracketDTO = new WallBracketDTO();
    wallBracketDTO.setName(wallBracket.getName());
    wallBracketDTO.setId(wallBracketDTO.getId());
    wallBracketDTO.setAjustable(wallBracket.getAjustable());
    wallBracketDTO.setPrice(wallBracket.getPrice());
    wallBracketDTO.setSize(wallBracket.getSize());
    wallBracketDTO.setTelevisions(wallBracket.getTelevisions());
    return wallBracketDTO;
    }

    public WallBracket toWallBracket (CreateWallBracketDTO createWallBracketDTO){
        WallBracket wallBracket = new WallBracket();
        wallBracket.setName(createWallBracketDTO.getName());
        wallBracket.setAjustable(createWallBracketDTO.getAjustable());
        wallBracket.setTelevisions(createWallBracketDTO.getTelevisions());
        wallBracket.setSize(createWallBracketDTO.getSize());
        wallBracket.setPrice(createWallBracketDTO.getPrice());
        return  wallBracket;
    }



    public WallBracket addWallBracket (CreateWallBracketDTO createWallBracketDTO){
        WallBracket savedWallBracket = wallBracketRepository.save(toWallBracket(createWallBracketDTO));
        return savedWallBracket;
    }

    public Set<TelevisionDTO> showAllTelevisionDtosFromWallBracket (Long id){
        WallBracket wallBracket = wallBracketRepository.findById(id).get();
        Set<TelevisionDTO> televisionDTOS = new HashSet<>();
        for (Television tv : wallBracket.getTelevisions()){
            televisionDTOS.add(televisionService.toTelevisionDTO(tv));
        }
        return televisionDTOS;
    }

}
