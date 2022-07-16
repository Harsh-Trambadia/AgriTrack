package com.example.agritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FarmAdd extends AppCompatActivity {
    Button addF;
    DbHandler db;
    EditText Fname, FDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_add);

        Fname =  findViewById(R.id.Fname);
        FDate =  findViewById(R.id.Fdate);
        addF =   findViewById(R.id.addF);
        db = new DbHandler(this);
        addF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Fname.getText()!= null && FDate !=null){
                    String fname = Fname.getText().toString();
                    String fdate = FDate.getText().toString();

                    db.addFarm(new FarmShow(1,fname, fdate));
                    Intent far = new Intent(FarmAdd.this, Homepage.class);
                    startActivity(far);
                }
                else{
                    Toast.makeText(FarmAdd.this, "Fill All Values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}