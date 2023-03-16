package com.example.workhours;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Entrance extends AppCompatActivity implements View.OnClickListener {

    Button btnDate , btnTime , btnToStart;
    TextView tvEntrance1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);


        tvEntrance1 = (TextView)findViewById(R.id.tvEntrance1);

        btnDate = (Button) findViewById(R.id.btnDate);
        btnTime = (Button)findViewById(R.id.btnTime);
        btnToStart = (Button)findViewById(R.id.btnToStart);

        btnDate.setOnClickListener(this);
        btnTime.setOnClickListener(this);
        btnToStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btnDate)
        {
            Calendar systemCalender = Calendar.getInstance();
            int year = systemCalender.get(Calendar.YEAR);
            int month = systemCalender.get(Calendar.MONTH);
            int day = systemCalender.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,new SetDate(),year,month,day);
            datePickerDialog.show();



        }

        else if (v == btnTime)
        {
            Calendar systemCalendar = Calendar.getInstance();
            int hour = systemCalendar.get(Calendar.HOUR_OF_DAY);
            int minute = systemCalendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,new SetYourTime(),hour,minute,true);
            timePickerDialog.show();;


        }
    }


    public  class SetDate implements DatePickerDialog.OnDateSetListener
    {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            monthOfYear = monthOfYear +1;

            String str = "You selected :" + dayOfMonth + "/" + monthOfYear +"/" + year;
            Toast.makeText(Entrance.this,str,Toast.LENGTH_SHORT).show();
            btnDate.setText(str);

        }

    }

    public class  SetYourTime implements TimePickerDialog.OnTimeSetListener
    {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String str= "";
            if (hourOfDay < 10){
                str = "Time is :" + "0" + hourOfDay +":" + minute;
            }
            if (minute < 10){
                str = "Time is :" + hourOfDay +":" + "0" + minute;
            }

            if (minute < 10 && hourOfDay < 10){
                str = "Time is :" + "0" + hourOfDay +":" + "0" + minute;
            }
            if (minute >= 10 && hourOfDay >= 10) {
                str = "Time is :" + hourOfDay + ":" + minute;
            }
            Toast.makeText(Entrance.this,str,Toast.LENGTH_SHORT).show();
            btnTime.setText(str);

        }
    }
}
