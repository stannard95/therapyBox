package com.example.stannard.therapybox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton registerButton;
    private EditText usernameEditText, passwordEditText, confPasswordEditText, emailEditText;
    private TextView addPictureTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        registerButton = (ImageButton) findViewById(R.id.registerButton);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        confPasswordEditText = (EditText) findViewById(R.id.confPasswordEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        addPictureTextView = (TextView) findViewById(R.id.addPictureLinkTextView);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("Click");
            }
        });

    }
}
