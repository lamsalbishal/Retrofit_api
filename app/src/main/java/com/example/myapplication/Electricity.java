package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.myapplication.ApiClass.NeaOfficeCode;
import com.example.myapplication.ApiClass.OfficeCodes;
import com.example.myapplication.ApiClass.PrabhuTv;
import com.example.myapplication.Helper.OfficeList;
import com.example.myapplication.Interface.JsonPlaceHolder;
import com.example.myapplication.ListViewData.OfficeNameList;
import com.example.myapplication.ListViewData.TvListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Electricity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        listView = findViewById(R.id.officeNameList);

        getElectricityList();

    }

    public void getElectricityList(){

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://www.eprabhu.com/ApiMobile/MobileService.svc/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        NeaOfficeCode neaOfficeCode = new NeaOfficeCode("KAPIL1", "JHK#1234");



        Call<NeaOfficeCode> callapi = jsonPlaceHolder.createNEAOfiiceApi("fyZbT@r6_Rx$HGfNKyUL", neaOfficeCode);

        callapi.enqueue(new Callback<NeaOfficeCode>() {
            @Override
            public void onResponse(Call<NeaOfficeCode> call, Response<NeaOfficeCode> response) {
                try {
                    Log.i("response code ", response.body().getCode());
                    ArrayList<OfficeList> list = new ArrayList<>();
                    ArrayList<OfficeCodes> officeCodes = response.body().getOfficeCodes();
                    for(int i = 0; i<officeCodes.size(); i++){

                        Log.i("office codes",officeCodes.get(i).getOfficeCodes());

                        OfficeList info = new OfficeList();
                        info.officeName = officeCodes.get(i).getOffice();
                        info.officeCodes = officeCodes.get(i).getOfficeCodes();
                        list.add(info);
                    }
                    listView.setAdapter(new OfficeNameList(Electricity.this,list));

                }catch (Exception e){

                    Log.i("Electricity Error",e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<NeaOfficeCode> call, Throwable t) {

            }
        });

    }
}
