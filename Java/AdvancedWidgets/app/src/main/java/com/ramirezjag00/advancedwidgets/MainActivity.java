package com.ramirezjag00.advancedwidgets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggle = findViewById(R.id.toggleBtn);

        RadioGroup radioGroup = findViewById(R.id.radioGRP);
        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);

        CheckBox checkBox1 = findViewById(R.id.checkbox1);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);

        ProgressBar indeterminate = findViewById(R.id.indeterminate);
        indeterminate.setVisibility(View.INVISIBLE);

        ProgressBar determinate = findViewById(R.id.determinate);
        ProgressBar customProgress = findViewById(R.id.customProgress);
        Button progressButton = findViewById(R.id.progressButton);

        // to set a checkbox/radiobutton to checked or not
        // checkBox1.setChecked(true);

        Spinner spinner = findViewById(R.id.spinner);

        toggle.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Test Order", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Final Order", Toast.LENGTH_SHORT).show();
                }
            }
        }));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.fulfillment_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You Selected: "+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indeterminate.setVisibility(indeterminate.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE);
                determinate.incrementProgressBy(10);
                customProgress.incrementProgressBy(10);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio1:
                if (checked) {
                    Toast.makeText(this, "Pizza", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radio2:
                if (checked) {
                    Toast.makeText(this, "Burger", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkbox1:
                if (checked) {
                    Toast.makeText(this, "Cheese", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No Cheese", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox2:
                if (checked) {
                    Toast.makeText(this, "Ketchup", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No Ketchup", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void showTimePickerDialog(View v){
        DialogFragment newFragment = new TimerPickerFragment();
        newFragment.show(getSupportFragmentManager(), "TimePicker");
    }

    public void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerDialog();
        newFragment.show(getSupportFragmentManager(), "DatePicker");
    }
}