package com.example.denky.widae;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by denky on 2017-04-14.
 */

public class DetailActivity extends AppCompatActivity {
    Button action_btn1;
    Button action_btn2;
    Button action_btn3;
    Button action_btn4;
    Button action_btn5;
    Button action_btn6;
    TextView text_first;
    TextView myAnimalText;
    ImageView imgview;
    String myAnimal;
    Bitmap animalBitamp;
    Animal animalObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        myAnimal ="";
        Intent i = getIntent();
        myAnimal = i.getStringExtra("animal");

        action_btn1 =(Button)findViewById(R.id.wild_btn);
        action_btn2 =(Button)findViewById(R.id.zoo_btn);
        action_btn3 =(Button)findViewById(R.id.action1);
        action_btn4 =(Button)findViewById(R.id.action2);
        action_btn5 =(Button)findViewById(R.id.action3);
        action_btn6 =(Button)findViewById(R.id.action4);
        text_first = (TextView)findViewById(R.id.explan_text);
        imgview = (ImageView)findViewById(R.id.animalImage);
        myAnimalText = (TextView)findViewById(R.id.myAnimal);
        View.OnClickListener clicker;


        final Monkey monkey = new Monkey(1, "Monkey");
        if(myAnimal.length()>3){ // 잡은 동물이 있습니다
            myAnimalText.setText("당신의 동물은 "+myAnimal+"입니다.");
            changeAnimalImage(myAnimal);
            switch (myAnimal){
                case "Lion" :
                    animalObject = new Lion(2, "Lion");
                    break;
                case "Monkey":
                    animalObject = new Monkey(2, "Monkey");
                    break;
                case "Deer" :
                    animalObject = new Deer(2, "Deer");
                    break;
                case "Wolf" :
                    animalObject = new Wolf(2, "Wolf");
                    break;
            }
            text_first.setText(myAnimal+"는 현재 동물원 동물입니다.");
        }


        clicker = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.wild_btn:
                        text_first.setText("현재 야생 "+myAnimal+"입니다.");
                        if(animalObject.type  == 2){
                            text_first.setText("야생 "+myAnimal+"가 되었습니다.");
                            animalObject.goJungle();
                        }
                        break;
                    case R.id.zoo_btn:
                        text_first.setText("현재 동물원 "+myAnimal+"입니다.");
                        if(monkey.type ==1 ) {
                            text_first.setText("동물원 "+myAnimal+"가 되었습니다.");
                            animalObject.gotcha();
                        }
                        break;
                    case R.id.action1:
                        text_first.setText(animalObject.acrobatic());
                        break;
                    case R.id.action2:
                        text_first.setText(animalObject.dance());
                        break;
                    case R.id.action3:
                        text_first.setText(animalObject.survive());
                        break;
                    case R.id.action4:
                        text_first.setText(animalObject.yowl());
                        break;
                }
            }
        };
        if(myAnimal.length()>3){
        action_btn1.setOnClickListener(clicker);
        action_btn2.setOnClickListener(clicker);
        action_btn3.setOnClickListener(clicker);
        action_btn4.setOnClickListener(clicker);
        action_btn5.setOnClickListener(clicker);
        action_btn6.setOnClickListener(clicker);
        }
    }
    public void onBackPressed() {
        Intent i = new Intent(DetailActivity.this, MainActivity.class);
        if (myAnimal.length() > 3)
        i.putExtra("animal", myAnimal);
        else
        i.putExtra("animal","");
        startActivity(i);
        finish();
    }
    public Bitmap bitmapper(int id, int resizer) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = resizer;
        Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(), id, options);
        return bitmapOrg;
    }
    void changeAnimalImage(String name) {
        switch (name) {
            case "Lion":
                animalBitamp = bitmapper(R.drawable.lion, 4);
                break;
            case "Monkey":
                animalBitamp = bitmapper(R.drawable.monkey, 4);
                break;
            case "Deer":
                animalBitamp = bitmapper(R.drawable.deer, 4);
                break;
            case "Wolf":
                animalBitamp = bitmapper(R.drawable.wolf, 4);
                break;
        }
        imgview.setImageBitmap(animalBitamp);
    }
}
