package com.example.stannard.therapybox;

import android.graphics.Bitmap;

/**
 * Created by keir on 14/02/2018.
 */
public class User {

    private String username, password, email;
    private Bitmap userImage;

    public User(String password, String username, String email, Bitmap userImage) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.userImage = userImage;
    }

    public String getUsername() {
        return username;
    }

    public Bitmap getUserImage() {
        return userImage;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return username + ", " + email + ", " + password;
    }
}
