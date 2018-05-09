package com.xiobit.petstore.service.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import com.xiobit.petstore.repository.PetRepository;
import com.xiobit.petstore.repository.UserRepository;
import com.xiobit.petstore.service.dto.PetDTO;
import com.xiobit.petstore.service.mapper.PetMapper;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

public class PetServiceImplTest {

    private PetRepository petRepository;
    private PetMapper petMapper = Mappers.getMapper(PetMapper.class);
    private UserRepository userRepository;

    private PetServiceImpl petService;

    @Before
    public void setUp() {
        petRepository = createStrictMock(PetRepository.class);
        userRepository = createStrictMock(UserRepository.class);

        petService = new PetServiceImpl(petRepository, petMapper, userRepository);
    }

    @Test
    public void saveTest() {
        PetDTO petDTO = new PetDTO();
        petDTO.setName("Garfield");
        petDTO.setAge(3);

        PetDTO salida = petService.createPet(petDTO);
        assertEquals(petDTO.getName(), salida.getName());
    }


}
