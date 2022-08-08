package com.ramirezjag00.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Options menu and app bar
        // Context menu and contextual action mode
        // Popup menu

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handling the item Selection
        switch (item.getItemId()) {
            case R.id.load:
                Toast.makeText(this, "Loading File...", Toast.LENGTH_LONG).show();
                break;

            case R.id.save:
                Toast.makeText(this, "Saving File...", Toast.LENGTH_LONG).show();
                break;

            case R.id.neww:
                Toast.makeText(this, "Creating New File...", Toast.LENGTH_LONG).show();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}