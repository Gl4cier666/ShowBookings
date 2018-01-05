package com.damienksandoval.www.showbookings;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shows extends AppCompatActivity {

    private List<ShowItem> database;
    private List<ShowItem> itemList;
    boolean dbloop = true;
    RecyclerView showView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);
        database = new ArrayList<>();
        populateData();
        showView = (RecyclerView) findViewById(R.id.show_list);
        showView.setHasFixedSize(true);
        showView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter rAdapter = new RecyclerAdapter(database,this);
        showView.setAdapter(rAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Shows.this, AddShow.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shows, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void populateData() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sdcard = Environment.getExternalStorageDirectory();
            File dir = new File(sdcard.getAbsolutePath() + "/ShowBookings/");
            if (dir.exists()) {
            try {
                File file = new File(dir,"show_database.bin");
                ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
                try {
                    itemList = (List<ShowItem>)(reader.readObject());
                    if (!itemList.isEmpty()) {
                        for(int i = 0; i <= itemList.size() - 1; i++){
                            ShowItem value = itemList.get(i);
                            database.add(value);

                        }
                    } else {
                        System.out.println("No shows");
                    }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                reader.close();
                } catch(IOException e){
                e.printStackTrace();
            }
        } else {
                dir.mkdir();
            }
            }
    }
}
