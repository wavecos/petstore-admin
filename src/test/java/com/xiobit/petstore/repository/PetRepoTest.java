package com.xiobit.petstore.repository;

import static org.junit.Assert.assertEquals;

import com.xiobit.petstore.domain.Pet;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PetRepoTest {

    @MockBean
    private PetRepository petRepository;

    @Before
    public void setUp() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("testa");

        List<Pet> pets = new ArrayList();
        pets.add(pet);

        Mockito.when(petRepository.findAll()).thenReturn(pets);
    }

    @Test
    public void findAllPetsTest() {
        List<Pet> all = petRepository.findAll();

        assertEquals(all.size(), 12);
    }

}
