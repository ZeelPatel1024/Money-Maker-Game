package com.example.actualmoneyclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

public class winActivity extends AppCompatActivity {
    RatingBar ratingStars;
    float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        ratingStars = findViewById(R.id.ratingStars);

        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                rating = v;

            }
        });

    }

    public void replayClick(View view){
        startActivity(new Intent(winActivity.this,MainActivity.class));
    }

}