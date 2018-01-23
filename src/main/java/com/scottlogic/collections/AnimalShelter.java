package com.scottlogic.collections;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public class AnimalShelter {

    interface Animal {

        void setDate();

        String getName();

        default Long date() {
            return System.nanoTime();
        }
    }

    static class Cat implements Animal {
        Long date;
        @Override
        public void setDate() {
            date = date();
        }

        @Override
        public String getName() {
            return name;
        }

        String name;

        public Cat(String name) {
            this.name = name;
        }
    }

    static class Dog implements Animal {
        Long date;
        @Override
        public void setDate() {
            date = date();
        }

        @Override
        public String getName() {
            return name;
        }

        public Dog(String name) {
            this.name = name;
        }

        String name;

    }

    private Queue<Dog> dogs = new ArrayDeque<>();
    private Queue<Cat> cats = new ArrayDeque<>();

    public void enque(Animal a) {
        if (a instanceof Dog) {
            enque((Dog) a);
        }
        if (a instanceof Cat) {
            enque((Cat) a);
        }
    }

    public void enque(Dog a) {
        a.setDate();
        dogs.add(a);
    }

    public void enque(Cat a) {
        a.setDate();
        cats.add(a);
    }

    public Optional<Animal> dequeAny() {
        Cat oldestCat = cats.peek();
        Dog oldestDog = dogs.peek();
        if (oldestCat == null || oldestDog.date < oldestCat.date) {
            return Optional.ofNullable(dogs.poll());
        } else {
            return Optional.ofNullable(cats.poll());
        }
    }

    public Optional<Cat> dequeCat() {
        return Optional.ofNullable(cats.poll());
    }

    public Optional<Dog> dequeDoq() {
        return Optional.ofNullable(dogs.poll());
    }
}
