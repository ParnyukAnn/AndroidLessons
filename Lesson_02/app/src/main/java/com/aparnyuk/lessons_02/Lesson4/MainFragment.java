package com.aparnyuk.lessons_02.Lesson4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aparnyuk.lessons_02.Lesson4.ShowSomething;
import com.aparnyuk.lessons_02.R;

public class MainFragment extends Fragment implements View.OnClickListener{

    private Button btnNext;
    private Button btnPrevious;
    private TextView showResult;



    private ShowSomething myInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            myInterface = (ShowSomething) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString() + " Must implement ShowSomething Interface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true); // Сохранить фрагмент при повороте и присвоить его новой активности
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnPrevious = (Button) view.findViewById(R.id.btn_previous);
        showResult = (TextView) view.findViewById(R.id.show_result);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                showResult.setText(myInterface.showNext());
                break;
            case R.id.btn_previous:
                showResult.setText(myInterface.showPrevious());
                break;
            default:
                break;
        }

    }
}