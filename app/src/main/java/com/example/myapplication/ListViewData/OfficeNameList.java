package com.example.myapplication.ListViewData;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Electricity;
import com.example.myapplication.ElectricityInsertField;
import com.example.myapplication.Helper.OfficeList;
import com.example.myapplication.R;

import java.util.ArrayList;

public class OfficeNameList extends ArrayAdapter<OfficeList> {


    Context context;
    public OfficeNameList(@NonNull Context context, ArrayList<OfficeList> lists) {
        super(context, 0,lists);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.officelist_activity,null);
        LinearLayout officeNameList = view.findViewById(R.id.officeNameList);
        TextView officeName = view.findViewById(R.id.officeName);

        final OfficeList officeList = getItem(position);
        officeName.setText(officeList.officeName);
        officeNameList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ElectricityInsertField.class);
                intent.putExtra("officeName",officeList.officeName);
                intent.putExtra("officeCode",officeList.officeCodes);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
