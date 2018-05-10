package com.xiobit.petstore.service.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import com.xiobit.petstore.domain.Pet;
import com.xiobit.petstore.repository.PetRepository;
import com.xiobit.petstore.repository.UserRepository;
import com.xiobit.petstore.service.PetService;
import com.xiobit.petstore.service.dto.PetDTO;
import com.xiobit.petstore.service.mapper.PetMapper;
import com.xiobit.petstore.service.mapper.PetMapperImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class PetServiceImplTest {


    @TestConfiguration
    static class PetServiceImplTestContextConfiguration {

        @Bean
        public PetService employeeService() {
            return new PetServiceImpl();
        }
    }

    @MockBean
    private PetRepository petRepository;

    @MockBean
    private PetMapper petMapper;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private PetService petService;

    @Before
    public void setUp() {

        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("test");

        List<Pet> pets = new ArrayList();
        pets.add(pet);

        Mockito.when(petRepository.findAll()).thenReturn(pets);
    }

    @Test
    public void findAllPetsTest() {
        PageRequest pageRequest = new PageRequest(0, 5);
        Page<PetDTO> all = petService.findAll(pageRequest);

        assertEquals(all.getContent().size(), 1);
    }


}
