package com.example.sharedelementtransition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    // Widgets
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    // Variables
    private List<Integer> items = new ArrayList<>();
    private final static int NUM_OF_COLUMNS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // Binding views
        ButterKnife.bind(this);

        // Adding images to list
        items.add(R.drawable.panama);
        items.add(R.drawable.panama2);
        items.add(R.drawable.tampa);
        items.add(R.drawable.gothenburg);
        items.add(R.drawable.amsterdam);
        items.add(R.drawable.singapore);
        items.add(R.drawable.madrid);
        items.add(R.drawable.warsaw);
        items.add(R.drawable.india);
        items.add(R.drawable.china);

        // Configuring the recycler view adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, NUM_OF_COLUMNS));
        recyclerView.setAdapter(recyclerViewAdapter);

        // Listening to view clicks
        recyclerViewAdapter.setClickListener(this);
    }

    // Listening to card clicks
    @Override
    public void onCardSelected(View view, int position) {
        doSharedElementTransition(view, position);
    }

    // Method for executing animation
    public void doSharedElementTransition(View view, int position) {

        // Intent for launching activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.BUNDLE_KEY,items.get(position));

        // Get the transition name from the strings xml file
        String transitionName = getString(R.string.transition_string);

        // Creating options
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        view,   // clicked view
                        transitionName    // The transition string
                );

        // Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
