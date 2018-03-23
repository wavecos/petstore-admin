package com.xiobit.petstore.service;

import com.xiobit.petstore.PetstoreApp;
import com.xiobit.petstore.domain.Pet;
import com.xiobit.petstore.repository.PetRepository;
import com.xiobit.petstore.service.dto.PetDTO;
import com.xiobit.petstore.service.impl.PetServiceImpl;
import com.xiobit.petstore.service.mapper.PetMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PetstoreApp.class)
public class DummyTest {

    @Mock
    private PetMapper petMapper;

    @Mock
    private PetRepository petRepositoryMock;

    @Autowired
    private PetService petService;

//    @Before
//    public void setUp() {
//        Pet alex = new Pet();
//        alex.setName("Pet");
//
//        Mockito.when(petRepository.findOne(1L))
//            .thenReturn(alex);
//    }

    @Test
    public void validateTest() {
        Pet alex = new Pet();
        alex.setName("Pet");
        when(petRepositoryMock.findOne(1L)).thenReturn(alex);

        PetDTO peto = petService.findOne(1L);
        assertEquals(peto.getName(), "Pet");
    }

}
