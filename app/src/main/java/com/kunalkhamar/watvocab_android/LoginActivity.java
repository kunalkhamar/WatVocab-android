package com.kunalkhamar.watvocab_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {

    private CallbackManager facebookCallbackManager;
    private LoginButton facebookLoginButton;
    private EditText editTextUsername;
    private TextView textViewStatus;

    public static final String USER_ID = "userid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        facebookCallbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);
        facebookLoginButton = (LoginButton) findViewById(R.id.login_button);

        editTextUsername = (EditText) findViewById(R.id.editText_username);
        textViewStatus = (TextView) findViewById(R.id.login_status);

        facebookLoginButton.registerCallback(facebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                textViewStatus.setText("Login success");
                Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                intent.putExtra(USER_ID, loginResult.getAccessToken().getUserId());
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                textViewStatus.setText(R.string.login_aborted);
            }

            @Override
            public void onError(FacebookException error) {
                textViewStatus.setText(R.string.login_failed);
            }
        });
    }

    public void usernameLogin(View view) {
        textViewStatus.setText("Login success");
        Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
        intent.putExtra(USER_ID, editTextUsername.getText().toString());
        startActivity(intent);
    }
}
