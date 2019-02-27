package com.example.sharedelementtransition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    /**
     * Inspiration Article
     * https://android.jlelse.eu/easy-android-shared-element-transition-ac36952a4a4
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<String> a = new ArrayList<>();
        a.add("asd");
        a.add("asd");
        a.add("asd");

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(a,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setClickListener(this);

    }

    @Override
    public void onCardSelected(int position, View cardView) {
        animateIntent(cardView);
    }

    @Override
    public void onStartNavigationSelected(int position) {

    }

    public void animateIntent(View view) {

        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this, Second.class);

        // Get the transition name from the string
        String transitionName = getString(R.string.transition_string);

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        view,   // Starting view
                        transitionName    // The String
                );
        //Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());

    }
}
