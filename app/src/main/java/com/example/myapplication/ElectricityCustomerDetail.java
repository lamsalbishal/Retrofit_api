package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.ApiClass.BillDetail;
import com.example.myapplication.ApiClass.GetNeaBill;
import com.example.myapplication.Helper.BillDetailHelper;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class ElectricityCustomerDetail extends AppCompatActivity {

    private Gson gson;

    String arrayData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_customer_detail);
        Intent intent = getIntent();
        ArrayList<String> getBill = intent.getStringArrayListExtra("DetailCode");



        Log.i("GET",getBill.toString());


        try {
            JSONArray jsonArray = new JSONArray(getBill.get(4));



            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject row = jsonArray.getJSONObject(i);
                arrayData = row.getString("BillDate");
            }
            Log.i("string array", arrayData);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
