package com.ydpj.rkuayurveda;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import com.ydpj.rkuayurveda.ui.home.HomeFragment;

public class BookAppoinment extends AppCompatActivity {

    private com.google.android.material.textfield.TextInputEditText etDoctor,etname,etphonenum,etDate,etaddress,etAge;
    private Spinner spinnergender;
    private Button btnBook;
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private com.google.android.material.progressindicator.LinearProgressIndicator pb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appoinment);
        Toolbar tbar=(Toolbar) findViewById(R.id.toolbar);
        btnBook=(Button)findViewById(R.id.btnbook);
        pb1=(com.google.android.material.progressindicator.LinearProgressIndicator)findViewById(R.id.pb1);
        etDoctor=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etDoctor);
        etname=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etname);
        etphonenum=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etphonenum);
        etDate=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etDate);
        etaddress=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etaddress);
        etAge=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etAge);
        spinnergender=(Spinner) findViewById(R.id.spinnergender);
        database=FirebaseDatabase.getInstance();

        tbar.setTitle("Book Appoinment");
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.setVisibility(View.VISIBLE);
                String d_name=etDoctor.getText().toString();
                String name=etname.getText().toString();
                String Phonenum=etphonenum.getText().toString();
                String Date=etDate.getText().toString();
                String address=etaddress.getText().toString();
                String age=etAge.getText().toString();
                String gender=spinnergender.getSelectedItem().toString();

                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(Phonenum)||TextUtils.isEmpty(Date)||TextUtils.isEmpty(address)||TextUtils.isEmpty(age)){
                    pb1.setVisibility(View.GONE);
                    Toast.makeText(BookAppoinment.this, "Please Fill Up All Details", Toast.LENGTH_SHORT).show();
                }else {
                    myref = database.getReference("Appoinment");
                    String id=myref.push().getKey();
                    FirebaseAuth mauth= FirebaseAuth.getInstance();
                    FirebaseUser currentUser = mauth.getCurrentUser();
                    myref.child(id).child("User").setValue(currentUser.getEmail().toString());
                    myref.child(id).child("Doctor/Test").setValue(d_name);
                    myref.child(id).child("Status").setValue("Pending");
                    myref.child(id).child("etName").setValue(name);
                    myref.child(id).child("etphonenum").setValue(Phonenum);
                    myref.child(id).child("etDate").setValue(Date);
                    myref.child(id).child("etaddress").setValue(address);
                    myref.child(id).child("etAge").setValue(age);
                    myref.child(id).child("Gender").setValue(gender);
                    pb1.setVisibility(View.GONE);
                    Toast.makeText(BookAppoinment.this, "Succesfully Book Appoinment", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(BookAppoinment.this, Main.class);
                    startActivity(i);
                    finish();
                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i =getIntent();
        String d_name=i.getExtras().getString("doctor/labtest_name");
        etDoctor=(com.google.android.material.textfield.TextInputEditText) findViewById(R.id.etDoctor);
        etDoctor.setText(d_name);
    }
}