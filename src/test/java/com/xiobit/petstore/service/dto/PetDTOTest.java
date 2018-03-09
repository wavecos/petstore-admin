package com.xiobit.petstore.service.dto;

import com.xiobit.petstore.domain.enumeration.Gender;
import com.xiobit.petstore.domain.enumeration.PetType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetDTOTest {

    private static String GARFIELD_DESC = "Garfield CAT 3";
    private PetDTO gato1;

    @Before
    public void setup() {
        gato1 = new PetDTO();
        gato1.setAge(3);
        gato1.setBreed("Siames");
        gato1.setType(PetType.CAT);
        gato1.setName("Garfield");
        gato1.setGender(Gender.FEMALE);
    }

    @Test
    public void extraInformationTest() {
        assertEquals("La información extra no es correcta", GARFIELD_DESC, gato1.extraInformation());
        assertNotNull("verificar si tiene genero", gato1.getGender());
    }

    @Test
    public void convertionToPoundsTest() {
        gato1.setWeight(4.5F);

        Float weightInPounds = gato1.convertWeightToPounds();
        assertEquals(9.91189F, weightInPounds, 5);
    }

}
