package com.app.pgbooking.ui.pgrooms.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gautam on 26/03/18.
 */

public class PgData implements Parcelable {

    private String pgId;

    private String name;

    private String lat;

    private String lng;

    private String address;

    @SerializedName("rent_ac")
    private String rentAc;

    @SerializedName("rent_non")
    private String rentNonAc;

    private String thumbnail;

    private List<String> images;

    private String ownerName;

    private String ownerNumber;

    private String ownerEmail;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pgId);
        dest.writeString(this.name);
        dest.writeString(this.lat);
        dest.writeString(this.lng);
        dest.writeString(this.address);
        dest.writeString(this.rentAc);
        dest.writeString(this.rentNonAc);
        dest.writeString(this.thumbnail);
        dest.writeStringList(this.images);
        dest.writeString(this.ownerName);
        dest.writeString(this.ownerNumber);
        dest.writeString(this.ownerEmail);
    }

    public PgData() {
    }

    protected PgData(Parcel in) {
        this.pgId = in.readString();
        this.name = in.readString();
        this.lat = in.readString();
        this.lng = in.readString();
        this.address = in.readString();
        this.rentAc = in.readString();
        this.rentNonAc = in.readString();
        this.images = in.createStringArrayList();
        this.ownerName = in.readString();
        this.ownerNumber = in.readString();
        this.ownerEmail = in.readString();
    }

    public static final Parcelable.Creator<PgData> CREATOR = new Parcelable.Creator<PgData>() {
        @Override
        public PgData createFromParcel(Parcel source) {
            return new PgData(source);
        }

        @Override
        public PgData[] newArray(int size) {
            return new PgData[size];
        }
    };

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPgId() {
        return pgId;
    }

    public void setPgId(String pgId) {
        this.pgId = pgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRentAc() {
        return rentAc;
    }

    public String getRentNonAc() {
        return rentNonAc;
    }

    public void setRentAc(String rentAc) {
        this.rentAc = rentAc;
    }

    public void setRentNonAc(String rentNonAc) {
        this.rentNonAc = rentNonAc;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
