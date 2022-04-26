package nl.camiel.novi.backend.TechItEasy.domain.dto;

public class CreateTelevisionDTO {
    private String name;
    private int screenSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
}
