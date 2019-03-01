package com.example.sharedelementtransition;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    // Interface
    public interface ClickListener {
        void onCardSelected(View view, int position);
    }

    // Variables
    private List<Integer> items;
    private static RecyclerViewAdapter.ClickListener clickListener;

    // Constructor
    public RecyclerViewAdapter(List<Integer> items) {
        this.items = items;
    }

    
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

        // Setting the image
        card.imageView.setBackgroundResource(items.get(position));
    }

    //Method for getting a listener to card clicks
    public void setClickListener(RecyclerViewAdapter.ClickListener listener){
        clickListener = listener;
    }

    //region ViewHolder Class
    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;
        @BindView(R.id.imageView)
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);

            // Binding the view
            ButterKnife.bind(this,itemView);

            // Set click listener for the linearlayout
            linearLayout.setOnClickListener(view -> {
                if(clickListener != null){
                    clickListener.onCardSelected(view, getLayoutPosition());
                }
            });
        }
    }
}

