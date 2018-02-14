package com.example.stannard.therapybox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton registerButton;
    private EditText usernameEditText, passwordEditText, confPasswordEditText, emailEditText;
    private TextView addPictureTextView;
    private ImageView pictureImageView;
    private int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        pictureImageView = (ImageView) findViewById(R.id.userImageButton);
        registerButton = (ImageButton) findViewById(R.id.registerButton);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        confPasswordEditText = (EditText) findViewById(R.id.confPasswordEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        addPictureTextView = (TextView) findViewById(R.id.addPictureLinkTextView);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkUserEntry()) {
                    User user = getNewUser();
                    makeToast(user.toString());
                }
            }
        });

        addPictureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));
                pictureImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public User getNewUser() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String email = emailEditText.getText().toString();
        Bitmap bitmap = ((BitmapDrawable) pictureImageView.getDrawable()).getBitmap();

        User user = new User(username, password, email, bitmap);
        return user;
    }

    public boolean checkUserEntry() {
        boolean result = false;
        if (usernameEditText.getText().toString() != "" && emailEditText.getText().toString() != "" &&
                 passwordEditText.getText().toString() != "" && confPasswordEditText.getText().toString() != "") {

            if (passwordEditText.getText().toString().equals(confPasswordEditText.getText().toString())) {
                if (emailEditText.getText().toString().contains("@")) {
                    result = true;
                }
                else {
                    makeToast("Invalid email address");
                }
            }
            else {
                makeToast("Passwords do not match");
                System.out.println(passwordEditText.getText().toString() + ", " + confPasswordEditText.getText().toString());
            }
        }
        else {
            makeToast("Invalid user info");
        }
        return result;
    }
}
