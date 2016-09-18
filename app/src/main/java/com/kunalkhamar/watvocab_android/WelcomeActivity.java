package com.kunalkhamar.watvocab_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
