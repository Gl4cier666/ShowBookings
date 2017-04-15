package com.damienksandoval.www.showbookings;

import java.util.ArrayList;

/**
 * ShowItem class is used for creating events. Events are currently stored in an ArrayList with
 * future plans of implementing a remote database
 */

public class ShowItem {
    private String showName;
    private int capacity;
    private int date;


    public ShowItem(String name, int venCapacity, int showDate) {
        this.showName = name;
        this.capacity = venCapacity;
        this.date = showDate;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

}