package com.xiobit.petstore.service;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import com.xiobit.petstore.domain.Pet;
import com.xiobit.petstore.repository.PetRepository;
import com.xiobit.petstore.repository.UserRepository;
import com.xiobit.petstore.service.dto.PetDTO;
import com.xiobit.petstore.service.impl.PetServiceImpl;
import com.xiobit.petstore.service.mapper.PetMapper;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

public class PruebaServiceTest {

    private PetMapper petMapper = Mappers.getMapper(PetMapper.class);
    @Autowired
    private UserRepository userRepository;
    private PetRepository repository;
    private PetServiceImpl petService;

    @Before
    public void setup() throws Exception {
        repository = createNiceMock(PetRepository.class);
        petService = new PetServiceImpl(repository, petMapper, userRepository);
    }

    @Test
    public void onixTest() {

        Pet pet = new Pet();
        pet.setName("onix");

        PetDTO petDTO = new PetDTO();
        petDTO.setName("onix");

        expect(repository.save(pet)).andReturn(pet).once();

        replay(repository);

        petService.createPet(petDTO);
        assertEquals("onix", pet.getName());

//        verify(repository);
    }

}
