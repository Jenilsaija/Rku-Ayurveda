package com.ydpj.rkuayurveda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Labtest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtest);
        Toolbar tbar=(Toolbar) findViewById(R.id.toolbar);
        tbar.setTitle("Lab Test");
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void gotoAppoinmentasBG(View view) {
        Intent i=new Intent(Labtest.this,BookAppoinment.class);
        i.putExtra("doctor/labtest_name","Blood Test");
        startActivity(i);
    }

    public void gotoAppoinmentasET(View view) {
        Intent i=new Intent(Labtest.this,BookAppoinment.class);
        i.putExtra("doctor/labtest_name","ESR Test");
        startActivity(i);
    }

    public void gotoAppoinmentasBS(View view) {
        Intent i=new Intent(Labtest.this,BookAppoinment.class);
        i.putExtra("doctor/labtest_name","Sugar Test");
        startActivity(i);
    }

    public void gotoAppoinmentasHT(View view) {
        Intent i=new Intent(Labtest.this,BookAppoinment.class);
        i.putExtra("doctor/labtest_name","HIV Test");
        startActivity(i);
    }
}