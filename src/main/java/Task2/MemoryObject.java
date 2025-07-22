package Task2;

import Task2.Animals.Pet;

// DO NOT MAKE CHANGES
public class MemoryObject {

    Pet pet;
    Integer vTableAddress;

    public MemoryObject(Pet pet, Integer vTableAddress) {
        this.pet = pet;
        this.vTableAddress = vTableAddress;
    }
}
