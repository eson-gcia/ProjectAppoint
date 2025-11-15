package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.Objects;


public class RegisterActivity extends AppCompatActivity {


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getIntent().getIntExtra("layout_id", R.layout.regis1);
        setContentView(layoutId);
    }




}
