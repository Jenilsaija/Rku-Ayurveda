package com.ydpj.rkuayurveda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private FirebaseAuth mauth;
    private com.google.android.material.textfield.TextInputEditText Email,Psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginbtn=(Button)findViewById(R.id.loginbtn);
        TextView Registerlink=(TextView)findViewById(R.id.register);
        ProgressBar pb=(ProgressBar)findViewById(R.id.pb1);
        Email=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.Email);
        Psw=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.Psw);
        mauth=FirebaseAuth.getInstance();
        Registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Login.this,Register.class);
                startActivity(i);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
                String email=Email.getText().toString();
                String Pass=Psw.getText().toString();
                if (TextUtils.isEmpty(email) &&TextUtils.isEmpty(Pass)){
                    Toast.makeText(Login.this, "Please add all details", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    mauth.signInWithEmailAndPassword(email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                pb.setVisibility(view.GONE);
                                FirebaseUser user = mauth.getCurrentUser();
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(Login.this,Main.class);
                                startActivity(i);
                                finish();
                            }else {
                                pb.setVisibility((View.GONE));
                                Toast.makeText(Login.this, "Login Fail", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mauth=FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mauth.getCurrentUser();
        if(currentUser != null){
            Intent i=new Intent(Login.this,Main.class);
            startActivity(i);
            finish();
        }
    }
}