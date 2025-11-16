package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        AppCompatEditText editTextE = findViewById(R.id.eTEmail);
        AppCompatEditText editTextPW = findViewById(R.id.etPassword);
        TextStylingUtils.setupHintAndTextWatcher(editTextE, "Email");
        TextStylingUtils.setupHintAndTextWatcher(editTextPW, "Password");

        TextView tvErrorEmail = findViewById(R.id.tvEmailError);
        TextView tvErrorPassword = findViewById(R.id.tvPasswordError);

        AppCompatButton buttonLogin = findViewById(R.id.btnLogin);
        buttonLogin.setOnClickListener(v -> {
            String email = Objects.requireNonNull(editTextE.getText()).toString().trim();
            String password = Objects.requireNonNull(editTextPW.getText()).toString().trim();
            boolean validateSuccess = true;

            if (email.isEmpty()) {
                TextStylingUtils.showAndFadeOut(tvErrorEmail, 3000);
                validateSuccess = false;
                editTextE.requestFocus();
            }

            if (password.isEmpty()) {
                TextStylingUtils.showAndFadeOut(tvErrorPassword, 3000);
                validateSuccess = false;
                editTextPW.requestFocus();
            }

            if (validateSuccess) {

            }
        });


    }
}
