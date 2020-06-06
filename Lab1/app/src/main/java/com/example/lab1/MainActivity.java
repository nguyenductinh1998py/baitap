package com.example.lab1;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtName;
    ProgressBar pgres, pgres1;
    private Handler handler = new Handler();
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (TextView) findViewById(R.id.txtTen);
        pgres = (ProgressBar) findViewById(R.id.progressBar);
        pgres1 = (ProgressBar) findViewById(R.id.progressBar2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i < 100){
                    i +=1;
                    try{
                        Thread.sleep(20);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pgres1.setProgress(i);
                            pgres.setProgress(i);
                            txtName.setText(i+"");
                        }
                    });
                }
            }
        }).start();

    }
}
