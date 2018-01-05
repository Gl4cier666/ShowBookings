package com.damienksandoval.www.showbookings;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the adapter for the RecyclerView. It ties data to the view.
 *
 * To do: create viewholder class to extend the adapter.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ShowHolder> {

    private List<ShowItem> showitems;
    private Context context;

    public RecyclerAdapter(List<ShowItem> showitems, Context context) {
        this.showitems = showitems;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.ShowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View showItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_item, parent, false);
        return new ShowHolder(showItem);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ShowHolder holder, int position) {
        ShowItem showitem = showitems.get(position);
        holder.showName.setText(showitem.getShowName());
    }

    @Override
    public int getItemCount() {
        try {
            return showitems.size();
        }catch(NullPointerException x){
            System.out.println("No Items In Show List");
            return 0;
        }
}

    class ShowHolder extends RecyclerView.ViewHolder{
        public TextView showName;
        public View showListView;

        public ShowHolder(View itemView) {
            super(itemView);


            showName = (TextView)itemView.findViewById(R.id.im_shows_txt);
        }
    }


}
