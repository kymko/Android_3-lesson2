package com.example.android3lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.android3lesson2.R;

public class SecondActivity extends AppCompatActivity {

    private TextView title;
    private TextView originalTitle;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        title = findViewById(R.id.title_movie);
        originalTitle = findViewById(R.id.original_title);
        description = findViewById(R.id.description);

        title.setText(getIntent().getStringExtra("title"));
        originalTitle.setText(getIntent().getStringExtra("original"));
        description.setText(getIntent().getStringExtra("des"));


    }
}