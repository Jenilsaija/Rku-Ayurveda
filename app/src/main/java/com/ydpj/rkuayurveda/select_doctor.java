package com.ydpj.rkuayurveda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class select_doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor);
        Toolbar tbar=(Toolbar) findViewById(R.id.toolbar);
        tbar.setTitle("Find A Doctor");
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void gotoDoctordetail(View view) {
        Intent i=new Intent(select_doctor.this,Doctor_details.class);
        startActivity(i);
    }
}