package com.damienksandoval.www.showbookings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class AddShow extends AppCompatActivity {
    public ShowItem newShow;
    private final Button saveShow = (Button) findViewById(R.id.saveShowButton);
    private DatePicker showStartDate = (DatePicker) findViewById(R.id.sDatePicker);
    private DatePicker showEndDate = (DatePicker) findViewById(R.id.eDatePicker);
    private TimePicker showStartTime = (TimePicker) findViewById(R.id.sTimePicker);
    private TimePicker showEndTime = (TimePicker) findViewById(R.id.eTimePicker);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshow);
        saveShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });
    }
    //pull data from showStartDate
    private void saveShowDate(){
        newShow.setSday(showStartDate.getDayOfMonth());
        newShow.setSmonth(showStartDate.getMonth());
        newShow.setSyear(showStartDate.getYear());
        newShow.setEday(showEndDate.getDayOfMonth());
        newShow.setEmonth(showEndDate.getMonth());
        newShow.setEyear(showEndDate.getYear());

    }
    private void saveShowTime(){

    }



}
