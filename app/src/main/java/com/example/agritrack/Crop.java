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


public class Crop extends Fragment {
    ListView l;
    FloatingActionButton ac;
    DbHandler db;
    ArrayList<CropShow>  cropShow;

    public Crop(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crop, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        l = (ListView) getView().findViewById(R.id.list);

        db = new DbHandler(getActivity());
        cropShow = db.ShowCrop();

        CropAd adapter = new CropAd(getActivity(), R.layout.crop_layout, cropShow);
        l.setAdapter(adapter);

        ac = getView().findViewById(R.id.AddCrop);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Adding Crop", Toast.LENGTH_SHORT).show();
                Intent cadd = new Intent(getActivity(), CropAdd.class);
                startActivity(cadd);
            }
        });

    }
}