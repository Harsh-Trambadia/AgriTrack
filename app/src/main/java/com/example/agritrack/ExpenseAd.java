package com.example.agritrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExpenseAd extends ArrayAdapter<ExpenseShow>{

    public ExpenseAd(@NonNull Context context,int resource, @NonNull List<ExpenseShow> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View currentItemView = convertView;

        currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.expense_layout, parent, false);

        ExpenseShow currentExpensePosition = getItem(position);

        TextView name = currentItemView.findViewById(R.id.Name);
        TextView cost = currentItemView.findViewById(R.id.Cost);

        assert currentExpensePosition!=null;
        name.setText(currentExpensePosition.getActname());
        cost.setText(String.valueOf(currentExpensePosition.getValue()));

        return currentItemView;
    }
}
