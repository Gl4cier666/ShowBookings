package com.damienksandoval.www.showbookings;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * This is the adapter for the RecyclerView. It ties data to the view.
 *
 * To do: create viewholder class to extend the adapter.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ShowHolder> {


    @Override
    public RecyclerAdapter.ShowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ShowHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }

    class ShowHolder extends RecyclerView.ViewHolder{
        private TextView showName;
        private ImageView icon;
        private View showListView;

        public ShowHolder(View itemView) {
            super(itemView);


            showName = (TextView)itemView.findViewById(R.id.im_shows_txt);
            icon = (ImageView)itemView.findViewById(R.id.im_shows_icon);
            showListView = itemView.findViewById(R.id.show_list);
        }
    }


}
