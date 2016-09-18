package com.kunalkhamar.watvocab_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        String userid = intent.getStringExtra(LoginActivity.USER_ID);
        textView = (TextView) findViewById(R.id.textView_userid);
        textView.setText("Welcome " + userid);
    }

    public void createNewVocab(View view){
        Intent intent = new Intent(WelcomeActivity.this, NewVocabActivity.class);
        startActivity(intent);
    }
}
