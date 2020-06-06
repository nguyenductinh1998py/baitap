package com.example.baitap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button btnReg;
    ImageButton btnCancel;
    EditText edtName, edtBirthday, edtEmail, edtPassword;
    CheckBox checBox;
    ToggleButton tgButton;
    String gender = "", single = "" ;
    Switch swch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        eventChecBox();
        eventToggleBox();
        eventReg();
        envetnSwitch();
    }
    public void eventChecBox(){
        checBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    gender = "male";
                    Toast.makeText(MainActivity.this, "Bạn đã chọn male",Toast.LENGTH_SHORT).show();
                }
                else {
                    gender = "female";
                    Toast.makeText(MainActivity.this, "Bạn đã chọn female",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void eventToggleBox(){
        tgButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    single = "marry";
                    Toast.makeText(MainActivity.this, "Bạn đã chọn marry",Toast.LENGTH_SHORT).show();
                }
                else {
                    single = "single";
                    Toast.makeText(MainActivity.this, "Bạn đã chọn single",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void envetnSwitch(){
        swch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    btnReg.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "switch on", Toast.LENGTH_SHORT).show();
                }
                else {
                    btnReg.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "switch off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void eventReg(){

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this
                        , "Name: "+ edtName.getText() + "\r\n"
                        + "Birthday: " + edtBirthday.getText() + "\r\n"
                        + "Email: "+ edtEmail.getText() + "\r\n"
                          + "Single: "+ single + "\r\n"
                          + "Gender: "+ gender + "\r\n"
                        + "Password: "+ edtPassword.getText()
                        , Toast.LENGTH_LONG).show();
            }
        });
    }
    public void mapping(){
        swch = (Switch) findViewById(R.id.switch1) ;
        btnReg   = (Button) findViewById(R.id.btnReg);
        edtName         =  (EditText) findViewById(R.id.edtName);
        edtBirthday     = (EditText) findViewById(R.id.edtBirthday);
        edtEmail        =  (EditText) findViewById(R.id.edtEmail);
        edtPassword     = (EditText) findViewById(R.id.edtPassword);
        checBox         = (CheckBox) findViewById(R.id.checkBox);
        tgButton        = (ToggleButton) findViewById(R.id.toggleButton);
        btnCancel       = (ImageButton) findViewById(R.id.btnCancel);
    }
}
