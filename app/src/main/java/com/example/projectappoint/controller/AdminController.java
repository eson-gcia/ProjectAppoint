package com.example.projectappoint.controller;

import com.example.projectappoint.utils.FirebaseUtils;
import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller class for handling administrative operations in the application.
 * This includes approving therapists, suspending users, and deleting user accounts.
 */
public class AdminController {
    private static final String USERS_COLLECTION = "users";
    private static final String SUSPENDED_FIELD = "suspended";
    private static final String REASON_FIELD = "reason";

    /**
     * Callback interface for admin operations
     */
    public interface AdminCallback {
        /**
         * Called when the admin operation completes successfully
         * @param message Success message
         */
        void onSuccess(String message);

        /**
         * Called when the admin operation fails
         * @param error Error message
         */
        void onFailure(String error);
    }

    /**
     * Suspends a user account with an optional reason
     * @param userId ID of the user to suspend
     * @param reason Reason for suspension (can be null or empty)
     * @param callback Callback for operation result
     * @throws IllegalArgumentException if userId is null or empty
     */
    public void suspendUser(@NonNull String userId, 
                           @NonNull String reason, 
                           @NonNull AdminCallback callback) {
        if (userId.trim().isEmpty()) {
            callback.onFailure("User ID cannot be empty");
            return;
        }

        Map<String, Object> updates = new HashMap<>();
        updates.put(SUSPENDED_FIELD, true);
        
        if (!reason.trim().isEmpty()) {
            updates.put(REASON_FIELD, reason.trim());
        }

        FirebaseUtils.getFirestore()
                .collection(USERS_COLLECTION)
                .document(userId)
                .update(updates)
                .addOnSuccessListener(aVoid -> callback.onSuccess("User has been suspended."))
                .addOnFailureListener(e -> callback.onFailure("Failed to suspend user: " + e.getMessage()));
    }

    /**
     * Deletes a user account
     * @param userId ID of the user to delete
     * @param callback Callback for operation result
     * @throws IllegalArgumentException if userId is null or empty
     */
    public void deleteUser(@NonNull String userId, @NonNull AdminCallback callback) {
        if (userId.trim().isEmpty()) {
            callback.onFailure("User ID cannot be empty");
            return;
        }

        // In a production app, you might want to:
        // 1. First check if the user exists
        // 2. Optionally archive the data instead of hard delete
        // 3. Handle related data cleanup
        FirebaseUtils.getFirestore()
                .collection(USERS_COLLECTION)
                .document(userId)
                .delete()
                .addOnSuccessListener(aVoid -> callback.onSuccess("User account has been deleted."))
                .addOnFailureListener(e -> callback.onFailure("Failed to delete user: " + e.getMessage()));
    }
}
