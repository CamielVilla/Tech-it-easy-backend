package nl.camiel.novi.backend.TechItEasy.domain.dto;

import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;

import java.util.List;

public class CreateCiModuleDTO {

    private String name;
    private String type;
    private Double price;
    List<Television> televisions;

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
