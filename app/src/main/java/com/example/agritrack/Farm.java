package com.example.agritrack;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Farm extends Fragment {
    ListView l;
    FloatingActionButton af;
    DbHandler db;
    ArrayList<FarmShow> farmShow;

    public Farm(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_farm, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        db = new DbHandler(getActivity());
        farmShow = db.showFarms();

        l = (ListView) getView().findViewById(R.id.list);
        FarmAd adapter = new FarmAd(getActivity(), R.layout.farm_layout, farmShow);
        l.setAdapter(adapter);

        af = getView().findViewById(R.id.AddFarm);
        af.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Adding Farm", Toast.LENGTH_SHORT).show();
                Intent farm = new Intent(getActivity(), FarmAdd.class);
                startActivity(farm);
            }
        });

    }

}