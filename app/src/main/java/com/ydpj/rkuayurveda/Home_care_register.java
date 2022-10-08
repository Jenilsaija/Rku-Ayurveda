package com.ydpj.rkuayurveda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home_care_register extends AppCompatActivity {

    private  com.google.android.material.textfield.TextInputEditText etname,etdesses,etemail,etphonenum,etaddress,etnoofday;

    private Button btnhcreg;
    private FirebaseDatabase database;
    private DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_care_register);
        Toolbar tbar=(Toolbar) findViewById(R.id.toolbar);
        btnhcreg=(Button)findViewById(R.id.btnhcreg);
        etname =(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etname);
        etdesses =(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etdesses);
        etemail =(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etemail);
        etphonenum =(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etphonenum);
        etaddress =(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etaddress);
        etnoofday =(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.etnoofday);
        database=FirebaseDatabase.getInstance();
        tbar.setTitle("Home Care");
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnhcreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etname.getText().toString();
                String desses=etdesses.getText().toString();
                String email=etemail.getText().toString();
                String phonenum=etphonenum.getText().toString();
                String address=etaddress.getText().toString();
                String noofday=etnoofday.getText().toString();

                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(desses)||TextUtils.isEmpty(email)||TextUtils.isEmpty(phonenum)||TextUtils.isEmpty(address)||TextUtils.isEmpty(noofday)){
                    Toast.makeText(Home_care_register.this, "Please Fill Up All Details", Toast.LENGTH_SHORT).show();
                }else {
                    myref = database.getReference("HomeCareRegistration");
                    String id=myref.push().getKey();
                    FirebaseAuth mauth= FirebaseAuth.getInstance();
                    FirebaseUser currentUser = mauth.getCurrentUser();
                    myref.child(id).child("User").setValue(currentUser.getEmail().toString());
                    myref.child(id).child("etName").setValue(name);
                    myref.child(id).child("etdesses").setValue(desses);
                    myref.child(id).child("etemail").setValue(email);
                    myref.child(id).child("etphonenum").setValue(phonenum);
                    myref.child(id).child("etaddress").setValue(address);
                    myref.child(id).child("etnoofday").setValue(noofday);
                    Toast.makeText(Home_care_register.this, "Successfully home care registration", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Home_care_register.this, Main.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
