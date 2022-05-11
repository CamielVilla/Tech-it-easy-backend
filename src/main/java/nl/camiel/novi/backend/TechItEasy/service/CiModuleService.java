package nl.camiel.novi.backend.TechItEasy.service;

import nl.camiel.novi.backend.TechItEasy.Exception.IdNotExistException;
import nl.camiel.novi.backend.TechItEasy.domain.dto.CiModuleDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateCiModuleDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.TelevisionDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.CiModule;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;
import nl.camiel.novi.backend.TechItEasy.repositories.CiModuleRepository;
import nl.camiel.novi.backend.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;
    private final TelevisionRepository televisionRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository, TelevisionRepository televisionRepository) {
        this.ciModuleRepository = ciModuleRepository;
        this.televisionRepository = televisionRepository;
    }

    public CiModule toCiModule (CreateCiModuleDTO createCiModuleDTO){
        CiModule ciModule = new CiModule();
        ciModule.setName(createCiModuleDTO.getName());
        ciModule.setPrice(createCiModuleDTO.getPrice());
        ciModule.setType(createCiModuleDTO.getType());
        ciModule.setTelevisions(createCiModuleDTO.getTelevisions());
        return ciModule;
    }

    public CiModuleDTO toCiModuleDTO (CiModule ciModule){
        CiModuleDTO ciModuleDTO = new CiModuleDTO();
        ciModuleDTO.setName(ciModule.getName());
        ciModuleDTO.setPrice(ciModule.getPrice());
        ciModuleDTO.setType(ciModule.getType());
        ciModuleDTO.setId(ciModule.getId());
        ciModule.setTelevisions(ciModule.getTelevisions());
        return ciModuleDTO;
    }

    public CiModule addCiModule (CreateCiModuleDTO createCiModuleDTO){
        CiModule savedCiModule = ciModuleRepository.save(toCiModule(createCiModuleDTO));
        return savedCiModule;
    }
    public void addTelevisionToCiModule (Long ciModuleId, Long televisionId){

    }


//    public void addTvToCiModule(Long televisionId, Long ciModuleId) {
//        if(televisionRepository.existsById(televisionId) && ciModuleRepository.existsById(ciModuleId)) {
//            Television television = televisionRepository.findById(televisionId).get();
//            CiModule ciModule = ciModuleRepository.findById(ciModuleId).get();
//            List<Television> televisionList = ciModule.getTelevisions();
//            televisionList.add(television);
//            ciModule.setTelevisions(televisionList);
//            ciModuleRepository.save(ciModule);
//        }else {
//            throw new IdNotExistException(televisionId);
//        }
//    }

    public CiModuleDTO GetCiModuleDtoById(Long id){
        CiModuleDTO ciModuleDTO = toCiModuleDTO(ciModuleRepository.findById(id).get());
        List<TelevisionDTO> televisionDTOS = new ArrayList<>();

        return ciModuleDTO;
    }


}
