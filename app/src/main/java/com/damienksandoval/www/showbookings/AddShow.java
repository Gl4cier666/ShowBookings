package com.damienksandoval.www.showbookings;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
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

                EditText shownamein = (EditText) findViewById(R.id.showNameIn);
                String showtitle = shownamein.getText().toString();
                newShow = new ShowItem(showtitle, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                saveShowDate();
                saveShowTime();
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File sdcard = Environment.getExternalStorageDirectory();
                        File dir = new File(sdcard.getAbsolutePath()+"/ShowBookings/");
                        if(!dir.exists()){
                            dir.mkdir();
                        }
                        try{
                        File file = new File(dir,"show_database.bin");
                        ObjectOutputStream eventSaver = new ObjectOutputStream(new FileOutputStream(file));
                        eventSaver.writeObject(newShow);
                        eventSaver.close();
                        // ObjectOutputStream eventSaver = new ObjectOutputStream(new FileOutputStream(database));
                        //eventSaver.writeObject(newShow);
                        //eventSaver.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Done Writing");
                    startActivity(new Intent(AddShow.this,Shows.class));
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
