package com.ramirezjag00.advancedwidgets2;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    private Switch switch1;
    private SeekBar seekBar;
    private SeekBar seekBarDiscrete;
    private RatingBar ratingBar;
    private EditText editTextKeyword;
    private Button buttonAdd;
    private Button buttonShow;
    private ChipGroup chipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chip chip1 = findViewById(R.id.chip1);
        Chip chip2 = findViewById(R.id.chip2);
        Chip chip3 = findViewById(R.id.chip3);
        Chip chip4 = findViewById(R.id.chip4);
        Chip chip5 = findViewById(R.id.chip5);
        Chip chip6 = findViewById(R.id.chip6);

        switch1 = findViewById(R.id.switch1);
        seekBar = findViewById(R.id.seekBar);
        seekBarDiscrete = findViewById(R.id.seekBar2);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        editTextKeyword = (EditText) findViewById(R.id.editText_keyword);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonShow = (Button) findViewById(R.id.button_show);
        chipGroup = (ChipGroup) findViewById(R.id.chipGroup);

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSwitch();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                onSeekBarChange(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarDiscrete.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                onSeekBarDiscreteChange(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                popRating(v);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewChip();
            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelections();
            }
        });
    }

    private void handleSwitch() {
        String statusSwitch1;
        if (switch1.isChecked()) {
            statusSwitch1 = switch1.getTextOn().toString();
        } else {
            statusSwitch1 = switch1.getTextOff().toString();
        }

        Toast.makeText(this, statusSwitch1, Toast.LENGTH_LONG).show();
    }

    private void onSeekBarChange(int i) {
        Toast.makeText(this, String.valueOf(i), Toast.LENGTH_LONG).show();
    }

    private void onSeekBarDiscreteChange(int i) {
        Toast.makeText(this, String.valueOf(i), Toast.LENGTH_LONG).show();
    }

    private void popRating(float rating) {
        String rate = String.valueOf(rating);
        Toast.makeText(this, rate, Toast.LENGTH_LONG).show();
    }

    private void addNewChip() {
        String keyword = editTextKeyword.getText().toString();
        if (keyword == null || keyword.isEmpty()) {
            Toast.makeText(this, "Please enter the keyword!", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            LayoutInflater inflater = LayoutInflater.from(this);

            // Create a Chip from Layout.
            Chip newChip = (Chip) inflater.inflate(R.layout.layout_chip_entry, chipGroup, false);
            newChip.setText(keyword);

            //
            // Other methods:
            //
            // newChip.setCloseIconVisible(true);
            // newChip.setCloseIconResource(R.drawable.your_icon);
            // newChip.setChipIconResource(R.drawable.your_icon);
            // newChip.setChipBackgroundColorResource(R.color.red);
            // newChip.setTextAppearanceResource(R.style.ChipTextStyle);
            // newChip.setElevation(15);

            chipGroup.addView(newChip);

            // Set Listener for the Chip:
            newChip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    handleChipCheckChanged((Chip) buttonView, isChecked);
                }
            });

            newChip.setOnCloseIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleChipCloseIconClicked((Chip) v);
                }
            });


            editTextKeyword.setText("");

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    // User click on "Show Selections" button.
    private void showSelections()  {
        try {
            int count = chipGroup.getChildCount();

            String s = "";
            for (int i=0;i< count; i++) {
                Chip child = (Chip) chipGroup.getChildAt(i);
                if (!child.isChecked()) {
                    continue;
                }

                if (isEmpty(s))  {
                    s = child.getText().toString();
                } else {
                    s += ", " + child.getText().toString();
                }
            }
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    // User close a Chip.
    private void handleChipCloseIconClicked(Chip chip) {
        ChipGroup parent = (ChipGroup) chip.getParent();
        parent.removeView(chip);
    }

    // Chip Checked Changed
    private void handleChipCheckChanged(Chip chip, boolean isChecked) {
    }
}