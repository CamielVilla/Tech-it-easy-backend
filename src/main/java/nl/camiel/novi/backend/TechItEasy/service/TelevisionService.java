package nl.camiel.novi.backend.TechItEasy.service;

import nl.camiel.novi.backend.TechItEasy.Exception.IdNotExistException;
import nl.camiel.novi.backend.TechItEasy.domain.dto.WallBracketDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.CiModule;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Remote;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;
import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateTelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.WallBracket;
import nl.camiel.novi.backend.TechItEasy.repositories.CiModuleRepository;
import nl.camiel.novi.backend.TechItEasy.repositories.RemoteRepository;
import nl.camiel.novi.backend.TechItEasy.repositories.TelevisionRepository;
import nl.camiel.novi.backend.TechItEasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteRepository remoteRepository;
    private final CiModuleRepository ciModuleRepository;
    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteRepository remoteRepository, CiModuleRepository ciModuleRepository, WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteRepository = remoteRepository;
        this.ciModuleRepository = ciModuleRepository;
        this.wallBracketRepository = wallBracketRepository;
    }

    public Television toTelevision(CreateTelevisionDTO dto){

        var television = new Television();
        television.setAmbiLight(dto.getAmbiLight());
        television.setAvailableSize(dto.getAvailableSize());
        television.setBluetooth(dto.getBluetooth());
        television.setBrand(dto.getBrand());
        television.setHdr(dto.getHdr());
        television.setName(dto.getName());
        television.setScreenQuality(dto.getScreenQuality());
        television.setType(dto.getType());
        television.setWifi(dto.getWifi());
        television.setRefreshRate(dto.getRefreshRate());
        television.setVoiceControl(dto.getVoiceControl());
        television.setSmartTv(dto.getSmartTv());
        television.setScreenType(dto.getScreenType());
        television.setSold(dto.getSold());
        television.setOriginalStock(dto.getOriginalStock());
        television.setPrice(dto.getPrice());
        return television;
    }

    public TelevisionDTO toTelevisionDTO(Television television){
        TelevisionDTO dto = new TelevisionDTO();
        dto.setAmbiLight(television.getAmbiLight());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setBluetooth(television.getBluetooth());
        dto.setBrand(television.getBrand());
        dto.setHdr(television.getHdr());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setScreenType(television.getScreenType());
        dto.setSmartTv(television.getSmartTv());
        dto.setType(television.getType());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setWifi(television.getWifi());
        dto.setSold(television.getSold());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setDto(true);
        dto.setId(television.getId());
        dto.setRemote(television.getRemote());
        dto.setCiModule(television.getCiModule());
        return dto;
    }



    public TelevisionDTO getTvById(Long id) {
        if (televisionRepository.existsById(id)) {
            Television television = televisionRepository.findById(id).get();
            TelevisionDTO televisionDTO = toTelevisionDTO(television);
            if(television.getWallBrackets() != null){
                Set<WallBracket> wallBrackets = getAllWallBracketsFromTelevision(id);
                televisionDTO.setWallBrackets(wallBrackets);
            }
            return televisionDTO;
        } else {
            throw new IdNotExistException(id);
        }
    }

    public List<TelevisionDTO> getAllTvs() {
    final List<Television> televisionList = televisionRepository.findAll();
    List<TelevisionDTO> DTOList = new ArrayList<>();
    for (Television tv : televisionList){
        Set<WallBracket> wallBrackets = getAllWallBracketsFromTelevision(tv.getId());
        TelevisionDTO televisionDTO = toTelevisionDTO(tv);
        televisionDTO.setWallBrackets(wallBrackets);
        DTOList.add(televisionDTO);
        }
    return DTOList;
    }



    public Television addTv(CreateTelevisionDTO createTelevisionDTO){
        Television savedTelevision = televisionRepository.save(toTelevision(createTelevisionDTO));
        return savedTelevision;
    }



public void deleteTv(Long id){
    if(televisionRepository.existsById(id)) {
        televisionRepository.deleteById(id);
    }
    else {
        throw new IdNotExistException(id);
    }
}

public Television updateTv (CreateTelevisionDTO createTelevisionDTO, Long id){
        Television television = televisionRepository.findById(id).get();
        if (createTelevisionDTO.getName() != null){
            television.setName(createTelevisionDTO.getName());
        }
        if (createTelevisionDTO.getPrice() != null){
            television.setPrice((createTelevisionDTO.getPrice()));
        }
        televisionRepository.save(television);
        return  television;
    }

    public void addRemoteToTelevision (Long televisionId, Long remoteId){
        if (televisionRepository.existsById(televisionId) && remoteRepository.existsById(remoteId)){
            Television television = televisionRepository.findById(televisionId).get();
            Remote remote = remoteRepository.findById(remoteId).get();
            television.setRemote(remote);
            televisionRepository.save(television);
        } else{
            throw new IdNotExistException(televisionId);
        }
    }

    public void addCiModuleToTelevision (Long televisionId, Long ciModuleId) {
        if (televisionRepository.existsById(televisionId) && ciModuleRepository.existsById(ciModuleId)) {
            Television television = televisionRepository.findById(televisionId).get();
            CiModule ciModule = ciModuleRepository.findById(ciModuleId).get();
            television.setCiModule(ciModule);
            televisionRepository.save(television);
        } else {
            throw new IdNotExistException(ciModuleId);
        }
    }

    public void addWallBracketToTelevision (Long televisionId, Long wallBracketId){
        if (wallBracketRepository.existsById(wallBracketId) && televisionRepository.existsById(televisionId)){
            Television television = televisionRepository.findById(televisionId).get();
            WallBracket wallBracket = wallBracketRepository.findById(wallBracketId).get();
            Set<WallBracket> wallBrackets = television.getWallBrackets();
            wallBrackets.add(wallBracket);
            televisionRepository.save(television);

        }else{
            throw new IdNotExistException(wallBracketId);
        }
    }

    public Set<WallBracket> getAllWallBracketsFromTelevision (Long id) {
            Television television = televisionRepository.findById(id).get();
            Set<WallBracket> wallBrackets = television.getWallBrackets();
           return wallBrackets;
        }



}


