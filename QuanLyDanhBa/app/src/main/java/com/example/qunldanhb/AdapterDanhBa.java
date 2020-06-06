package com.example.qunldanhb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterDanhBa extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DanhBa> list;
    public AdapterDanhBa(Context context, int layout, List<DanhBa> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        DanhBa danhBa = list.get(position);
        txtName.setText(danhBa.getTen());
        txtPhone.setText(danhBa.getSdt());
        imageView.setImageResource(danhBa.getHinh());
        return convertView;
    }
}
