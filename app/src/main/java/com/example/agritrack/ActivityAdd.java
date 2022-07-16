package com.example.agritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityAdd extends AppCompatActivity {
    Spinner activity, farm, crop;
    Button actadd;
    DbHandler db;
    EditText Fdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        activity = findViewById(R.id.activity);
        farm = findViewById(R.id.SFarm);
        crop = findViewById(R.id.SCrop);
        actadd = findViewById(R.id.add);
        Fdate = findViewById(R.id.Fdate);
        db = new DbHandler(this);

        ArrayList<String> fn, cn;

        fn = db.getFarmName();
        cn = db.getCropName();

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

        ArrayAdapter<String> farmAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, fn);
        farmAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        farm.setAdapter(farmAd);

        ArrayAdapter<String> cropAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cn);
        cropAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(cropAd);

        actadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actN = activity.getSelectedItem().toString();
                String f = farm.getSelectedItem().toString();
                String c = crop.getSelectedItem().toString();
                String date = Fdate.getText().toString();

                db.addActivity(new ActivityShow(1, actN, f, c, date));
                Toast.makeText(ActivityAdd.this, "Activity Added Successfully", Toast.LENGTH_SHORT).show();
                Intent act = new Intent(ActivityAdd.this, Homepage.class);
                startActivity(act);
            }
        });
    }
}