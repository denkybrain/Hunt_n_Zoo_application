package com.example.denky.widae;

/**
 * Created by denky on 2017-04-14.
 */

public interface AnimalAction extends  ZooAnimalAction, WildAnimalAction {
    void attack();
    void run();
    void eat();
    void sleep();
}
