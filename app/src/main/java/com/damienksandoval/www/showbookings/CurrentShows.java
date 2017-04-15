package com.damienksandoval.www.showbookings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.recyclerview.*;
/**
 * Created by Gl4cier on 1/20/2017.
 */


public class CurrentShows extends AppCompatActivity {

    RecyclerView myRecyclerView;
    LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);
        myRecyclerView = (RecyclerView) findViewById(R.id.show_list);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(myLayoutManager);






    }
}
