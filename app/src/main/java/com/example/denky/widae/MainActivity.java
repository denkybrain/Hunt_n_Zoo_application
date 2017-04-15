package com.example.denky.widae;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by denky on 2017-04-14.
 */

public class MainActivity extends AppCompatActivity {
    Button action_btn1;
    Button action_btn2;
    Button action_btn3;
    Button action_btn4;
    Button action_btn5;
    Button action_btn6;
    TextView text_first;
    ImageView imgview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        action_btn1 =(Button)findViewById(R.id.wild_btn);
        action_btn2 =(Button)findViewById(R.id.zoo_btn);
        action_btn3 =(Button)findViewById(R.id.action1);
        action_btn4 =(Button)findViewById(R.id.action2);
        action_btn5 =(Button)findViewById(R.id.action3);
        action_btn6 =(Button)findViewById(R.id.action4);
        text_first = (TextView)findViewById(R.id.explan_text);
        imgview = (ImageView)findViewById(R.id.animalImage);
        View.OnClickListener clicker;

        final Monkey monkey = new Monkey(1, "Monkey");

        imgview.setImageResource(R.drawable.wild_monkey);
        clicker = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.wild_btn:
                        text_first.setText("현재 야생 원숭이입니다.."+monkey.type);
                        if(monkey.type  == 2){
                            text_first.setText("야생 원숭이가 되었습니다.");
                            imgview.setImageResource(R.drawable.wild_monkey);
                            monkey.goJungle();
                        }
                        break;
                    case R.id.zoo_btn:
                        text_first.setText("현재 동물원 원숭이입니다."+monkey.type);
                        if(monkey.type ==1 ) {
                            text_first.setText("동물원 원숭이가 되었습니다.");
                            imgview.setImageResource(R.drawable.zoo_monkey);
                            monkey.gotcha();
                        }
                        break;
                    case R.id.action1:
                        text_first.setText(monkey.acrobatic());
                        break;
                    case R.id.action2:
                        text_first.setText(monkey.dance());
                        break;
                    case R.id.action3:
                        text_first.setText(monkey.survive());
                        break;
                    case R.id.action4:
                        text_first.setText(monkey.yowl());
                        break;

                }
            }
        };
        action_btn1.setOnClickListener(clicker);
        action_btn2.setOnClickListener(clicker);
        action_btn3.setOnClickListener(clicker);
        action_btn4.setOnClickListener(clicker);
        action_btn5.setOnClickListener(clicker);
        action_btn6.setOnClickListener(clicker);
    }
}
