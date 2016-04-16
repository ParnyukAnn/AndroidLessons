package com.aparnyuk.lessons_02;


import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class FragmentLesson2 extends Fragment implements View.OnClickListener {
    TextView resFactorial;
    TextView resFibonacci;
    Button btnFactorial;
    Button btnFibonacci;
    EditText inputFactorial;
    EditText inputFibonacci;


    final String LOG_TAG = "myLogs";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment2 onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Fragment2 onCreateView");
        return inflater.inflate(R.layout.fragment_lesson2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG_TAG, "Fragment2 onViewCreated");

        btnFactorial = (Button) getActivity().findViewById(R.id.btnFact);
        btnFibonacci = (Button) getActivity().findViewById(R.id.btnFib);
        inputFactorial = (EditText) getActivity().findViewById(R.id.editFact);
        inputFibonacci = (EditText) getActivity().findViewById(R.id.editFib);
        resFactorial = (TextView) getActivity().findViewById(R.id.resFact);
        resFibonacci = (TextView) getActivity().findViewById(R.id.resFib);

        btnFactorial.setOnClickListener(this);
        btnFibonacci.setOnClickListener(this);
        /*
try {
    btnFactorial.setOnClickListener(this);
    btnFibonacci.setOnClickListener(this);
    Log.d(LOG_TAG, "Fragment1 onViewCreated 2");
}catch (Exception e){
    Log.d(LOG_TAG, "Error: "+e);
}
*/
    }


    @Override
    public void onClick(View v) {
        int num;
        String inpNum;

        switch (v.getId()) {
            case R.id.btnFact:
                inpNum = inputFactorial.getText().toString();
                if (!(inpNum.equals(""))) {
                    num = Integer.parseInt(inpNum);
                    resFactorial.setText("Result: " + String.valueOf(myFactorial(num)));
                }
                break;
            case R.id.btnFib:
                inpNum = inputFibonacci.getText().toString();
                if (!(inpNum.equals(""))) {
                    num = Integer.parseInt(inpNum);
                    resFibonacci.setText("Result: " + String.valueOf(myFibonacci(num)));
                }
                break;
            default:
                break;
        }

    }
    /*   public static long myFactorial(int n) {
           long fact = 1;
           for (int i = 1; i <= n; i++)
               fact = fact * i;
           return fact;
       }

       public static long myFibonacci(int n) {
           int f1 = 1, f2 = 1, temp = 0;
           if (n!=0) {
           for (int i = 1; i < n; i++) {
               temp = f1 + f2;
               f1 = f2;
               f2 = temp;
           }
           return f1;
           }
           else return temp;
       }
      */
    public static BigInteger myFactorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static BigInteger myFibonacci(int n) {
        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        BigInteger temp = BigInteger.ZERO;
        if (n != 0) {
            for (int i = 1; i < n; i++) {
                temp = f1.add(f2);
                f1 = f2;
                f2 = temp;
            }
            return f1;
        } else return temp;
    }

}
