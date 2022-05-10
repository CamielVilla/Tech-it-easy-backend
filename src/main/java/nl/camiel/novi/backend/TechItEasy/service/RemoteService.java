package nl.camiel.novi.backend.TechItEasy.service;

import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateRemoteDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.RemoteDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Remote;
import nl.camiel.novi.backend.TechItEasy.repositories.RemoteRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoteService {
   private final RemoteRepository remoteRepository;

    public RemoteService(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public Remote toRemote(CreateRemoteDTO createRemoteDTO) {

        Remote remote = new Remote();
        remote.setName(createRemoteDTO.getName());
        remote.setBrand(createRemoteDTO.getBrand());
        remote.setPrice(createRemoteDTO.getPrice());
        remote.setOriginalStock(createRemoteDTO.getOriginalStock());
        remote.setCompatibleWith(createRemoteDTO.getCompatibleWith());
        remote.setBatteryType(createRemoteDTO.getBatteryType());

        final Remote savedRemote = remoteRepository.save(remote);
        return savedRemote;

    }

        public RemoteDTO toRemoteDTO (Remote remote){
            final RemoteDTO remoteDTO = new RemoteDTO();
            remoteDTO.setId(remote.getId());
            remoteDTO.setBatteryType(remote.getBatteryType());
            remoteDTO.setBrand(remote.getBrand());
            remoteDTO.setPrice(remote.getPrice());
            remoteDTO.setOriginalStock(remote.getOriginalStock());
            remoteDTO.setCompatibleWith(remote.getCompatibleWith());
            return  remoteDTO;
        }
    }





