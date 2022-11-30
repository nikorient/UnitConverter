//Денисов 303
package com.example.unitconverter.denisov303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerFrom;
    Spinner spinnerTo;
    EditText editTextFrom;
    TextView textViewTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        editTextFrom = findViewById(R.id.editTextFrom);
        textViewTo = findViewById(R.id.textViewTo);

        ArrayAdapter<String> arrayAdapter = new <String>ArrayAdapter(this, android.R.layout.simple_list_item_1);
        arrayAdapter.add("mm");
        arrayAdapter.add("cm");
        arrayAdapter.add("m");
        arrayAdapter.add("km");

        spinnerFrom.setAdapter(arrayAdapter);
        spinnerTo.setAdapter(arrayAdapter);
    }

    public void on_convert(View v) {
        float from = Float.parseFloat(editTextFrom.getText().toString());
        float to = 0.0f;

        String s1 = (String) spinnerFrom.getSelectedItem();
        String s2 = (String) spinnerTo.getSelectedItem();

        if (s1.equals("mm")) {
            if (s2.equals("mm")) to = from * 1.0f;
            if (s2.equals("cm")) to = from * 0.1f;
            if (s2.equals("m")) to = from * 0.001f;
            if (s2.equals("km")) to = from * 0.000001f;
        }

        if (s1.equals("cm")) {
            if (s2.equals("mm")) to = from * 10.0f;
            if (s2.equals("cm")) to = from * 1.0f;
            if (s2.equals("m")) to = from * 0.01f;
            if (s2.equals("km")) to = from * 0.00001f;
        }

        if (s1.equals("m")) {
            if (s2.equals("mm")) to = from * 1000.0f;
            if (s2.equals("cm")) to = from * 100.0f;
            if (s2.equals("m")) to = from * 1.0f;
            if (s2.equals("km")) to = from * 0.001f;
        }

        if (s1.equals("km")) {
            if (s2.equals("mm")) to = from * 1000000.0f;
            if (s2.equals("cm")) to = from * 100000.0f;
            if (s2.equals("m")) to = from * 1000.0f;
            if (s2.equals("km")) to = from * 1.0f;
        }

        textViewTo.setText(String.valueOf(to));
    }
}
//Денисов 303