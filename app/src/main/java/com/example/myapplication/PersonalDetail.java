package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonalDetail extends AppCompatActivity {

    TextView casId,customerId,customerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detail);
        casId = findViewById(R.id.casID);
        customerId = findViewById(R.id.customerID);
        customerName = findViewById(R.id.customerName);

        Intent intent = getIntent();
        ArrayList<String> test = intent.getStringArrayListExtra("customer");
        Log.i("test value check",test.toString());

         customerName.setText(test.get(0));
         customerId.setText(test.get(1));

    }

}
