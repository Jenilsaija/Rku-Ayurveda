package com.ydpj.rkuayurveda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private com.google.android.material.textfield.TextInputEditText Email,Password,cnfpass;
    private FirebaseAuth mauth;
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button regbtn=(Button) findViewById(R.id.regbtn);
        Email=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.Email);
        Password=(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.Psw);
        cnfpass=(com.google.android.material.textfield.TextInputEditText)findViewById(R.id.cnfPsw);
        pb=(ProgressBar)findViewById(R.id.pb1);
        mauth= FirebaseAuth.getInstance();
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
                String email=Email.getText().toString();
                String Pass=Password.getText().toString();
                String cnfpsw= cnfpass.getText().toString();

                if (TextUtils.isEmpty(email) &&TextUtils.isEmpty(Pass)&&TextUtils.isEmpty(cnfpsw) ){
                    Toast.makeText(Register.this, "Please add all details", Toast.LENGTH_SHORT).show();
                }else{
                    mauth.createUserWithEmailAndPassword(email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!Pass.equals(cnfpsw)){
                                Toast.makeText(Register.this, "Please  Check both Passwords", Toast.LENGTH_SHORT).show();
                            }else if (task.isSuccessful()){
                                pb.setVisibility(View.GONE);
                                Toast.makeText(Register.this, "Register Succesfully", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(Register.this,Login.class);
                                startActivity(i);
                                finish();
                            }else{
                                pb.setVisibility(View.GONE);
                                Toast.makeText(Register.this, "Fail to Register", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}