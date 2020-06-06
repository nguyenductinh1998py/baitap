package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnChange;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChange = (Button) findViewById(R.id.btnchangeimg);
        imgView = (ImageView) findViewById(R.id.imgView);
        imgView.setBackgroundResource(R.mipmap.anh1);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setBackgroundResource(R.mipmap.anh2);
            }
        });
    }
}
