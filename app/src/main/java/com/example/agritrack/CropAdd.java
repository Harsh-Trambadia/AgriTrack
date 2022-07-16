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

public class CropAdd extends AppCompatActivity {
    Button addc;
    DbHandler db;
    ArrayList<String> Fname;
    Spinner farms;
    EditText edCrop, datef, datet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_add);
        db = new DbHandler(this);
        addc = findViewById(R.id.addC);
        farms = findViewById(R.id.farms);
        edCrop = findViewById(R.id.edCrop);
        datef = findViewById(R.id.datef);
        datet = findViewById(R.id.datet);

        Fname = db.getFarmName();

        ArrayAdapter<String> fAd = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, Fname);
        fAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        farms.setAdapter(fAd);

        addc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edCrop.getText()!= null && datef != null && datet != null){
                    String cN = edCrop.getText().toString();
                    String fn = farms.getSelectedItem().toString();
                    String fd = datef.getText().toString();
                    String td = datet.getText().toString();

                    db.AddCrops(new CropShow(1, cN, fn, fd, td));
                    Intent home = new Intent(CropAdd.this, Homepage.class);
                    startActivity(home);
                }

                else{
                    Toast.makeText(CropAdd.this, "Fill All Values", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}