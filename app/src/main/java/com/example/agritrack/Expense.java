package com.example.agritrack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Expense extends Fragment {
    ListView l;
    FloatingActionButton ae;
    String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };
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
        l = (ListView) getView().findViewById(R.id.list);
        ExpenseAd adapter = new ExpenseAd(getActivity(), R.layout.expense_layout, tutorials);
        l.setAdapter(adapter);

        ae = getView().findViewById(R.id.AddExpense);
        ae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Adding Expenses", Toast.LENGTH_SHORT).show();
            }
        });

    }
}