package com.example.sharedelementtransition;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    //region Interface
    public interface ClickListener {
        void onCardSelected(int position, View cardView);
        void onStartNavigationSelected(int position);
    }
    //endregion

    //region Variables
    private ArrayList<String> items;
    private static RecyclerViewAdapter.ClickListener clickListener;
    private Context context;
    //endregion

    //region Constructor
    public RecyclerViewAdapter(ArrayList<String> items, Context context) {
        this.items = items;
        this.context = context;
    }
    //endregion

    //region Complying with RecyclerView.Adapter<TourRecyclerViewAdapter.ViewHolder> Methods
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new RecyclerViewAdapter.ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder card, int position) {

    }
    //endregion

    //region Public Methods
    public void setClickListener(RecyclerViewAdapter.ClickListener listener){
        clickListener = listener;
    }
    //endregion

    //region ViewHolder Class
    static class ViewHolder extends RecyclerView.ViewHolder {

        //region Widgets

        @BindView(R.id.map_view_location_card)
        CardView mapViewLocationCard;

        //endregion

        ViewHolder(View itemView) {
            super(itemView);

            // Binding the view
            ButterKnife.bind(this,itemView);

            // Set click listener for the card
            mapViewLocationCard.setOnClickListener(view -> {
                if(clickListener != null){
                    clickListener.onCardSelected(getLayoutPosition(),view);
                }
            });
        }
    }
    //endregion
}

