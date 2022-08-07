package com.ramirezjag00.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView textView = findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String myString = extras.getString("greeting");

            textView.setText(myString);
        }
    }
}