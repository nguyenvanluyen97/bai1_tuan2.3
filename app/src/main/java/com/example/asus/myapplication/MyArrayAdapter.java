package com.example.asus.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien>{
    Activity context=null;
    ArrayList<NhanVien> myArray=null;
    int layoutId;

    public MyArrayAdapter(Activity context, int texViewResourceId,ArrayList<NhanVien> objects){
        super(context,texViewResourceId,objects);
        this.context=context;
        this.layoutId=texViewResourceId;
        this.myArray=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        convertView =inflater.inflate(layoutId,null);

        if(myArray.size()>0 && position>=0)
        {
            final TextView txtDisplay=(TextView)convertView.findViewById(R.id.tv_item);
            final NhanVien nv=myArray.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imgitem =(ImageView)convertView.findViewById(R.id.img_item);
            if(nv.isGender())
            {
                imgitem.setImageResource(R.drawable.girl);
            }
            else
            {
                imgitem.setImageResource((R.drawable.boy));
            }
        }
        return convertView;
    }
}
