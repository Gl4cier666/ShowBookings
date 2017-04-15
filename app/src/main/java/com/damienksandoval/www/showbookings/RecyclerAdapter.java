package com.damienksandoval.www.showbookings;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * This is the adapter for the RecyclerView that ties everything together.
 *
 * To do: create viewholder class to extend the adapter.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.showList> {


    private ArrayList<ShowItem> showList;

    RecyclerAdapter(ArrayList<ShowItem> showLists){
        this.showList = showLists;
    }

    @Override
    public RecyclerAdapter.showList onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.showList holder, int position) {

    }

    @Override
    public int getItemCount() {

        return showList.size();
    }
}
