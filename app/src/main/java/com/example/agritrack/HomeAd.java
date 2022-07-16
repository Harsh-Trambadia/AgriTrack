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

import java.util.List;

public class HomeAd extends ArrayAdapter<ActivityShow> {



    public HomeAd(@NonNull Context context, int resource, @NonNull List<ActivityShow> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent){
        View currentItemView = convertview;

        currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_layout, parent, false);

        ActivityShow currentActPosition = getItem(position);

        TextView Act = currentItemView.findViewById(R.id.Activity);
        TextView F = currentItemView.findViewById(R.id.actF);
        TextView C = currentItemView.findViewById(R.id.actC);
        TextView D = currentItemView.findViewById(R.id.actD);

        assert currentActPosition!=null;
        Act.setText(currentActPosition.getActName());
        F.setText(currentActPosition.getFarm());
        C.setText(currentActPosition.getCrop());
        D.setText(currentActPosition.getDate());
        return currentItemView;
    }

}
