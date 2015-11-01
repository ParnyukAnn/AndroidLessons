package com.aparnyuk.lesson_04;

/**
 * Created by Anna on 01.11.2015.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
