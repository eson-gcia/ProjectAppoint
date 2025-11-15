package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        AppCompatEditText editTextE = findViewById(R.id.editTextE);
        InputStylingUtils.setupHintAndTextWatcher(editTextE, "Email");


        AppCompatEditText editTextPW = findViewById(R.id.editTextPW);
        InputStylingUtils.setupHintAndTextWatcher(editTextPW, "Password");
    }
}
