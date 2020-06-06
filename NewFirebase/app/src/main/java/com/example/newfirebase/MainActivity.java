package com.example.newfirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.xml.sax.helpers.XMLReaderAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mData;
    Button  btnGet;
    ListView lv;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);

        mData = FirebaseDatabase.getInstance().getReference();
        lv.setAdapter(adapter);
        XuLy();
       // AddData();
    }

    private void AddData() {
        SinhVien sinhVien = new SinhVien("Tùy Biện ", "Quận TB", 2020);
        mData.child("SinhVien").push().setValue(sinhVien);
    }

    private void XuLy() {

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mData.child("SinhVien").addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                       SinhVien sinhVien = dataSnapshot.getValue(SinhVien.class);
                       arrayList.add(sinhVien.ten + "-" + sinhVien.namSinh + "-" + sinhVien.diaChi);
                       adapter.notifyDataSetChanged();
                   }

                   @Override
                   public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                   }

                   @Override
                   public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                   }

                   @Override
                   public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
            }
        });
    }

    private void AnhXa() {
        lv = (ListView) findViewById(R.id.listview1);
        btnGet = (Button)findViewById(R.id.btnGetData);

    }
}
