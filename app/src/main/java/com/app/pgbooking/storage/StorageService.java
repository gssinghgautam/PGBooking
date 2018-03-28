package com.app.pgbooking.storage;

import android.graphics.Bitmap;

import com.google.firebase.storage.StorageReference;

import rx.Observable;

/**
 * Created by marco on 18/08/16.
 */

public interface StorageService {

    StorageReference getProfileImageReference(String image);

    StorageReference getPgImageReference(String image);

    Observable<String> uploadImage(Bitmap bitmap);

    void removeImage(String image);

}
