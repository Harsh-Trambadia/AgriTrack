package com.example.agritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExpenseAdd extends AppCompatActivity {
    Button addE;
    EditText name, cost;
    DbHandler db;
    ExpenseShow exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_add);
        addE = findViewById(R.id.addE);
        name = findViewById(R.id.exAct);
        cost = findViewById(R.id.exVal);
        db = new DbHandler(this);


        addE.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(name.getText()!=null && cost.getText()!=null){
                    String actName = name.getText().toString();
                    String c = cost.getText().toString();
                    int val = new Integer(c).intValue();
                    db.addExpense(new ExpenseShow(1, actName, val));
                    Intent home = new Intent(ExpenseAdd.this, Homepage.class);
                    startActivity(home);
                }

            }
        });
    }
}