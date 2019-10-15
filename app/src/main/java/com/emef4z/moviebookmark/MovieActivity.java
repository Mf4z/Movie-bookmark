package com.emef4z.moviebookmark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MovieActivity extends AppCompatActivity {

    private LinearLayout seasonNepisode;
    private RadioButton movie_radioBtn;
    private RadioButton series_radioBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        seasonNepisode = findViewById(R.id.linearLayout_seasonNepisode);

        movie_radioBtn = findViewById(R.id.radioButton_movie);
        series_radioBtn = findViewById(R.id.radioButton_series);

        movie_radioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    seasonNepisode.setVisibility(View.GONE);
                }else {
                    seasonNepisode.setVisibility(View.VISIBLE);
                }

            }
        });

    }
}
