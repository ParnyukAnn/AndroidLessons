package com.aparnyuk.lessons_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {
    TextView resFactorial;
    TextView resFibonacci;
    Button btnFactorial;
    Button btnFibonacci;
    EditText inputFactorial;
    EditText inputFibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btnFactorial = (Button) findViewById(R.id.btnFact);
        btnFibonacci = (Button) findViewById(R.id.btnFib);
        inputFactorial = (EditText) findViewById(R.id.editFact);
        inputFibonacci = (EditText) findViewById(R.id.editFib);
        resFactorial = (TextView) findViewById(R.id.resFact);
        resFibonacci = (TextView) findViewById(R.id.resFib);

        btnFactorial.setOnClickListener(this);
        btnFibonacci.setOnClickListener(this);

    }
// добавить try catch или проверка от неправильных результатов

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
