package com.scottlogic.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalShelterTest {
    @Test
    void enque() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enque((AnimalShelter.Animal) new AnimalShelter.Cat("1"));
        shelter.enque(new AnimalShelter.Cat("2"));

        assertEquals("1", shelter.dequeCat().get().name);
    }

    @Test
    void dequeAny() {

        AnimalShelter shelter = new AnimalShelter();
        shelter.enque(new AnimalShelter.Cat("1"));
        shelter.enque(new AnimalShelter.Dog("2"));
        shelter.enque(new AnimalShelter.Cat("3"));
        shelter.enque(new AnimalShelter.Dog("4"));

        assertEquals("1", shelter.dequeAny().get().getName());
    }

}