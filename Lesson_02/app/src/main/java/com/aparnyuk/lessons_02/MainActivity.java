package com.aparnyuk.lessons_02;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aparnyuk.lessons_02.Lesson4.ActivityFour;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentMain.OnSelectedButtonListener {
    FragmentManager manager;
    private boolean noFragment;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (findViewById(R.id.container_in_main_activity_2) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }


        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.container_in_main_activity_1, new FragmentMain()).commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.toolbar_item1:
                this.showLessons(1);
                return true;
            case R.id.toolbar_item2:
                this.showLessons(2);
                return true;
            case R.id.toolbar_item3:
                this.showLessons(3);
                return true;
            case R.id.toolbar_item4:
                this.showLessons(4);
                return true;
            case R.id.toolbar_item5:
                this.showLessons(5);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
      switch (item.getItemId()) {
            case R.id.nav_item1:
                this.showLessons(1);
                break;
            case R.id.nav_item2:
                this.showLessons(2);
                break;
            case R.id.nav_item3:
                this.showLessons(3);
                break;
            case R.id.nav_item4:
                this.showLessons(4);
                break;
            case R.id.nav_item5:
                this.showLessons(5);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showLessons(int buttonIndex) {
        if (mTwoPane) {
      //      Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            manager = getSupportFragmentManager();
            switch (buttonIndex) {
                case 1:
                    manager.beginTransaction().replace(R.id.container_in_main_activity_2, new FragmentLesson1()).commit();
                    break;
                case 2:
                    manager.beginTransaction().replace(R.id.container_in_main_activity_2, new FragmentLesson2()).commit();
                    break;
                case 3:
                    manager.beginTransaction().replace(R.id.container_in_main_activity_2, new FragmentLesson3()).commit();
                    break;
                case 4:

                    break;
                case 5:
                    manager.beginTransaction().replace(R.id.container_in_main_activity_2, new FragmentLesson5()).commit();
                    break;
                default:
                    break;
            }

        }
        else
        {
            Intent intent = new Intent(this, ShowLessonsActivity.class);
            intent.putExtra("les_num", buttonIndex);
            startActivity(intent);
        }
   /*     if (buttonIndex==4){
            Intent intent = new Intent(this, ActivityFour.class);
            startActivity(intent);
        }*/
    }

    @Override
    public void onButtonSelected(int buttonIndex) {
            switch (buttonIndex) {
                case 1:
                    this.showLessons(buttonIndex);
                    break;
                case 2:
                    this.showLessons(buttonIndex);
                    break;
                case 3:
                    this.showLessons(buttonIndex);
                    break;
                case 4:
                    this.showLessons(buttonIndex);
                    break;
                case 5:
                    this.showLessons(buttonIndex);
                    break;
                default:
                    break;
            }
    }
}
