package com.xiobit.petstore.repository;

import com.xiobit.petstore.PetstoreApp;
import com.xiobit.petstore.domain.Pet;
import com.xiobit.petstore.service.impl.PetServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PetstoreApp.class)
@Transactional
public class PetRepositoryTest {

    private final Logger log = LoggerFactory.getLogger(PetRepositoryTest.class);

    @Autowired
    private PetRepository petRepository;

    private Pet pet;

    @Before
    public void setup() {
        petRepository.deleteAll();

        pet = new Pet();
      //  pet.setId(1L);
        pet.setName("Garfield");
        pet.setAge(3);
        pet.setNotes("Test notas");
    }

    @Test
    public void persistPetTest() {
        System.out.println("Mi test de repositorio");
        log.debug("Este texto es de un debug de log");

        petRepository.save(pet);

        Pet petPersisted = petRepository.findOneByName("Garfield");
        assertNotNull(petPersisted);
        assertEquals(pet.getName(), petPersisted.getName());
    }

    @Test
    public void testCount() {

        Pet pet1 = new Pet();
        pet1.setName("Piolin");
        Pet pet2 = new Pet();
        pet2.setName("Daffy");
        Pet pet3 = new Pet();
        pet3.setName("Porky");

        petRepository.save(pet1);
        petRepository.save(pet2);
        petRepository.save(pet3);

        long count = petRepository.count();

        assertEquals(count, 3);
    }

    @Test
    public void deleteTest() {
        petRepository.save(pet);
        long countAfterInsert = petRepository.count();
        assertEquals(1, countAfterInsert);
        Pet garfield = petRepository.findOneByName("Garfield");
        petRepository.delete(garfield);
        long countAfterDelete = petRepository.count();
        assertEquals(0, countAfterDelete);
    }

    @Test
    public void updateTest(){

        //1. Guardar
        Pet petSaved = petRepository.save(pet);

        //2. Verificar si el id tiene un valor=seteado
        assertNotNull(petSaved.getId());

        //3. Modificar algunos atributos
        petSaved.setName("Gatubela");

        //4. guardar de nuevo el petSaved
        petRepository.save(petSaved);   //aqui el save esta haciendo una actualizacion y no INSERT

        //5. recuperar el nuevo pet con el nombre
        Pet gatubela = petRepository.findOneByName("Gatubela");

        //6. assert que el nuevo nombre del Pet sea el que se dio en el paso 5
        assertEquals("Gatubela", gatubela.getName());


    }


}
