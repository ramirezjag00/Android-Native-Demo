package com.ramirezjag00.advancedwidgets;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.text.format.DateFormat;
import android.widget.Toast;

import java.util.Calendar;

public class TimerPickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        // Set Current time as default
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this,hour,minute,
                DateFormat.is24HourFormat(getActivity()));

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String ampm = hourOfDay > 12 ? "PM" : "AM";
        String timeString = hourOfDay + ":" + minute + ":00 " + ampm;
        Toast.makeText(getActivity(), ""+timeString, Toast.LENGTH_SHORT).show();
    }
}