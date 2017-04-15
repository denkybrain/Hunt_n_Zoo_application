package com.example.denky.widae;

/**
 * Created by denky on 2017-04-14.
 */

public class ZooAnimal extends Animal implements ZooAnimalAction {

    @Override
    public String cuty() {

        return "애교부렸다";
    }

    @Override
    public String acrobatic() {
        return "묘기했다";
    }
}
