package com.kunalkhamar.watvocab_android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewVocabActivity extends AppCompatActivity {
    public static final String VOCAB_NAME = "vocabName";
    public static final String FRONT_LANG = "frontLang";
    public static final String BACK_LANG = "backLang";

    private EditText vocabName;
    private Spinner frontSpinner;
    private Spinner backSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vocab);

        vocabName = (EditText) findViewById(R.id.edit_text_vocab_name);


        this.addSpinners();
    }

    private void addSpinners(){
        frontSpinner = (Spinner) findViewById(R.id.spinner_front_language);
        ArrayAdapter<CharSequence> frontAdapter = ArrayAdapter.createFromResource(this,
                R.array.Languages, android.R.layout.simple_spinner_item);
        frontAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frontSpinner.setAdapter(frontAdapter);

        backSpinner = (Spinner) findViewById(R.id.spinner_back_language);
        ArrayAdapter<CharSequence> backAdapter = ArrayAdapter.createFromResource(this,
                R.array.Languages, android.R.layout.simple_spinner_item);
        backAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backSpinner.setAdapter(backAdapter);
    }

    public void openVocabActivity(View view){
        int frontLangPosition = frontSpinner.getSelectedItemPosition();
        int backLangPosition = backSpinner.getSelectedItemPosition();
        String vocabNameString = vocabName.getText().toString();

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text;

        if (vocabNameString.isEmpty()){
            text = "Vocab Name cannot be empty";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if(frontLangPosition == 0 || backLangPosition == 0){
            text = "Please Select" + (frontLangPosition == 0 ? " Front " : " Back ")
                    + "Language";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if(frontLangPosition == backLangPosition) {
            text = "Front language and Back Language should be different";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Intent intent = new Intent(NewVocabActivity.this, VocabActivity.class);
            intent.putExtra(VOCAB_NAME, vocabName.getText().toString());
            intent.putExtra(FRONT_LANG, frontSpinner.getSelectedItem().toString());
            intent.putExtra(BACK_LANG, backSpinner.getSelectedItem().toString());

            startActivity(intent);
        }
    }
}
