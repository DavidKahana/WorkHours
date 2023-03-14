package com.example.workhours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEntrance , btnHoursReport , btnInformation , btnDefinitions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrance = (Button) findViewById(R.id.btnEntrance);
        btnHoursReport = (Button) findViewById(R.id.btnHoursReport);
        btnInformation = (Button) findViewById(R.id.btnInformation);
        btnDefinitions = (Button) findViewById(R.id.btnDefinitions);

        btnEntrance.setOnClickListener(this);
        btnHoursReport.setOnClickListener(this);
        btnInformation.setOnClickListener(this);
        btnDefinitions.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnEntrance){
            Intent intent=new Intent(this,Entrance.class);
            startActivity(intent);
        }
        else if (v == btnHoursReport){
            Intent intent=new Intent(this,HoursReport.class);
            startActivity(intent);
        }
        else if (v == btnInformation){
            Intent intent=new Intent(this,Information.class);
            startActivity(intent);
        }
        else if (v == btnDefinitions){
            Intent intent=new Intent(this,Definitions.class);
            startActivity(intent);
        }
    }
}