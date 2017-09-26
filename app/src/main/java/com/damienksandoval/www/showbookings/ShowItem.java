package com.damienksandoval.www.showbookings;

import java.util.ArrayList;

/**
 * ShowItem class is used for creating events. Events are currently stored in an ArrayList with
 * future plans of implementing a remote database
 */

public class ShowItem {
    private String showName;
    private int capacity;
    private int date;//Need to change into 3 ints for spinner
    private int time;


    public ShowItem(String name, int venCapacity, int showDate, int showTime) {
        this.showName = name;
        this.capacity = venCapacity;
        this.date = showDate;
        this.time = showTime;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String newShowName) {
        this.showName = newShowName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int newDate) {
        this.date = newDate;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int newTime){
        this.time = newTime;
    }

}