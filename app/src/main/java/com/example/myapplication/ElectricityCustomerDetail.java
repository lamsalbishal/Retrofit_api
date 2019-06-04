package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.ApiClass.BillDetail;
import com.example.myapplication.ApiClass.GetNeaBill;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;

public class ElectricityCustomerDetail extends AppCompatActivity {



    String arrayData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_customer_detail);
        Intent intent = getIntent();
        ArrayList<String> getBill = intent.getStringArrayListExtra("DetailCode");

        Log.i("json response",getBill.get(4));
        try {
            JSONArray jsonArray = new JSONArray(getBill.get(4));


            for(int i = 0; i<jsonArray.length(); i++){
               Log.i("loop array", jsonArray.get(i).toString());
            }
            Log.i("string array", "message");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
