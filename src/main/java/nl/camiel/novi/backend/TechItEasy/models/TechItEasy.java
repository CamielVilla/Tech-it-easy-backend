package nl.camiel.novi.backend.TechItEasy.models;

import nl.camiel.novi.backend.TechItEasy.domain.Television;

import java.util.ArrayList;
import java.util.List;

public class TechItEasy {
    private String name;
    private List<Television> allTvsList;

    public TechItEasy(String name, List<Television> allTvsList) {
        this.name = name;
        this.allTvsList = allTvsList;
    }

    public TechItEasy(String name) {
        this.name = name;
        allTvsList = new ArrayList<>();
    }

    public List<Television> getAllTvsList() {
        return allTvsList;
    }

    public void setAllTvsList(List<Television> allTvsList) {
        this.allTvsList = allTvsList;
    }

    public void addTv(Television television){
        allTvsList.add(television);
    }

}
