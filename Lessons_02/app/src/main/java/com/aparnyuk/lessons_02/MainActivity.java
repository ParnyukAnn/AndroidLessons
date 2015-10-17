package com.aparnyuk.lessons_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.lesson1);
        btn2 = (Button) findViewById(R.id.lesson2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lesson1:
                Intent intent1 = new Intent(this, ActivityOne.class);
                startActivity(intent1);
                break;
            case R.id.lesson2:
                Intent intent2 = new Intent(this, ActivityTwo.class);
                startActivity(intent2);
                break;
            default:
                break;

        }
    }
}
