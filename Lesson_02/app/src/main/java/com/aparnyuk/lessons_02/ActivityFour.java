package com.aparnyuk.lessons_02;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class ActivityFour extends BaseActivity implements ShowSomething {

    FragmentManager manager;
    NextFragment nextFrag;
    PreviousFragment prevFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nextFrag = new NextFragment();
        prevFrag = new PreviousFragment();
    }

    @Override
    public boolean isAddFragment() {
        return true;
        // return false;
    }

    @Override
    public void addFragment() {
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fragment_container, new MainFragment()).commit();
    }

    @Override
    public String showNext() {
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment2_container, nextFrag).commit();
        return "Next";
    }

    @Override
    public String showPrevious() {
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment2_container, prevFrag).commit();
        return "Previous";
    }
}