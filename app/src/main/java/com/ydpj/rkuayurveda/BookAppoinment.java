package com.ydpj.rkuayurveda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BookAppoinment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appoinment);
        Toolbar tbar=(Toolbar) findViewById(R.id.toolbar);
        tbar.setTitle("Book Appoinment");
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void bookgotohome(View view) {
        Intent i = new Intent(BookAppoinment.this,Main.class);
        startActivity(i);
    }
}