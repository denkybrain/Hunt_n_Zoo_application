package com.example.denky.widae;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by denky on 2017-04-14.
 */

public class WildActivity extends AppCompatActivity {
    int i = 0;
    ImageView GrassImage;
    ImageView AnimalImage;
    TextView notifyText;
    Animal animal;
    Bitmap animalBitamp;
    String gotAnimal;
    String whatAnimal = "No";

    void changeAnimalImage(String name) {
        switch (name) {
            case "No":
                AnimalImage.setImageResource(android.R.color.transparent);
            case "Lion":
                animalBitamp = bitmapper(R.drawable.lion, 4);
                whatAnimal = "Lion";
                break;
            case "Monkey":
                animalBitamp = bitmapper(R.drawable.monkey, 4);
                whatAnimal = "Monkey";
                break;
            case "Deer":
                animalBitamp = bitmapper(R.drawable.deer, 4);
                whatAnimal = "Deer";
                break;
            case "Wolf":
                animalBitamp = bitmapper(R.drawable.wolf, 4);
                whatAnimal = "Wolf";
                break;
        }
        if (name != "No") {
            AnimalImage.setImageBitmap(animalBitamp);
        } else {
            whatAnimal = "No";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild);
        notifyText = (TextView) findViewById(R.id.nofy_text);
        GrassImage = (ImageView) findViewById(R.id.grassimg);
        AnimalImage = (ImageView) findViewById(R.id.animal);
        notifyText.setText("Waiting for Animals..");
        int state = 0;//0> wating 1>found
        Random random = new Random();
        int what_animal = random.nextInt(5);
        int timer = random.nextInt(5);

        Bitmap b1 = bitmapper(R.drawable.grass, 6);
        GrassImage.setImageBitmap(b1);

        AnimalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (whatAnimal == "No") {
                    // Log.d("result : ", "No animal here");
                 }else{
                     switch (whatAnimal) {
                         case "Lion":
                             notifyText.setText("You got Lion!");
                             gotAnimal = "Lion";
                             break;
                         case "Monkey":
                             notifyText.setText("You got Monkey!");
                             gotAnimal = "Monkey";
                             break;
                         case "Deer" :
                             notifyText.setText("You got Deer!");
                             gotAnimal = "Deer";
                             break;
                         case "Wolf" :
                             notifyText.setText("You got Wolf!");
                             gotAnimal = "Wolf";
                             break;
                     }
                     changeAnimalImage("No");
                 }
            }
        });
        Thread myThread = new Thread(new Runnable() {
            boolean stopped = true;

            public void run() {
                //Log.d("result : ", "스레드가 실행되었습니다.");
                while (stopped) {
                    try {
                        Random random = new Random();
                        int timer = random.nextInt(3) + 5;//5~14초
                        //Log.d("result : ", "스레드 대기시간 : "+timer+"초");
                        Thread.sleep(timer * 1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {//UI 업데이트실행문
                                Random random = new Random();
                                int timer = random.nextInt(2);
                                //Log.d("result : ", "타이머 : "+timer);
                                switch (timer) {
                                    case 0:
                                        notifyText.setText("No animal in the Wild!");
                                        changeAnimalImage("No");
                                        break;
                                    case 1:
                                        timer = random.nextInt(4);
                                        //Log.d("result : ", "애니멀 : "+timer);
                                        switch (timer) {
                                            case 0:
                                                changeAnimalImage("Lion");
                                                notifyText.setText("Lion came!!");
                                                animal = new Lion(2, "Lion");
                                                break;
                                            case 1:
                                                changeAnimalImage("Wolf");
                                                notifyText.setText("Wolf came!!");
                                                animal = new Lion(2, "Wolf");
                                                break;
                                            case 2:
                                                changeAnimalImage("Monkey");
                                                notifyText.setText("Monkey came!!");
                                                animal = new Lion(2, "Monkey");
                                                break;
                                            case 3:
                                                changeAnimalImage("Deer");
                                                notifyText.setText("Deer came!!");
                                                animal = new Lion(2, "Deer");
                                                break;
                                        }
                                }
                            }
                        });
                    } catch (Throwable t) {
                    }
                }
            }

        });
        myThread.start();

    }


    public void onBackPressed() {
        //Log.d("result : ", gotAnimal);

        Intent i = new Intent(WildActivity.this, MainActivity.class);
        i.putExtra("animal", gotAnimal);
        startActivity(i);
        finish();
    }

    public Bitmap bitmapper(int id, int resizer) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = resizer;
        Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(), id, options);
        return bitmapOrg;
    }
}
    /*
        int width = bitmapOrg.getWidth();
        int height = bitmapOrg.getHeight();
        int newWidth = width;
        int newHeight = height;
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width, height , matrix, true);
        */