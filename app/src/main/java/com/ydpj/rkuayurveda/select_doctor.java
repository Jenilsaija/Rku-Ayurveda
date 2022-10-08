package com.ydpj.rkuayurveda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.jar.Attributes;

public class select_doctor extends AppCompatActivity {

    public TextView doctor1name,doctor2name,doctor3name,doctor4name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor);
        Toolbar tbar=(Toolbar) findViewById(R.id.toolbar);
        doctor1name=(TextView)findViewById(R.id.doctor1name);
        doctor2name=(TextView)findViewById(R.id.doctor2name);
        doctor3name=(TextView)findViewById(R.id.doctor3name);
        doctor4name=(TextView)findViewById(R.id.doctor4name);
        tbar.setTitle("Find A Doctor");
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        doctor1name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctor1=doctor1name.getText().toString().trim();
                gotoDoctordetail(doctor1);
            }
        });
        doctor2name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctor2=doctor2name.getText().toString().trim();
                gotoDoctordetail(doctor2);
            }
        });
        doctor3name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctor3=doctor3name.getText().toString().trim();
                gotoDoctordetail(doctor3);
            }
        });
        doctor4name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctor4=doctor4name.getText().toString().trim();
                gotoDoctordetail(doctor4);
            }
        });
    }

    public void gotoDoctordetail(String Name) {
        Intent i=new Intent(select_doctor.this,Doctor_details.class);
        i.putExtra("doctorname",Name);
        startActivity(i);
    }

}