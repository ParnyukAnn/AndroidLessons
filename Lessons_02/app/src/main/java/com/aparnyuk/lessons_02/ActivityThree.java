package com.aparnyuk.lessons_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class ActivityThree extends AppCompatActivity {
    private String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
            "Blackberry", "Ubuntu", "Windows7", "Mac OS X", "Linux", "Ubuntu", "Windows7",
            "Mac OS X", "Linux", "Ubuntu", "Windows7", "Android", "iPhone", "WindowsMobile"};
    TextView text2;
   // private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        createAndShowNumbers();

        text2 = (TextView) findViewById(R.id.text_2);
        findViewById(R.id.button_1).setOnClickListener(clickListener);
        findViewById(R.id.button_2).setOnClickListener(clickListener);
        findViewById(R.id.button_3).setOnClickListener(clickListener);
        findViewById(R.id.button_4).setOnClickListener(clickListener);
    }

    private void createAndShowNumbers() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
        String strings = TextUtils.join(", ", list);
        TextView text1 = (TextView) findViewById(R.id.text_1);
        text1.setText(strings);
    }

    private void reverseOrder() {
        ArrayList<String> myList = new ArrayList<>();
        /*for (int i = values.length-1; i>=0; i--) {
            myList.add(values[i]);
        }*/
        myList.addAll(Arrays.asList(values));
        Collections.reverse(myList);

        String strings = TextUtils.join(", ", myList);
        text2.setText(strings);
    }

    private void removeEveryThird() {
        LinkedList<String> myList = new LinkedList<>();
        myList.addAll(Arrays.asList(values));
       /* for (int i = 2; i < myList.size(); i = i + 2) {
            myList.remove(i);
        }*/
        Iterator<String> it = myList.iterator();
        int i = 0;
        while(it.hasNext()) {
            it.next();
            if (i==2) {i=0; it.remove();}
            else i++;
        }

        String strings = TextUtils.join(", ", myList);
        text2.setText(strings);
    }

    private void removeDuplicates() {
        LinkedHashSet<String> mySet = new LinkedHashSet<>();
        mySet.addAll(Arrays.asList(values));

        String strings = TextUtils.join(", ", mySet);
        text2.setText(strings);
    }

    private void sortValues() {
        ArrayList<String> myList = new ArrayList<>();
        myList.addAll(Arrays.asList(values));
        Collections.sort(myList);

        String strings = TextUtils.join(", ", myList);
        text2.setText(strings);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          switch (v.getId()) {
                case R.id.button_1:
                    reverseOrder();
                    break;
                case R.id.button_2:
                    removeEveryThird();
                    break;
                case R.id.button_3:
                    removeDuplicates();
                    break;
                case R.id.button_4:
                    sortValues();
                    break;
            }
        }
    };
}