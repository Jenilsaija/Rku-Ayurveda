package com.ydpj.rkuayurveda;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.ydpj.rkuayurveda.databinding.ActivityMainBinding;
import com.ydpj.rkuayurveda.ui.About;
import com.ydpj.rkuayurveda.ui.AboutViewModel;

public class Main extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_about)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void gotohomecare(View view) {
        Intent i = new Intent(Main.this,Home_care_register.class);
        startActivity(i);
    }

    public void gotocontact(View view) {
        Intent i=new Intent(Main.this,contact.class);
        startActivity(i);
    }

    public void logout(MenuItem item) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Main.this,Login.class);
        startActivity(i);
        finish();
    }

    public void gotolabtest(View view) {
        Intent i=new Intent(Main.this,Labtest.class);
        startActivity(i);
    }

    public void gotodoctor(View view) {
        Intent i =new Intent(Main.this,select_doctor.class);
        startActivity(i);
    }

    public void gotoreports(View view) {
        Intent i= new Intent(Main.this,Reports.class);
        startActivity(i);
    }

    public void gotoAboutus(View view) {
        Intent i= new Intent(Main.this, About_us.class);
        startActivity(i);
    }
}