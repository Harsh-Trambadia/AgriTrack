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

public class FarmAd extends ArrayAdapter<FarmShow> {



    public FarmAd(@NonNull Context context, int resource, @NonNull List<FarmShow> objects) {
        super(context, resource, objects);

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent){
        View currentItemView = convertview;

        currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.farm_layout, parent, false);

        FarmShow currentFarmPosition = getItem(position);

        TextView Fname = currentItemView.findViewById(R.id.Farm);
        TextView Fdate = currentItemView.findViewById(R.id.fDate);

        assert currentFarmPosition!=null;
        Fname.setText(currentFarmPosition.getFarm());
        Fdate.setText(currentFarmPosition.getDate());

        return currentItemView;
    }

}
