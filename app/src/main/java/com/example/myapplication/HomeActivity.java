package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button tv,internet;

    private final String[] tvopcode ={"47","33","23","19"};
    private  final  String[] internetopcode = {"16","22","30","34","39","44","45","54","55","56","57","58"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv = findViewById(R.id.tvBtn);

        internet = findViewById(R.id.internetBtn);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArray("opcode",tvopcode);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArray("opcode",internetopcode);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
