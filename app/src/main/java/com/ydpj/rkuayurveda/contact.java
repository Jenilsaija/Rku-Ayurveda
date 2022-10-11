package com.ydpj.rkuayurveda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class contact extends AppCompatActivity {
    private com.google.android.material.textfield.TextInputEditText ctname,ctmail,ctnum,ctmsg;
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private Button btnsend;
    private com.google.android.material.progressindicator.LinearProgressIndicator pb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        pb1=(com.google.android.material.progressindicator.LinearProgressIndicator)findViewById(R.id.pb1);
        btnsend=(Button)findViewById(R.id.btnsend);
        Toolbar tbar=(Toolbar) findViewById(R.id.toolbar);
        tbar.setTitle("Contact Us");
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb1.setVisibility(View.VISIBLE);
                ctname=(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.ctname);
                ctmail=(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.ctmail);
                ctnum=(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.ctnum);
                ctmsg=(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.ctmsg);
                String name=ctname.getText().toString();
                String Email=ctmail.getText().toString();
                String Num=ctnum.getText().toString();
                String Msg=ctmsg.getText().toString();
                database=FirebaseDatabase.getInstance();

                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(Email)||TextUtils.isEmpty(Num)||TextUtils.isEmpty(Msg)){
                    pb1.setVisibility(View.GONE);
                    Toast.makeText(contact.this, "Please Fill Up All Details", Toast.LENGTH_SHORT).show();
                }else {
                    myref = database.getReference("Contact");
                    String id=myref.push().getKey();
                    myref.child(id).child("ct_name").setValue(name);
                    myref.child(id).child("ct_Mail").setValue(Email);
                    myref.child(id).child("ct_Number").setValue(Num);
                    myref.child(id).child("ct_mesage").setValue(Msg);
                    pb1.setVisibility(View.GONE);
                    Toast.makeText(contact.this, "Successfully Send Meaasage", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(contact.this,Main.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}