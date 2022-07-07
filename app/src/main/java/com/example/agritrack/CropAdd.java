package com.example.agritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CropAdd extends AppCompatActivity {
    Button addc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_add);
        addc = findViewById(R.id.addC);
        addc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(CropAdd.this, Homepage.class);
                startActivity(home);
            }
        });
    }
}