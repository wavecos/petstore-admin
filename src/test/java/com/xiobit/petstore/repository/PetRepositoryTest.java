package com.xiobit.petstore.repository;

import com.xiobit.petstore.PetstoreApp;
import com.xiobit.petstore.domain.Pet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PetstoreApp.class)
@Transactional
public class PetRepositoryTest {

    @Autowired
    private PetRepository petRepository;

    private Pet pet;

    @Before
    public void setup() {
        petRepository.deleteAll();

        pet = new Pet();
        pet.setId(1L);
        pet.setName("Garfield");
        pet.setAge(3);
        pet.setNotes("Test notas");
    }

    @Test
    public void persistPetTest() {
        Pet save = petRepository.save(pet);

        Pet petPersisted = petRepository.findAll().get(0);

        assertEquals(pet.getName(), petPersisted.getName());
    }

}
