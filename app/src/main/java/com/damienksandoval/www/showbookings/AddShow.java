package com.damienksandoval.www.showbookings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class AddShow extends AppCompatActivity {
    public ShowItem newShow;
    private final Button saveShow = (Button) findViewById(R.id.saveShowButton);
    private DatePicker showStartDate = (DatePicker) findViewById(R.id.sDatePicker);

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
    private void saveShowDate(int day, int month, int year){


    }




}
