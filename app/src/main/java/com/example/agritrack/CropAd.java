package com.example.agritrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.agritrack.R;

public class CropAd extends ArrayAdapter<String> {

    public String[] objects;

    public CropAd(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public String getItem(int position){
        return objects[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent){
        convertview = LayoutInflater.from(getContext()).inflate(R.layout.crop_layout, parent, false);
        TextView crop = convertview.findViewById(R.id.Crop);
        crop.setText(getItem(position));
        return convertview;
    }

}