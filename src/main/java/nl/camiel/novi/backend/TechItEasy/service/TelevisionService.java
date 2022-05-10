package nl.camiel.novi.backend.TechItEasy.service;

import nl.camiel.novi.backend.TechItEasy.Exception.IdNotExistException;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Remote;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;
import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateTelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.repositories.RemoteRepository;
import nl.camiel.novi.backend.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteRepository remoteRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteRepository remoteRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteRepository = remoteRepository;
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
        return dto;
    }



    public TelevisionDTO getTvById(Long id) {
        if (televisionRepository.existsById(id)) {
            TelevisionDTO televisionDTO = toTelevisionDTO(televisionRepository.findById(id).get());
            return televisionDTO;
        } else {
            throw new IdNotExistException(id);
        }
    }

    public List<TelevisionDTO> getAllTvs() {
    final List<Television> televisionList = televisionRepository.findAll();
    List<TelevisionDTO> DTOList = new ArrayList<>();
    for (Television tv : televisionList){
        DTOList.add(toTelevisionDTO(tv));
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


}


