package com.example.agritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(this, "Tap anywhere to continue", Toast.LENGTH_SHORT);
        toast.show();

        ib = findViewById(R.id.imageButton3);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Homepage.class);
                startActivity(intent);
            }


        });

    }

    public void openActivity(View view){


    }




}