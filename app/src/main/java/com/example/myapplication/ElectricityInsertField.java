package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.ApiClass.BillDetail;
import com.example.myapplication.ApiClass.GetNeaBill;
import com.example.myapplication.ApiClass.NeaOfficeCode;
import com.example.myapplication.ApiClass.OfficeCodes;
import com.example.myapplication.Helper.OfficeList;
import com.example.myapplication.Interface.JsonPlaceHolder;
import com.example.myapplication.ListViewData.OfficeNameList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ElectricityInsertField extends AppCompatActivity {

    TextView textView,officeCodes;
    String officeName,officeCode;
    EditText region,scNo,consumerId;
    Button getBill;
    ArrayList<String> addData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_insert_field);


        //edit text find view by id
        region = findViewById(R.id.region);
        scNo = findViewById(R.id.scNo);
        consumerId = findViewById(R.id.consumerId);

        //button find view by id
        getBill = findViewById(R.id.getBill);


        Intent i = getIntent();
        officeName = i.getStringExtra("officeName");
        officeCode = i.getStringExtra("officeCode");


        region.setText(officeName);
        region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElectricityInsertField.this,Electricity.class);
                startActivity(i);
            }
        });


        getBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billPayment(scNo.getText().toString(),officeCode,consumerId.getText().toString());
            }
        });


    }

    public void billPayment(String scno,String offcode,String consID){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://www.eprabhu.com/ApiMobile/MobileService.svc/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);


        GetNeaBill getNeaBill = new GetNeaBill("KAPIL1","JHK#1234","009.12.014KA(Z)","218","109054021");


        Call<GetNeaBill> callapi = jsonPlaceHolder.createNeaBill("fyZbT@r6_Rx$HGfNKyUL", getNeaBill);

       callapi.enqueue(new Callback<GetNeaBill>() {
           @Override
           public void onResponse(Call<GetNeaBill> call, Response<GetNeaBill> response) {

               addData  = new ArrayList<>();





              if(response.body().getCode().equals("000")){


                addData.add(response.body().getConsumerId());
                addData.add(response.body().getCustomerName());
                addData.add(response.body().getOffice());
                addData.add(response.body().getTotalDueAmount());
                addData.add(response.body().getBillDetail().toString());


                  Intent intent = new Intent(ElectricityInsertField.this,ElectricityCustomerDetail.class);
                  intent.putStringArrayListExtra("DetailCode",(ArrayList<String>) addData);

                  startActivity(intent);
                  Log.i("Detail Data",addData.toString());

              }


           }

           @Override
           public void onFailure(Call<GetNeaBill> call, Throwable t) {

           }
       });

    }


}
