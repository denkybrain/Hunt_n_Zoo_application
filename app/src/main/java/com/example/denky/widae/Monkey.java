package com.example.denky.widae;

import android.util.Log;

/**
 * Created by denky on 2017-04-14.
 */

public class Monkey extends Animal{
    String what = "monkey";
    Monkey(int type, String name){
        this.name = name;
        this.type = type;
        AnimalSet();
    }
    String dance(){
        return "원숭이만의 춤을 췄다";
    }
}
