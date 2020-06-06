package com.example.qunldanhb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText edtName , edtPhone;
    ArrayList<DanhBa> arrayList;
    AdapterDanhBa adapterDanhBa;

    RadioButton rdoNam , rdoNu;
    Button btnThem, btnSua, btnXoa;
    int vitri= -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        xuLy();
        adapterDanhBa = new AdapterDanhBa(this, R.layout.danh_ba, arrayList);
        listView.setAdapter(adapterDanhBa);

    }

    private void xuLy() {
        arrayList = new ArrayList<>();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rdoNam.isChecked()){
                    arrayList.add(new DanhBa(edtName.getText().toString(),edtPhone.getText().toString(),R.drawable.male));
                    adapterDanhBa.notifyDataSetChanged();
                }
                if (rdoNu.isChecked()){
                    arrayList.add(new DanhBa(edtName.getText().toString(),edtPhone.getText().toString(),R.drawable.female));
                    adapterDanhBa.notifyDataSetChanged();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                edtName.setText(arrayList.get(position).getTen());
                edtPhone.setText(arrayList.get(position).getSdt());
                vitri = position;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.size() >=1)
                {
                    if (rdoNam.isChecked())
                        arrayList.set(vitri, new DanhBa(edtName.getText().toString(),edtPhone.getText().toString(),R.drawable.male));
                    if (rdoNu.isChecked())
                        arrayList.set(vitri, new DanhBa(edtName.getText().toString(),edtPhone.getText().toString(),R.drawable.female));
                    adapterDanhBa.notifyDataSetChanged();

                }

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.size() >= 1)
                {
                    AlertDialog.Builder alerDialog = new AlertDialog.Builder(MainActivity.this);
                    alerDialog.setTitle("Thông báo");
                    alerDialog.setIcon(R.mipmap.ic_launcher);
                    alerDialog.setMessage("Bạn thật sự muốn xóa " + arrayList.get(vitri).getTen() + "?");
                    alerDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            arrayList.remove(vitri);
                            adapterDanhBa.notifyDataSetChanged();
                        }
                    });
                    alerDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alerDialog.show();
                }

            }
        });
    }

    private void anhXa() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        btnThem = (Button) findViewById(R.id.btnThem);
        rdoNam = (RadioButton) findViewById(R.id.rdoNam);
        rdoNu = (RadioButton) findViewById(R.id.rdoNu);
        listView = (ListView) findViewById(R.id.listView1);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnSua = (Button) findViewById(R.id.btnSua);

    }

}
