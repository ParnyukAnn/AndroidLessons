package com.aparnyuk.lessons_02;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentMain extends Fragment implements View.OnClickListener {

    Button btnLes1;
    Button btnLes2;
    Button btnLes3;
    Button btnLes4;
    Button btnLes5;
    Button btnLes6;

    OnSelectedButtonListener listener;

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        btnLes1 = (Button) rootView.findViewById(R.id.btn_show_les_1);
        btnLes2 = (Button) rootView.findViewById(R.id.btn_show_les_2);
        btnLes3 = (Button) rootView.findViewById(R.id.btn_show_les_3);
        btnLes4 = (Button) rootView.findViewById(R.id.btn_show_les_4);
        btnLes5 = (Button) rootView.findViewById(R.id.btn_show_les_5);
        btnLes6 = (Button) rootView.findViewById(R.id.btn_show_les_6);
        btnLes1.setOnClickListener(this);
        btnLes2.setOnClickListener(this);
        btnLes3.setOnClickListener(this);
        btnLes4.setOnClickListener(this);
        btnLes5.setOnClickListener(this);
        btnLes6.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnSelectedButtonListener) getActivity();
    }

    @Override
    public void onClick(View view) {
        int buttonIndex = translateIdToIndex(view.getId());
        listener.onButtonSelected(buttonIndex);
    }

    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.btn_show_les_1:
                index = 1;
                break;
            case R.id.btn_show_les_2:
                index = 2;
                break;
            case R.id.btn_show_les_3:
                index = 3;
                break;
            case R.id.btn_show_les_4:
                index = 4;
                break;
            case R.id.btn_show_les_5:
                index = 5;
                break;
            case R.id.btn_show_les_6:
                index = 6;
                break;
        }
        return index;
    }
}
