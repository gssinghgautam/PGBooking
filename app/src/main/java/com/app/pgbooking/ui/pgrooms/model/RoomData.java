package com.app.pgbooking.ui.pgrooms.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.app.pgbooking.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gautam on 20/04/18.
 */

public class RoomData implements Parcelable {

    @SerializedName("id")
    private String id;

    @SerializedName("post_address")
    private String postAddress;

    @SerializedName("post_city")
    private String postCity;

    @SerializedName("post_rent")
    private String postRent;

    @SerializedName("post_photo_featured")
    private String postPhotoFeatured;

    @SerializedName("post_title")
    private String postTitle;

    @SerializedName("post_bedrooms")
    private String postBedrooms;

    @SerializedName("post_bathrooms")
    private String postBathrooms;

    @SerializedName("post_view")
    private String postView;

    @SerializedName("nativepost")
    private String nativepost;

    @SerializedName("type")
    private String type;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    @SerializedName("post_info")
    private String postInfo;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getPostCity() {
        return postCity;
    }

    public void setPostCity(String postCity) {
        this.postCity = postCity;
    }

    public String getPostRent() {
        return postRent;
    }

    public void setPostRent(String postRent) {
        this.postRent = postRent;
    }

    public String getPostPhotoFeatured() {
        return postPhotoFeatured;
    }

    public void setPostPhotoFeatured(String postPhotoFeatured) {
        this.postPhotoFeatured = postPhotoFeatured;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBedrooms() {
        return postBedrooms;
    }

    public void setPostBedrooms(String postBedrooms) {
        this.postBedrooms = postBedrooms;
    }

    public String getPostBathrooms() {
        return postBathrooms;
    }

    public void setPostBathrooms(String postBathrooms) {
        this.postBathrooms = postBathrooms;
    }

    public String getPostView() {
        return postView;
    }

    public void setPostView(String postView) {
        this.postView = postView;
    }

    public String getNativepost() {
        return nativepost;
    }

    public void setNativepost(String nativepost) {
        this.nativepost = nativepost;
    }

    public String getType() {
        return type;
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        if (postPhotoFeatured.contains("https")) {
            return postPhotoFeatured;
        } else {
            return Constants.IMAGE_URL + postPhotoFeatured;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.postAddress);
        dest.writeString(this.postCity);
        dest.writeString(this.postRent);
        dest.writeString(this.postPhotoFeatured);
        dest.writeString(this.postTitle);
        dest.writeString(this.postBedrooms);
        dest.writeString(this.postBathrooms);
        dest.writeString(this.postView);
        dest.writeString(this.nativepost);
        dest.writeString(this.type);
        dest.writeString(this.lat);
        dest.writeString(this.lng);
        dest.writeString(this.postInfo);
    }

    public RoomData() {
    }

    protected RoomData(Parcel in) {
        this.id = in.readString();
        this.postAddress = in.readString();
        this.postCity = in.readString();
        this.postRent = in.readString();
        this.postPhotoFeatured = in.readString();
        this.postTitle = in.readString();
        this.postBedrooms = in.readString();
        this.postBathrooms = in.readString();
        this.postView = in.readString();
        this.nativepost = in.readString();
        this.type = in.readString();
        this.lat = in.readString();
        this.lng = in.readString();
        this.postInfo = in.readString();
    }

    public static final Parcelable.Creator<RoomData> CREATOR = new Parcelable.Creator<RoomData>() {
        @Override
        public RoomData createFromParcel(Parcel source) {
            return new RoomData(source);
        }

        @Override
        public RoomData[] newArray(int size) {
            return new RoomData[size];
        }
    };
}
