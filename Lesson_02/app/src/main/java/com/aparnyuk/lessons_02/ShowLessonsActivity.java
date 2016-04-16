package com.aparnyuk.lessons_02;

import android.content.res.Configuration;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class ShowLessonsActivity extends AppCompatActivity {
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lessons);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        int buttonIndex = getIntent().getIntExtra("les_num",0);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE && isLarge()) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
          //  int buttonIndex = getIntent().getIntExtra("les_num",0);

            Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
            manager = getSupportFragmentManager();
            switch (buttonIndex) {
                case 1:
                    manager.beginTransaction().add(R.id.container_in_show_lessons, new FragmentLesson1()).commit();
                   // toolbar.setTitle("1");
                    break;
                case 2:
                    manager.beginTransaction().add(R.id.container_in_show_lessons, new FragmentLesson2()).commit();
                    break;
                case 3:
                    manager.beginTransaction().add(R.id.container_in_show_lessons, new FragmentLesson3()).commit();
                    break;
                case 4:

                    break;
                case 5:
                    manager.beginTransaction().add(R.id.container_in_show_lessons, new FragmentLesson5()).commit();
                    break;
                case 6:
                    manager.beginTransaction().add(R.id.container_in_show_lessons, new FragmentLesson6()).commit();
                   break;
                default:
                    break;
            }
        }
        else {
            Toast.makeText(this,"replace", Toast.LENGTH_SHORT).show();
            manager = getSupportFragmentManager();
            switch (buttonIndex) {
                case 1:
                    manager.beginTransaction().replace(R.id.container_in_show_lessons, new FragmentLesson1()).commit();
                    break;
                case 2:
                    manager.beginTransaction().replace(R.id.container_in_show_lessons, new FragmentLesson2()).commit();
                    break;
                case 3:
                    manager.beginTransaction().replace(R.id.container_in_show_lessons, new FragmentLesson3()).commit();
                    break;
                case 4:

                    break;
                case 5:
                    manager.beginTransaction().replace(R.id.container_in_show_lessons, new FragmentLesson5()).commit();
                    break;
             case 6:
                    manager.beginTransaction().replace(R.id.container_in_show_lessons, new FragmentLesson6()).commit();
                    break;
                default:
                    break;
            }
        }
    }

    boolean isLarge() {
        return (getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

}
