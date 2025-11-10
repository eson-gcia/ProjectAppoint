package com.example.projectappoint.utils;

import android.annotation.SuppressLint;

import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtils {
    @SuppressLint("StaticFieldLeak")
    private static FirebaseFirestore firestore;

    private FirebaseUtils() { }

    public static FirebaseFirestore getFirestore() {
        if (firestore == null) firestore = FirebaseFirestore.getInstance();
        return firestore;
    }
}
