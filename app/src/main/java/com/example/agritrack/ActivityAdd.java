package com.example.agritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityAdd extends AppCompatActivity {
    Spinner activity, farm, crop;
    Button actadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        activity = findViewById(R.id.activity);
        farm = findViewById(R.id.SFarm);
        crop = findViewById(R.id.SCrop);
        actadd = findViewById(R.id.add);

        ArrayList<String> activityList = new ArrayList<>();
        activityList.add("JAVA");
        activityList.add("ANDROID");
        activityList.add("C Language");
        activityList.add("CPP Language");
        activityList.add("Go Language");
        activityList.add("AVN SYSTEMS");
        ArrayAdapter<String> actAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, activityList);
        actAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activity.setAdapter(actAd);

        ArrayList<String> farmList = new ArrayList<>();
        farmList.add("JAVA");
        farmList.add("ANDROID");
        farmList.add("C Language");
        farmList.add("CPP Language");
        farmList.add("Go Language");
        farmList.add("AVN SYSTEMS");
        ArrayAdapter<String> farmAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, farmList);
        farmAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        farm.setAdapter(farmAd);

        ArrayList<String> cropList = new ArrayList<>();
        cropList.add("JAVA");
        cropList.add("ANDROID");
        cropList.add("C Language");
        cropList.add("CPP Language");
        cropList.add("Go Language");
        cropList.add("AVN SYSTEMS");
        ArrayAdapter<String> cropAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cropList);
        cropAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(cropAd);

        actadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityAdd.this, "Activity Added Successfully", Toast.LENGTH_SHORT).show();
                Intent act = new Intent(ActivityAdd.this, Homepage.class);
                startActivity(act);
            }
        });
    }
}