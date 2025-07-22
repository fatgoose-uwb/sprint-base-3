import Task2.OOPSimulator;
import Task2.PetData;
import Task2.Reference;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// DO NOT REMOVE OR CHANGE ANYTHING

public class Task2Test {

    @Test
    public void testPetSpeakAndGetName() {
        OOPSimulator OOPSim = new OOPSimulator();

        List<PetData> petDataList = Arrays.asList(
                new PetData("Dog", "Sam", 2, "Peng", "my name is sam"),
                new PetData("Dog", "Max", 3, "Peng", "Sup dog!"),
                new PetData("Cat", "Coco", 7, "Rat doll", "Long time no see")
        );

        List<Reference> pets = new ArrayList<>();

        for (PetData data : petDataList) {
            Reference pet;

            if ("Dog".equals(data.type)) {
                pet = OOPSim.newDog(data.name, data.age, data.extra);
            } else {
                pet = OOPSim.newCat(data.name, data.age, data.extra);
            }

            // Test speak output (should return 'message' + " spoken")
            String spoken = OOPSim.call(pet, "speak", data.message);
            assertEquals("'" + data.message + "' spoken", spoken);

            // Test getName output
            String nameResult = OOPSim.call(pet, "getName", null);
            assertTrue(nameResult.contains(data.name));

            pets.add(pet);
        }

        assertEquals(3, pets.size());
    }
}
