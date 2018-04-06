package com.xiobit.petstore.service.dto;


import java.io.Serializable;
import java.util.Objects;
import com.xiobit.petstore.domain.enumeration.PetType;
import com.xiobit.petstore.domain.enumeration.Gender;

/**
 * A DTO for the Pet entity.
 */
public class PetDTO implements Serializable {

    private Long id;

    private String name;

    private PetType type;

    private String breed;

    private Float weight;

    private Integer age;

    private Gender gender;

    private String notes;

    private String test = "hola mundo";

    public String extraInformation() {
        return this.getName() + " " + this.getType() + " " + this.getAge();
    }

    public Float convertWeightToPounds() {
        return (this.getWeight() * 1000) / 454;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PetDTO petDTO = (PetDTO) o;
        if(petDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), petDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PetDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", breed='" + getBreed() + "'" +
            ", weight=" + getWeight() +
            ", age=" + getAge() +
            ", gender='" + getGender() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
