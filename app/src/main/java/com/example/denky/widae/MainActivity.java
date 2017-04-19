package com.example.denky.widae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by denky on 2017-04-14.
 */

public class MainActivity extends AppCompatActivity {
    Button action_btn1;
    Button action_btn2;
    String data;
    TextView myanimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myanimal = (TextView)findViewById(R.id.yourAnimal);
        try {
            Intent i = getIntent();
             data = i.getStringExtra("animal");
            if(data == null || data.length()<4 ){
                myanimal.setText("Your have no animal");
                data="";
            }
            else {
                myanimal.setText("Your animal : "+data);
            }
        }catch (Exception e){

        }
            action_btn1 =(Button)findViewById(R.id.toWild_btn);
        action_btn2 =(Button)findViewById(R.id.toZoo_btn);
        action_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WildActivity.class);
                startActivity(i);
            }
        });
        action_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("animal", data);
                startActivity(i);
                finish();
            }
        });
    }
}
