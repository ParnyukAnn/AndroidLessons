package com.aparnyuk.lessons_02.Lesson4;

/**
 * Created by Anna on 02.11.2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aparnyuk.lessons_02.R;

public class  PreviousFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.previous_fragment, container, false);
    }
}