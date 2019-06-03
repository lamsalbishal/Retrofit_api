package com.example.myapplication.ListViewData;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.BillPayment;
import com.example.myapplication.Helper.TvInfo;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TvListView extends ArrayAdapter<TvInfo> {
    Context context;
    public TvListView(@NonNull Context context,ArrayList<TvInfo> list) {
        super(context, 0,list);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_list_activity,null);
        LinearLayout listBtn = view.findViewById(R.id.billpaymentBtn);
        TextView category = view.findViewById(R.id.categoryView);
        ImageView imageView = view.findViewById(R.id.tvImage);


        final TvInfo info = getItem(position);
        category.setText(info.Name);

        if(!(info.Image.isEmpty()))
        {

            Picasso.with(context).load(info.Image).into(imageView);
        }
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, BillPayment.class);
                i.putExtra("opCode",info.opCode);
                context.startActivity(i);
            }
        });



        return  view;
    }
}





