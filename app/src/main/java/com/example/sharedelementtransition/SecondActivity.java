package com.example.sharedelementtransition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    public static final String BUNDLE_KEY = "place";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Binding view
        ButterKnife.bind(this);

        // Get the passed image. WIth Panama as default
        int image = getIntent().getIntExtra(BUNDLE_KEY, R.drawable.panama);

        // Set the image
        imageView.setImageResource(image);

    }
}
