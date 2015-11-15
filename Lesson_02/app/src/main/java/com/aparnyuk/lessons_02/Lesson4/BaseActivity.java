package com.aparnyuk.lessons_02.Lesson4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aparnyuk.lessons_02.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        if ((isAddFragment()) && (savedInstanceState == null)){// приложение запущено впервые
            addFragment();
        }
    }

    public abstract boolean isAddFragment();

    public abstract void addFragment();
}
