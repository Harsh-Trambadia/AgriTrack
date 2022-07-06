package com.example.agritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FarmAdd extends AppCompatActivity {
    Button addF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_add);

        addF = findViewById(R.id.addF);
        addF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FarmAdd.this, "Farm Added Successfully", Toast.LENGTH_SHORT).show();
                Intent far = new Intent(FarmAdd.this, Homepage.class);
                startActivity(far);
            }
        });
    }
}