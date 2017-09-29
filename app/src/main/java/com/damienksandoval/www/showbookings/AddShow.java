package com.damienksandoval.www.showbookings;

import android.os.Build;
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

                String showtitle = findViewById(R.id.showName).toString();
                newShow.setShowName(showtitle);
                saveShowDate();
                saveShowTime();

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
        if(Build.VERSION.SDK_INT < 23 ){
        newShow.setShour(showStartTime.getCurrentHour());
        newShow.setSminute(showStartTime.getCurrentMinute());
        newShow.setEhour(showEndTime.getCurrentHour());
        newShow.setEminute(showEndTime.getCurrentMinute());
    } else {
            newShow.setShour(showStartTime.getHour());
            newShow.setSminute(showStartTime.getMinute());
            newShow.setEhour(showEndTime.getHour());
            newShow.setEminute(showEndTime.getMinute());
        }
        }



}
