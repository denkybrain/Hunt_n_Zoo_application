package com.example.denky.widae;

/**
 * Created by denky on 2017-04-14.
 */

public class Animal implements AnimalAction {
    public int type;//type 1 => wild-animal, type 2 => zoo-animal
    String name;
    float height;
    float weight;
    AnimalAction action;
    WildAnimal wild;
    ZooAnimal zoo;
    Animal() {
    }
    void AnimalSet() {
        wild = new WildAnimal();
        zoo = new ZooAnimal();
        switch (type) {
            case 1:
                action = wild;
                break;
            case 2:
                action = zoo;
                break;
        }
    }

    public void gotcha() {
        type = 2;
        action = zoo;
    }

    public void goJungle() {
        type = 1;
        action = wild;
    }
    @Override
    public void attack() {
        action.attack();
    }
    @Override
    public void run() {
        action.run();
    }
    @Override
    public void eat() {
        action.eat();
    }
    @Override
    public void sleep() {
        action.sleep();
    }
    @Override
    public String survive() {
        if(action == wild)
        return action.survive();
        return "할 수 없습니다.";
    }
    @Override
    public String yowl() {
        if(action == wild)
            return action.yowl();
        return "할 수 없습니다";
    }
    @Override
    public String cuty() {
        if(action == zoo)
             return action.cuty();
    return "할 수 없습니다.";
    }
    @Override
    public String acrobatic() {
        if (action == zoo) {
            return action.acrobatic();
        }
        return "할 수 없습니다.";
    }
}
