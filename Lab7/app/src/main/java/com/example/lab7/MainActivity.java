package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtvNumber;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtvNumber = (TextView) findViewById(R.id.txtvNumber);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(20000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        txtvNumber.setText("" + millisUntilFinished/1000);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Kết thúc", Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    }
}
