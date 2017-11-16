package com.mocoteam1.musicmatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    //Test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.loginActivityOkButton);
        final TextView welcomeText = (TextView) findViewById(R.id.loginActivityWelcome);
        final TextView loginErrorText = (TextView) findViewById(R.id.loginActivityLoginError);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verifyLoginData()) {
                    Intent i = new Intent(LoginActivity.this, ShareSong.class);
                    startActivity(i);
                } else {
                    loginErrorText.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    //DummyFunction
    private boolean verifyLoginData() {
        Log.d(TAG, "Login Daten werden verifiziert");
        Random generator = new Random();
        if(generator.nextInt(2) == 0) {
            Log.d(TAG, "Verifizierung erfolgreich");
            return true;
        } else {
            Log.d(TAG, "Verifizierung nicht erfolgreich");
            return false;
        }
    }
}
