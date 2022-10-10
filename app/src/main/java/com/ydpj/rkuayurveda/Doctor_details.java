package com.ydpj.rkuayurveda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Doctor_details extends AppCompatActivity {

    private ImageView doctorimage;
    private TextView doctorname,doctordetails;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        Toolbar tbar=(Toolbar) findViewById(R.id.toolbar);
        tbar.setTitle("Doctor Info");
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        i =getIntent();
        String d_name=i.getExtras().getString("doctor/labtest_name");
        doctorname=(TextView) findViewById(R.id.doctorname);
        doctorimage=(ImageView) findViewById(R.id.doctorimage);
        doctordetails=(TextView) findViewById(R.id.doctordetails);
        switch (d_name) {
            case "Dipa Shivaji Rananavare":
                doctorname.setText(d_name);
                doctorimage.setImageDrawable(getResources().getDrawable(R.drawable.doctor1img));
                doctordetails.setText("Department:\tSamhita - Siddhant (ACH)\n" +
                        "Qualification:\tMD (Ayu.)\n" +
                        "Email:\tdipa.rananavare@rku.ac.in\n" +
                        "Teaching Experience:\t2 Years");
                break;
            case "Bhavin Shashikant Duba":
                doctorname.setText(d_name);
                doctorimage.setImageDrawable(getResources().getDrawable(R.drawable.doctor2img));
                doctordetails.setText("Department : Kriya Sharir (ACH)\n" +
                        "Qualification : MD (Ayu.)\n" +
                        "Email : bhavin.dubal@rku.ac.in\n"+"Teaching Experience : 2.5 year");
                break;
            case "Meera Brijesh Sapariya":
                doctorname.setText(d_name);
                doctorimage.setImageDrawable(getResources().getDrawable(R.drawable.doctor3img));
                doctordetails.setText("Department:\tKayachikitsa (ACH)\n" +
                        "Qualification:\tMD (Ayu.)\n" +
                        "Email:\tmeera.sapariya@rku.ac.in\n" +
                        "Teaching Experience:\t11 Years");
                break;
            case "Rajendra Anandrao Jadhav":
                doctorname.setText(d_name);
                doctorimage.setImageDrawable(getResources().getDrawable(R.drawable.doctor4img));
                doctordetails.setText("Department:\tShalya Tantra (ACH)\n" +
                        "Qualification:\tM.S. Ayurveda (Shalya Tantra)\n" +
                        "Email:\trajendra.jadhav@rku.ac.in\n" +
                        "Teaching Experience:\t9 Years");
                break;
        }
    }

    public void gotoAppoinment(View view) {
        i=getIntent();
        String d_name=i.getExtras().getString("doctor/labtest_name");
        Intent i=new Intent(Doctor_details.this,BookAppoinment.class);
        i.putExtra("doctor/labtest_name",d_name);
        startActivity(i);
    }
}