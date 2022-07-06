package com.example.agritrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homepage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
    Home home = new Home();
    Farm farm = new Farm();
    Crop crop = new Crop();
    Expense expense = new Expense();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, home).commit();
                return true;

            case R.id.farm:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, farm).commit();
                return true;

            case R.id.crop:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, crop).commit();
                return true;

            case R.id.expense:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, expense).commit();
                return true;
        }
        return false;
    }
}