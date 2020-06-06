package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtSo;
    Button btnGiam, btnTang, btnOpen;
    int currentNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSo = (TextView) findViewById(R.id.txtNumber);
        txtSo.setTextColor(Color.parseColor("#A11A1A"));
        btnGiam =   (Button) findViewById(R.id.btnGiam);
        btnTang = (Button) findViewById(R.id.btnTang);
        btnOpen = (Button)findViewById(R.id.btnNext);
        btnGiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String getChuoi = txtSo.getText().toString();
                    currentNumber = Integer.parseInt(getChuoi) -1;
                    txtSo.setText(currentNumber + "");
            }
        });
        btnTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getChuoi = txtSo.getText().toString();
                currentNumber = Integer.parseInt(getChuoi) + 1;
                txtSo.setText(currentNumber + "");
            }
        });
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AgeActivity.class);
                startActivity(i);
            }
        });
    }

    public  boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        return  true;
    }
}
