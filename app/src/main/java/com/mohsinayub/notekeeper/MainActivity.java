package com.mohsinayub.notekeeper;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            TextView textView = findViewById(R.id.text_value);
            String stringValue = textView.getText().toString();
            int originalValue = Integer.parseInt(stringValue);
            int newValue = MyWorker.doubleTheValue(originalValue);
            stringValue = Integer.toString(newValue);
            textView.setText(stringValue);

            final String message = "Changed value " + originalValue + " to " + newValue;
            Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();
        });
    }
}

class MyWorker {
    public static int doubleTheValue(int value) {
        return value * 2;
    }
}