package com.kunalkhamar.watvocab_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewVocabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vocab);

        this.addSpinners();
    }

    private void addSpinners(){
        Spinner frontSpinner = (Spinner) findViewById(R.id.spinner_front_language);
        ArrayAdapter<CharSequence> frontAdapter = ArrayAdapter.createFromResource(this,
                R.array.Languages, android.R.layout.simple_spinner_item);
        frontAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frontSpinner.setAdapter(frontAdapter);

        Spinner backSpinner = (Spinner) findViewById(R.id.spinner_back_language);
        ArrayAdapter<CharSequence> backAdapter = ArrayAdapter.createFromResource(this,
                R.array.Languages, android.R.layout.simple_spinner_item);
        backAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backSpinner.setAdapter(backAdapter);
    }
}
