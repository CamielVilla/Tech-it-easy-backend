package nl.camiel.novi.backend.TechItEasy.service;

import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateRemote;
import nl.camiel.novi.backend.TechItEasy.domain.dto.RemoteDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Remote;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;
import nl.camiel.novi.backend.TechItEasy.repositories.RemoteRepository;
import nl.camiel.novi.backend.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoteService {
   private final RemoteRepository remoteRepository;
   private final TelevisionRepository televisionRepository;

    public RemoteService(RemoteRepository remoteRepository, TelevisionRepository televisionRepository) {
        this.remoteRepository = remoteRepository;
        this.televisionRepository = televisionRepository;
    }

    public RemoteDTO createRemote(CreateRemote createRemote){

        Television television = televisionRepository
                .findById(createRemote.getTelevisionId())
                .orElseThrow();

        final Remote remote = new Remote();
        remote.setName(createRemote.getName());
        remote.setBrand(createRemote.getBrand());
        remote.setPrice(createRemote.getPrice());
        remote.setOriginalStock(createRemote.getOriginalStock());
        remote.setCompatibleWith(createRemote.getCompatibleWith());
        remote.setBatteryType(createRemote.getBatteryType());
        remote.setTelevision(television);

        final Remote savedRemote = remoteRepository.save(remote);

        final TelevisionDTO televisionDTO = new TelevisionDTO();
        televisionDTO.setAmbiLight(television.getAmbiLight());
        televisionDTO.setAvailableSize(television.getAvailableSize());
        televisionDTO.setBluetooth(television.getBluetooth());
        televisionDTO.setBrand(television.getBrand());
        televisionDTO.setHdr(television.getHdr());
        televisionDTO.setName(television.getName());
        televisionDTO.setPrice(television.getPrice());
        televisionDTO.setRefreshRate(television.getRefreshRate());
        televisionDTO.setScreenQuality(television.getScreenQuality());
        televisionDTO.setScreenQuality(television.getScreenQuality());
        televisionDTO.setScreenType(television.getScreenType());
        televisionDTO.setSmartTv(television.getSmartTv());
        televisionDTO.setType(television.getType());
        televisionDTO.setVoiceControl(television.getVoiceControl());
        televisionDTO.setWifi(television.getWifi());
        televisionDTO.setSold(television.getSold());
        televisionDTO.setOriginalStock(television.getOriginalStock());
        televisionDTO.setDto(true);
        televisionDTO.setId(television.getId());


        final RemoteDTO remoteDTO = new RemoteDTO();
        remoteDTO.setId(remote.getId());
        remoteDTO.setBatteryType(remote.getBatteryType());
        remoteDTO.setBrand(remote.getBrand());
        remoteDTO.setPrice(remote.getPrice());
        remoteDTO.setOriginalStock(remote.getOriginalStock());
        remoteDTO.setCompatibleWith(remote.getCompatibleWith());
        remoteDTO.setTelevisionDTO(televisionDTO);

        return  remoteDTO;
    }

//    public void addTvToRemote () {
//
//    }



}
