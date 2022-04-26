package nl.camiel.novi.backend.TechItEasy.service;

import nl.camiel.novi.backend.TechItEasy.domain.CreateTelevision;
import nl.camiel.novi.backend.TechItEasy.domain.Television;
import nl.camiel.novi.backend.TechItEasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public Television getTvById(Long id) {
//        final Optional<Television> televisionOptional = televisionRepository.getTelevisionByName(name);
        final Television television = televisionRepository.findById(id).get();
        return television;
    }

    public List<Television> getAllTvs() {
    final List<Television> televisionList = televisionRepository.findAll();
    return televisionList;
    }

    public Television addTv(CreateTelevision createTelevision){
        Television television = new Television();

        television.setAmbiLight(createTelevision.getAmbiLight());
        television.setAvailableSize(createTelevision.getAvailableSize());
        television.setBluetooth(createTelevision.getBluetooth());
        television.setBrand(createTelevision.getBrand());
        television.setHdr(createTelevision.getHdr());
        television.setName(createTelevision.getName());
        television.setOriginalStock(createTelevision.getOriginalStock());
        television.setPrice(createTelevision.getPrice());
        television.setRefreshRate(createTelevision.getRefreshRate());
        television.setScreenQuality(createTelevision.getScreenQuality());
        television.setSmartTv(createTelevision.getSmartTv());
        television.setWifi(createTelevision.getWifi());
        television.setVoiceControl(createTelevision.getVoiceControl());
        television.setOriginalStock(createTelevision.getOriginalStock());
        television.setSold(createTelevision.getSold());
        television.setType(createTelevision.getType());

        final Television savedTelevision = televisionRepository.save(television);

        return savedTelevision;
    }

//    public Television deleteTvById(Long id){
//        final Television television = televisionRepository.findById(id).get();
//        return television;
//    }

public void  deleteTv(Long id){
    televisionRepository.deleteById(id);
}

}


