package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ApiClass.Prabhu;
import com.example.myapplication.ApiClass.PrabhuTv;
import com.example.myapplication.ApiClass.RenewalPlans;
import com.example.myapplication.ApiClass.Service;
import com.example.myapplication.ApiClass.Services;
import com.example.myapplication.Helper.TvInfo;
import com.example.myapplication.Interface.JsonPlaceHolder;
import com.example.myapplication.ListViewData.TvListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BillPayment extends AppCompatActivity {

    Button billPayment;
    EditText tvcode;
    TextView showcode;
     String opCode;
    ArrayList<String> test = new ArrayList<String>();
    PrabhuTv prabhuTv;
    String urldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment);

        showcode = (TextView) findViewById(R.id.showCode);
        tvcode = (EditText) findViewById(R.id.tvnumber);
        billPayment = findViewById(R.id.billpaymentBtn);

        Intent intent = getIntent();
        opCode=intent.getStringExtra("opCode");

        billPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              showcode.setText(tvcode.getText().toString());
              prabhuTvApi(tvcode.getText().toString());
            }
        });

    }


    public void  prabhuTvApi(String code) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://www.eprabhu.com/ApiMobile/MobileService.svc/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);


        if(opCode.equals("47")){
             urldata = "CheckPrabhuTvAccount";
             prabhuTv = new PrabhuTv("KAPIL1", "JHK#1234",code,"");

        }else if(opCode.equals("19")){
            urldata ="CheckDishHomeAccount";
            prabhuTv = new PrabhuTv("KAPIL1", "JHK#1234","",code);
        }else if(opCode.equals("33")){
            urldata ="CheckSimTVAccount";
            prabhuTv = new PrabhuTv("KAPIL1", "JHK#1234","",code);
        }

        Call<PrabhuTv> callapi = jsonPlaceHolder.createPostTvApi(urldata,"fyZbT@r6_Rx$HGfNKyUL", prabhuTv);

        callapi.enqueue(new Callback<PrabhuTv>() {
            @Override
            public void onResponse(Call<PrabhuTv> call, Response<PrabhuTv> response) {
                Log.i("response body",response.body().toString());
                if((response.body().getCode()).equals("011")){
                    Toast.makeText(BillPayment.this, "unsuccessfull", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(BillPayment.this, "success full", Toast.LENGTH_SHORT).show();
                }





//                if(response.body().getCode().equals("000")){

//                    ArrayList<RenewalPlans> renewalPlans = response.body().getRenewalPlans();
//                    if(renewalPlans.size() != 0) {
//                        for (int j = 0; j < renewalPlans.size(); j++) {
//                            Log.i("renewal plans ", "no length");
//                        }
//                    }
//                    Intent i = new Intent(BillPayment.this,PersonalDetail.class);
//                    test.add(response.body().getCustomerName());
//
//                    test.add(response.body().getCustomerId());
//                    i.putStringArrayListExtra("customer",(ArrayList<String>) test);
//                    startActivity(i);



            }

            @Override
            public void onFailure(Call<PrabhuTv> call, Throwable t) {
                Log.i("error response","error");
            }
        });

    }



}
