package nl.camiel.novi.backend.TechItEasy.domain.dto;

import nl.camiel.novi.backend.TechItEasy.domain.entity.Television;

import java.util.Set;

public class WallBracketDTO {
    private Long id;
    private String size;
    private Boolean ajustable;
    private String name;
    private Double price;
    private Set<Television> televisions;

    public Set<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(Set<Television> televisions) {
        this.televisions = televisions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAjustable() {
        return ajustable;
    }

    public void setAjustable(Boolean ajustable) {
        this.ajustable = ajustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
