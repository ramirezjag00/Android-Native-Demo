package com.ramirezjag00.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Input Method Manager
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        // EditView
        EditText editName = findViewById(R.id.nameEdit);

        // Button to submit
        Button submitBtn = findViewById(R.id.submitBtn);

        // Button to reset
        Button resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setEnabled(false);

        // Event Handler for Submit
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dismiss keyboard
                imm.hideSoftInputFromWindow(editName.getWindowToken(), 0);

                // Getting input from EditText
                String name = editName.getText().toString();

                // Trigger Toast
                if (!name.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "My name is "+name, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Missing name input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Event Handler for Reset
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dismiss keyboard
                imm.hideSoftInputFromWindow(editName.getWindowToken(), 0);

                // set input to empty string
                editName.setText("");

                // Trigger Toast
                Toast.makeText(getApplicationContext(), "Name field has been reset", Toast.LENGTH_SHORT).show();
            }
        });

        // Event Listener for editName EditView
        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Getting input from EditText
                String name = editName.getText().toString();

                if (name.isEmpty() || name == null) {
                    resetBtn.setEnabled(false);
                } else {
                    resetBtn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}