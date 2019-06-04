package com.example.myapplication.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.ApiClass.PrabhuTv;
import com.example.myapplication.ApiClass.RenewalPlans;
import com.example.myapplication.BillPayment;
import com.example.myapplication.Interface.JsonPlaceHolder;
import com.example.myapplication.PersonalDetail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BillPAymentServices extends Service {

    String opCode;
    ArrayList<String> test = new ArrayList<String>();
    PrabhuTv prabhuTv;
    String urldata;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle extras = intent.getExtras();
        String code = (String) extras.get("code");
        String opCode = (String) extras.get("opCode");
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

                if((response.body().getCode()).equals("011")){
                    Toast.makeText(BillPAymentServices.this, "Error", Toast.LENGTH_SHORT).show();

                }else {

//                    ArrayList<RenewalPlans> renewalPlans = response.body().getRenewalPlans();
//                    if(renewalPlans.size() != 0) {
//                        for (int j = 0; j < renewalPlans.size(); j++) {
//                            Log.i("renewal plans ", "no length");
//                        }
//                    }
                    Intent i = new Intent(BillPAymentServices.this, PersonalDetail.class);
                    test.add(response.body().getCustomerName());

                    test.add(response.body().getCustomerId());
                    i.putStringArrayListExtra("customer",(ArrayList<String>) test);
                    startActivity(i);

                }
            }

            @Override
            public void onFailure(Call<PrabhuTv> call, Throwable t) {

            }
        });

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
