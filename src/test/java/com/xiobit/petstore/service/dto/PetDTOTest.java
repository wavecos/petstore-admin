package com.xiobit.petstore.service.dto;

import com.xiobit.petstore.domain.enumeration.Gender;
import com.xiobit.petstore.domain.enumeration.PetType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetDTOTest {

    @Test
    public void extraInformationTest() {

        PetDTO gato1 = new PetDTO();
        gato1.setAge(3);
        gato1.setBreed("Siames");
        gato1.setType(PetType.CAT);
        gato1.setName("Garfield");
        gato1.setGender(Gender.FEMALE);

        assertEquals("La información extra no es correcta", "Garfield CAT 3", gato1.extraInformation());
        assertNotNull("verificar si tiene genero", gato1.getGender());
    }


}
