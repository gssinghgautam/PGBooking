package com.app.pgbooking.storage;

import android.graphics.Bitmap;

import com.app.pgbooking.Constants;
import com.app.pgbooking.rx.FirebaseObservableListeners;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;

import rx.Observable;

/**
 * Created by marco on 18/08/16.
 */

public class FirebaseStorageService implements StorageService {

    private final StorageReference firebaseStorage;

    private final FirebaseObservableListeners firebaseObservableListeners;


    public FirebaseStorageService(FirebaseStorage firebaseStorage, FirebaseObservableListeners firebaseObservableListeners) {
        this.firebaseStorage = firebaseStorage.getReference();
        this.firebaseObservableListeners = firebaseObservableListeners;
    }

    @Override
    public StorageReference getProfileImageReference(String image) {
        return firebaseStorage.child(image);
    }

    @Override
    public StorageReference getPgImageReference(String image) {
        return firebaseStorage.child(Constants.FIREBASE_PGS_IMAGES).child(image);
    }

    @Override
    public Observable<String> uploadImage(Bitmap bitmap) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
        byte[] data = baos.toByteArray();
        final String imageRef = bitmap.hashCode() + System.currentTimeMillis() + ".jpg";

        return firebaseObservableListeners.uploadTask(data, firebaseStorage.child(imageRef), imageRef);
    }

    @Override
    public void removeImage(String image) {
        firebaseStorage.child(image).delete();
    }

}
