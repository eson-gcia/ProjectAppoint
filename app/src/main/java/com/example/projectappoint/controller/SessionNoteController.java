package com.example.projectappoint.controller;

import com.google.firebase.firestore.FieldValue;
import com.example.projectappoint.utils.FirebaseUtils;
import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller class for managing session notes in Firestore.
 * Handles all CRUD operations related to session notes.
 */
public class SessionNoteController {
    private static final String SESSION_NOTES_COLLECTION = "sessionNotes";
    private static final String THERAPIST_ID_FIELD = "therapistId";
    private static final String PATIENT_ID_FIELD = "patientId";
    private static final String CONTENT_FIELD = "content";
    private static final String TIMESTAMP_FIELD = "timestamp";

    /**
     * Callback interface for session note operations
     */
    public interface SessionNoteCallback {
        /**
         * Called when the operation completes successfully
         * @param message Success message
         */
        void onSuccess(String message);

        /**
         * Called when the operation fails
         * @param error Error message
         */
        void onFailure(String error);
    }

    /**
     * Adds a new session note
     * @param therapistId ID of the therapist creating the note
     * @param patientId ID of the patient the note is about
     * @param content Content of the note
     * @param callback Callback for operation result
     * @throws IllegalArgumentException if any required parameter is null or empty
     */
    public void addSessionNote(@NonNull String therapistId, 
                              @NonNull String patientId, 
                              @NonNull String content,
                              @NonNull SessionNoteCallback callback) {
        if (therapistId.trim().isEmpty() || patientId.trim().isEmpty()) {
            callback.onFailure("Therapist ID and Patient ID cannot be empty");
            return;
        }
        
        if (content.trim().isEmpty()) {
            callback.onFailure("Note content cannot be empty");
            return;
        }

        Map<String, Object> note = new HashMap<>();
        note.put(THERAPIST_ID_FIELD, therapistId);
        note.put(PATIENT_ID_FIELD, patientId);
        note.put(CONTENT_FIELD, content.trim());
        note.put(TIMESTAMP_FIELD, FieldValue.serverTimestamp());

        FirebaseUtils.getFirestore()
                .collection(SESSION_NOTES_COLLECTION)
                .add(note)
                .addOnSuccessListener(ref -> callback.onSuccess("Note added successfully."))
                .addOnFailureListener(e -> callback.onFailure("Failed to add note: " + e.getMessage()));
    }

    /**
     * Updates an existing session note
     * @param noteId ID of the note to update
     * @param newContent New content for the note
     * @param callback Callback for operation result
     * @throws IllegalArgumentException if any parameter is null or empty
     */
    public void editSessionNote(@NonNull String noteId,
                               @NonNull String newContent,
                               @NonNull SessionNoteCallback callback) {
        if (noteId.trim().isEmpty()) {
            callback.onFailure("Note ID cannot be empty");
            return;
        }
        
        if (newContent.trim().isEmpty()) {
            callback.onFailure("Note content cannot be empty");
            return;
        }

        Map<String, Object> updates = new HashMap<>();
        updates.put(CONTENT_FIELD, newContent.trim());
        updates.put(TIMESTAMP_FIELD, FieldValue.serverTimestamp());

        FirebaseUtils.getFirestore()
                .collection(SESSION_NOTES_COLLECTION)
                .document(noteId)
                .update(updates)
                .addOnSuccessListener(aVoid -> callback.onSuccess("Note updated successfully."))
                .addOnFailureListener(e -> callback.onFailure("Failed to update note: " + e.getMessage()));
    }

    /**
     * Deletes a session note
     * @param noteId ID of the note to delete
     * @param callback Callback for operation result
     * @throws IllegalArgumentException if noteId is null or empty
     */
    public void deleteSessionNote(@NonNull String noteId,
                                 @NonNull SessionNoteCallback callback) {
        if (noteId.trim().isEmpty()) {
            callback.onFailure("Note ID cannot be empty");
            return;
        }

        FirebaseUtils.getFirestore()
                .collection(SESSION_NOTES_COLLECTION)
                .document(noteId)
                .delete()
                .addOnSuccessListener(aVoid -> callback.onSuccess("Note deleted successfully."))
                .addOnFailureListener(e -> callback.onFailure("Failed to delete note: " + e.getMessage()));
    }
}
