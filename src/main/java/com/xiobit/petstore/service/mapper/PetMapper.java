package com.xiobit.petstore.service.mapper;

import com.xiobit.petstore.domain.*;
import com.xiobit.petstore.service.dto.PetDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Pet and its DTO PetDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PetMapper extends EntityMapper<PetDTO, Pet> {



    default Pet fromId(Long id) {
        if (id == null) {
            return null;
        }
        Pet pet = new Pet();
        pet.setId(id);
        return pet;
    }
}
