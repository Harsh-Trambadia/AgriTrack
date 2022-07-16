package com.example.agritrack;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.agritrack.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CropAd extends ArrayAdapter<CropShow> {



    public CropAd(@NonNull Context context, int resource, @NonNull List<CropShow> objects) {
        super(context, resource, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent){
        View currentItemView = convertview;

        currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.crop_layout, parent, false);

        CropShow currentCropPosition = getItem(position);
        TextView cropName = currentItemView.findViewById(R.id.Crop);
        TextView isActive = currentItemView.findViewById(R.id.isActive);

        cropName.setText(currentCropPosition.getCrop());
        String fDate = currentCropPosition.getFromDate();
        String tDate = currentCropPosition.getToDate();

        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        try {
            Date from = format.parse(fDate);
            Date to = format.parse(tDate);
            String date = new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault()).format(new Date());
            Date current = format.parse(date);

            if (current.after(from) && current.before(to)){
                isActive.setText("Active");
                int c = Color.parseColor("#43a047");
                isActive.setTextColor(c);
            }
            else{
                isActive.setText("Ended");
                int c = Color.parseColor("#eb4034");
                isActive.setTextColor(c);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert currentCropPosition!=null;

        return currentItemView;
    }

}
