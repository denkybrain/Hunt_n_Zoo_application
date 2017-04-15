package com.example.denky.widae;


import android.widget.TextView;

/**
 * Created by denky on 2017-04-14.
 */

public class WildAnimal extends Animal implements WildAnimalAction {
    @Override
    public String survive() {
        return "야생으로 부터 생존한다!";
    }

    @Override
    public String yowl() {
        return "울부짖었다";

    }
}
