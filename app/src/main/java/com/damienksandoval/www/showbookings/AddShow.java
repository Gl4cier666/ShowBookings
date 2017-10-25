package com.damienksandoval.www.showbookings;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AddShow extends AppCompatActivity {
    public ShowItem newShow;
    private static final String FILENAME = "event_database.bin";
    private static final File database = new File()
    private Button saveShow;
    private DatePicker showStartDate;
    private DatePicker showEndDate;
    private TimePicker showStartTime;
    private TimePicker showEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshow);
        saveShow = (Button) findViewById(R.id.saveShowButton);
        showStartDate = (DatePicker) findViewById(R.id.sDatePicker);
        showEndDate = (DatePicker) findViewById(R.id.eDatePicker);
        showStartTime = (TimePicker) findViewById(R.id.sTimePicker);
        showEndTime = (TimePicker) findViewById(R.id.eTimePicker);

        saveShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText shownamein = (EditText)findViewById(R.id.showNameIn);
                String showtitle = shownamein.getText().toString();
                newShow = new ShowItem(showtitle,0,0,0,0,0,0,0,0,0,0,0);
                saveShowDate();
                saveShowTime();
                try {
                    ObjectOutputStream eventSaver = new ObjectOutputStream(new FileOutputStream(FILENAME));
                    eventSaver.writeObject(newShow);
                    eventSaver.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


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
