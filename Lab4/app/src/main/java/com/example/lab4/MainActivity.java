package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView notice;
    EditText name, year;
    Button btnCal;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCal = (Button) findViewById(R.id.btnCal);

        name = (EditText) findViewById(R.id.inputName);
        year =  (EditText) findViewById(R.id.inputYear);
        notice = (TextView) findViewById(R.id.textView3);
        notice.setTextColor(Color.BLUE);
        notice.setTextSize(24);
        getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a;
                String getChuoi = year.getText().toString();
                a = Integer.parseInt(getChuoi);
                age = Calendar.getInstance().get(Calendar.YEAR) - a;
                notice.setText("Ban " + name.getText() + ' ' + age + " Tuoi");
            }
        });

    }
}
