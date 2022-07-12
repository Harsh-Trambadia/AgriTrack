package com.example.agritrack;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Expense extends Fragment {
    ListView l;
    FloatingActionButton ae;
    DbHandler db;
    ArrayList<ExpenseShow> expenseShow;

    String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };
    String cost[]
            = { "0","1","2","3","4","5","6","7","8","9" };
    public Expense(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expense, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        db = new DbHandler(getActivity());
        expenseShow = db.showExpense();

       l = (ListView) getView().findViewById(R.id.list);



        ExpenseAd adapter = new ExpenseAd(getActivity(), expenseShow);
        l.setAdapter(adapter);

        ae = getView().findViewById(R.id.AddExpense);
        ae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Adding Expenses", Toast.LENGTH_SHORT).show();
                Intent ExAdd = new Intent(getActivity(), ExpenseAdd.class);
                startActivity(ExAdd);
            }
        });

    }


}