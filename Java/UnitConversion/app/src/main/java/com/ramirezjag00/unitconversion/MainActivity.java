package com.ramirezjag00.unitconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.digidemic.unitof.UnitOf;

public class MainActivity extends AppCompatActivity {
    Resources res;
    String activeTypeUnit;
    String activeFromUnit;
    String activeToUnit;
    Spinner typeUnitSpinner;
    Spinner fromUnitSpinner;
    Spinner toUnitSpinner;
    EditText number;
    TextView convertedNumber;
    ArrayAdapter<CharSequence> typeUnitAdapter;
    ArrayAdapter<CharSequence> fromUnitAdapter;
    ArrayAdapter<CharSequence> toUnitAdapter;
    String[] typeUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeUnitSpinner = (Spinner) findViewById(R.id.typeUnit);
        fromUnitSpinner = (Spinner) findViewById(R.id.fromUnit);
        toUnitSpinner = (Spinner) findViewById(R.id.toUnit);
        number = findViewById(R.id.number);
        convertedNumber = findViewById(R.id.convertedNumber);
        res = getResources();
        typeUnits = res.getStringArray(R.array.type_units_array);

        onSetAdapter("type", R.array.type_units_array);

        typeUnitSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                activeTypeUnit = adapterView.getItemAtPosition(i).toString();
                onSetSubSpinners();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                activeTypeUnit = adapterView.getItemAtPosition(0).toString();
            }
        });

        onSetAdapter("from", R.array.temp_units_array);
        onSetAdapter("to", R.array.temp_units_array);

        fromUnitSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                activeFromUnit = adapterView.getItemAtPosition(i).toString();
                onSetConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                activeFromUnit = adapterView.getItemAtPosition(0).toString();
            }
        });

        toUnitSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                activeToUnit = adapterView.getItemAtPosition(i).toString();
                onSetConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                activeToUnit = adapterView.getItemAtPosition(1).toString();
            }
        });

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onSetConversion();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    public void onSetConversion() {
        // Getting input from EditText
        String numString = number.getText().toString();

        if (numString.isEmpty() || numString == null) {
            convertedNumber.setText("0.0");
        } else if (activeFromUnit.equals(activeToUnit)) {
            convertedNumber.setText(numString);
        } else {
            double numValue = Double.parseDouble(numString);
            double convertedValue = getConvertedValue(numValue);
            convertedNumber.setText(Double.toString(convertedValue));
        }
    }

    public void onSetSubSpinners() {
        Integer arrayResId;

        if (activeTypeUnit.equals(typeUnits[0])) {
            arrayResId = R.array.temp_units_array;
        } else if (activeTypeUnit.equals(typeUnits[1])) {
            arrayResId = R.array.length_units_array;
        } else if (activeTypeUnit.equals(typeUnits[2])) {
            arrayResId = R.array.time_units_array;
        } else if (activeTypeUnit.equals(typeUnits[3])) {
            arrayResId = R.array.volume_units_array;
        } else if (activeTypeUnit.equals(typeUnits[4])) {
            arrayResId = R.array.mass_units_array;
        } else {
            throw new IllegalStateException("Unexpected value: " + activeTypeUnit);
        }

        onSetAdapter("from", arrayResId);
        onSetAdapter("to", arrayResId);
        onSetConversion();
    }

    public void onSetAdapter(String dropdownType, Integer res) {
        if (dropdownType.equals("type")) {
            // Create an ArrayAdapter using the string array and a default spinner layout
            typeUnitAdapter = ArrayAdapter.createFromResource(this,
                    res, android.R.layout.simple_spinner_item);

            // Specify the layout to use when the list of choices appears
            typeUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Apply the adapter to the spinner
            typeUnitSpinner.setAdapter(typeUnitAdapter);
        } else if (dropdownType.equals("from")) {
            // Create an ArrayAdapter using the string array and a default spinner layout
            fromUnitAdapter = ArrayAdapter.createFromResource(this,
                    res, android.R.layout.simple_spinner_item);

            // Specify the layout to use when the list of choices appears
            fromUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Apply the adapter to the spinner
            fromUnitSpinner.setAdapter(fromUnitAdapter);
            fromUnitSpinner.setSelection(0);
        } else if (dropdownType.equals("to")) {
            // Create an ArrayAdapter using the string array and a default spinner layout
            toUnitAdapter = ArrayAdapter.createFromResource(this,
                    res, android.R.layout.simple_spinner_item);

            // Specify the layout to use when the list of choices appears
            toUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Apply the adapter to the spinner
            toUnitSpinner.setAdapter(toUnitAdapter);
            toUnitSpinner.setSelection(1);
        }
    }

    public double getConvertedValue(double value) {
        double convertedValue = 0.0;

        if (activeTypeUnit.equals(typeUnits[0])) {
            UnitOf.Temperature unit = new UnitOf.Temperature();
            String[] tempUnits = res.getStringArray(R.array.temp_units_array);

            if (activeFromUnit.equals(tempUnits[0])) {
                unit = unit.fromCelsius(value);
            } else if (activeFromUnit.equals(tempUnits[1])) {
                unit = unit.fromFahrenheit(value);
            } else if (activeFromUnit.equals(tempUnits[2])) {
                unit = unit.fromKelvin(value);
            }

            if (activeToUnit.equals(tempUnits[0])) {
                convertedValue = unit.toCelsius();
            } else if (activeToUnit.equals(tempUnits[1])) {
                convertedValue = unit.toFahrenheit();
            } else if (activeToUnit.equals(tempUnits[2])) {
                convertedValue = unit.toKelvin();
            }
        } else if (activeTypeUnit.equals(typeUnits[1])) {
            UnitOf.Length unit = new UnitOf.Length();
            String[] lengthUnits = res.getStringArray(R.array.length_units_array);

            if (activeFromUnit.equals(lengthUnits[0])) {
                unit = unit.fromMeters(value);
            } else if (activeFromUnit.equals(lengthUnits[1])) {
                unit = unit.fromKilometers(value);
            } else if (activeFromUnit.equals(lengthUnits[2])) {
                unit = unit.fromFeet(value);
            } else if (activeFromUnit.equals(lengthUnits[3])) {
                unit = unit.fromYards(value);
            } else if (activeFromUnit.equals(lengthUnits[4])) {
                unit = unit.fromMiles(value);
            }

            if (activeToUnit.equals(lengthUnits[0])) {
                convertedValue = unit.toMeters();
            } else if (activeToUnit.equals(lengthUnits[1])) {
                convertedValue = unit.toKilometers();
            } else if (activeToUnit.equals(lengthUnits[2])) {
                convertedValue = unit.toFeet();
            } else if (activeToUnit.equals(lengthUnits[3])) {
                convertedValue = unit.toYards();
            } else if (activeToUnit.equals(lengthUnits[4])) {
                convertedValue = unit.toMiles();
            }
        } else if (activeTypeUnit.equals(typeUnits[2])) {
            UnitOf.Time unit = new UnitOf.Time();
            String[] timeUnits = res.getStringArray(R.array.time_units_array);

            if (activeFromUnit.equals(timeUnits[0])) {
                unit = unit.fromSeconds(value);
            } else if (activeFromUnit.equals(timeUnits[1])) {
                unit = unit.fromMinutes(value);
            } else if (activeFromUnit.equals(timeUnits[2])) {
                unit = unit.fromHours(value);
            }

            if (activeToUnit.equals(timeUnits[0])) {
                convertedValue = unit.toSeconds();
            } else if (activeToUnit.equals(timeUnits[1])) {
                convertedValue = unit.toMinutes();
            } else if (activeToUnit.equals(timeUnits[2])) {
                convertedValue = unit.toHours();
            }
        } else if (activeTypeUnit.equals(typeUnits[3])) {
            UnitOf.Volume unit = new UnitOf.Volume();
            String[] volumeUnits = res.getStringArray(R.array.volume_units_array);

            if (activeFromUnit.equals(volumeUnits[0])) {
                unit = unit.fromMilliliters(value);
            } else if (activeFromUnit.equals(volumeUnits[1])) {
                unit = unit.fromLiters(value);
            } else if (activeFromUnit.equals(volumeUnits[2])) {
                unit = unit.fromCupsUS(value);
            } else if (activeFromUnit.equals(volumeUnits[3])) {
                unit = unit.fromPintsUS(value);
            } else if (activeFromUnit.equals(volumeUnits[4])) {
                unit = unit.fromFluidOuncesUS(value);
            } else if (activeFromUnit.equals(volumeUnits[5])) {
                unit = unit.fromGallonsUS(value);
            }

            if (activeToUnit.equals(volumeUnits[0])) {
                convertedValue = unit.toMilliliters();
            } else if (activeToUnit.equals(volumeUnits[1])) {
                convertedValue = unit.toLiters();
            } else if (activeToUnit.equals(volumeUnits[2])) {
                convertedValue = unit.toCupsUS();
            } else if (activeToUnit.equals(volumeUnits[3])) {
                convertedValue = unit.toPintsUS();
            } else if (activeToUnit.equals(volumeUnits[4])) {
                convertedValue = unit.toFluidOuncesUS();
            } else if (activeToUnit.equals(volumeUnits[5])) {
                convertedValue = unit.toGallonsUS();
            }
        } else if (activeTypeUnit.equals(typeUnits[4])) {
            UnitOf.Mass unit = new UnitOf.Mass();
            String[] massUnits = res.getStringArray(R.array.mass_units_array);

            if (activeFromUnit.equals(massUnits[0])) {
                unit = unit.fromGrams(value);
            } else if (activeFromUnit.equals(massUnits[1])) {
                unit = unit.fromKilograms(value);
            } else if (activeFromUnit.equals(massUnits[2])) {
                unit = unit.fromPounds(value);
            } else if (activeFromUnit.equals(massUnits[3])) {
                unit = unit.fromTonsMetric(value);
            }

            if (activeToUnit.equals(massUnits[0])) {
                convertedValue = unit.toGrams();
            } else if (activeToUnit.equals(massUnits[1])) {
                convertedValue = unit.toKilograms();
            } else if (activeToUnit.equals(massUnits[2])) {
                convertedValue = unit.toPounds();
            } else if (activeToUnit.equals(massUnits[3])) {
                convertedValue = unit.toTonsMetric();
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + activeTypeUnit);
        }

        return convertedValue;
    }
}