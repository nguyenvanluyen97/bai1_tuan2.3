package com.example.asus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtMaNV,edtTenNV;
    private Button btnNhap,btnXoa;
    private ImageButton btnImg;

    private RadioGroup radGroup;

    private ListView lvNV;

    private ArrayList<NhanVien> arrNhanVien=null;
    private MyArrayAdapter adapter=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
        setEventClicksView();

        arrNhanVien=new ArrayList<NhanVien>();
        adapter=new MyArrayAdapter(this,R.layout.my_item_layout,arrNhanVien);
        lvNV.setAdapter(adapter);
    }

    public void initWidget()
    {
        edtMaNV=(EditText)findViewById(R.id.edtMaNV);
        edtTenNV=(EditText)findViewById(R.id.edtTenNV);
        btnNhap=(Button)findViewById((R.id.btnNhap));
        radGroup=(RadioGroup)findViewById(R.id.radioGroup);
        lvNV=(ListView)findViewById((R.id.lvNV));
        btnXoa=(Button)findViewById(R.id.btnXoa);
        btnImg=(ImageButton)findViewById(R.id.imgButton);
    }

    public void setEventClicksView(){
        btnNhap.setOnClickListener(this);
        btnXoa.setOnClickListener(this);
        btnImg.setOnClickListener(this);
    }

    public void xulynhap()
    {
        String ma=edtMaNV.getText().toString();
        String ten=edtTenNV.getText().toString();
        boolean gioitinh=false;

        if(radGroup.getCheckedRadioButtonId()==R.id.radNu)
        {
            gioitinh=true;
        }
        NhanVien nv=new NhanVien();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gioitinh);

        arrNhanVien.add(nv);

        adapter.notifyDataSetChanged();

        edtMaNV.setText("");
        edtTenNV.setText("");
        edtMaNV.requestFocus();
    }

    public void xulyxoa(){
        for(int i=lvNV.getChildCount()-1;i>=0;i--)
        {
            View v=lvNV.getChildAt(i);
            CheckBox chk=(CheckBox)v.findViewById(R.id.ckb_item);
            if(chk.isChecked())
            {
                arrNhanVien.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void xulychon()
    {
        Toast.makeText(MainActivity.this, "Chức năng đang xây dựng", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnNhap:
                xulynhap();
                break;
            case R.id.btnXoa:
                xulyxoa();
                break;
            case R.id.imgButton:
                xulychon();
                break;
                default:
                    break;
        }
    }
}
