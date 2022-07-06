package com.example.agritrack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Home extends Fragment {
    ListView l;
    FloatingActionButton aa;
    String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };
    public Home(){
        // require a empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        l = (ListView) getView().findViewById(R.id.list);
        HomeAd adapter = new HomeAd(getActivity(), R.layout.activity_layout, tutorials);
        l.setAdapter(adapter);

        aa = getView().findViewById(R.id.AddActivity);
        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Adding Activity", Toast.LENGTH_SHORT).show();
            }
        });

    }









}