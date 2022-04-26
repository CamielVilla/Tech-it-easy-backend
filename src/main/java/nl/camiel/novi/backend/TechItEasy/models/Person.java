package nl.camiel.novi.backend.TechItEasy.models;

import nl.camiel.novi.backend.TechItEasy.domain.Television;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<Television> televisionList;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.televisionList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addTv (Television television){
        televisionList.add(television);
    }

}
