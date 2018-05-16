package com.app.pgbooking.ui.pgdetails.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.app.pgbooking.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gautam on 21/04/18.
 */

public class RoomDetailsData implements Parcelable {

    @SerializedName("id")
    private String id;

    @SerializedName("post_address")
    private String postAddress;

    @SerializedName("post_city")
    private String postCity;

    @SerializedName("post_zip")
    private String postZip;

    @SerializedName("post_for")
    private String postFor;

    @SerializedName("post_dp")
    private String postDp;

    @SerializedName("post_rent")
    private String postRent;

    @SerializedName("post_photo_featured")
    private String postPhotoFeatured;

    @SerializedName("post_maintenance_amount")
    private String postMaintenanceAmount;

    @SerializedName("post_photo_1")
    private String postPhoto1;

    @SerializedName("post_photo_2")
    private String postPhoto2;

    @SerializedName("post_photo_3")
    private String postPhoto3;

    @SerializedName("post_title")
    private String postTitle;

    @SerializedName("post_info")
    private String postInfo;

    @SerializedName("post_bedrooms")
    private String postBedrooms;

    @SerializedName("post_bathrooms")
    private String postBathrooms;

    @SerializedName("post_wifi")
    private String postWifi;

    @SerializedName("post_lift")
    private String postLift;

    @SerializedName("post_parking")
    private String postParking;

    @SerializedName("post_gas")
    private String postGas;

    @SerializedName("post_per")
    private String postPer;

    @SerializedName("post_ownership_type")
    private String postOwnershipType;

    @SerializedName("post_property_type")
    private String postPropertyType;

    @SerializedName("post_contact_img")
    private String postContactImg;

    @SerializedName("post_contact_full_name")
    private String postContactFullName;

    @SerializedName("post_mobile")
    private String postMobile;

    @SerializedName("post_email")
    private String postEmail;

    @SerializedName("post_by")
    private String postBy;

    @SerializedName("post_status")
    private String postStatus;

    @SerializedName("post_date")
    private String postDate;

    @SerializedName("post_view")
    private String postView;

    @SerializedName("Latitude")
    private String latitude;

    @SerializedName("Longitude")
    private String longitude;

    @SerializedName("featured_post")
    private String featuredPost;

    @SerializedName("slider_post")
    private String sliderPost;

    protected RoomDetailsData(Parcel in) {
        id = in.readString();
        postAddress = in.readString();
        postCity = in.readString();
        postZip = in.readString();
        postFor = in.readString();
        postDp = in.readString();
        postRent = in.readString();
        postPhotoFeatured = in.readString();
        postMaintenanceAmount = in.readString();
        postPhoto1 = in.readString();
        postPhoto2 = in.readString();
        postPhoto3 = in.readString();
        postTitle = in.readString();
        postInfo = in.readString();
        postBedrooms = in.readString();
        postBathrooms = in.readString();
        postWifi = in.readString();
        postLift = in.readString();
        postParking = in.readString();
        postGas = in.readString();
        postPer = in.readString();
        postOwnershipType = in.readString();
        postPropertyType = in.readString();
        postContactImg = in.readString();
        postContactFullName = in.readString();
        postMobile = in.readString();
        postEmail = in.readString();
        postBy = in.readString();
        postStatus = in.readString();
        postDate = in.readString();
        postView = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        featuredPost = in.readString();
        sliderPost = in.readString();
    }

    public static final Creator<RoomDetailsData> CREATOR = new Creator<RoomDetailsData>() {
        @Override
        public RoomDetailsData createFromParcel(Parcel in) {
            return new RoomDetailsData(in);
        }

        @Override
        public RoomDetailsData[] newArray(int size) {
            return new RoomDetailsData[size];
        }
    };

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

    public String getPostZip() {
        return postZip;
    }

    public void setPostZip(String postZip) {
        this.postZip = postZip;
    }

    public String getPostFor() {
        return postFor;
    }

    public void setPostFor(String postFor) {
        this.postFor = postFor;
    }

    public String getPostDp() {
        return postDp;
    }

    public void setPostDp(String postDp) {
        this.postDp = postDp;
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

    public String getPostMaintenanceAmount() {
        return postMaintenanceAmount;
    }

    public void setPostMaintenanceAmount(String postMaintenanceAmount) {
        this.postMaintenanceAmount = postMaintenanceAmount;
    }

    public String getPostPhoto1() {
        return postPhoto1;
    }

    public void setPostPhoto1(String postPhoto1) {
        this.postPhoto1 = postPhoto1;
    }

    public String getPostPhoto2() {
        return postPhoto2;
    }

    public void setPostPhoto2(String postPhoto2) {
        this.postPhoto2 = postPhoto2;
    }

    public String getPostPhoto3() {
        return postPhoto3;
    }

    public void setPostPhoto3(String postPhoto3) {
        this.postPhoto3 = postPhoto3;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo;
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

    public String getPostWifi() {
        return postWifi;
    }

    public void setPostWifi(String postWifi) {
        this.postWifi = postWifi;
    }

    public String getPostLift() {
        return postLift;
    }

    public void setPostLift(String postLift) {
        this.postLift = postLift;
    }

    public String getPostParking() {
        return postParking;
    }

    public void setPostParking(String postParking) {
        this.postParking = postParking;
    }

    public String getPostGas() {
        return postGas;
    }

    public void setPostGas(String postGas) {
        this.postGas = postGas;
    }

    public String getPostPer() {
        return postPer;
    }

    public void setPostPer(String postPer) {
        this.postPer = postPer;
    }

    public String getPostOwnershipType() {
        return postOwnershipType;
    }

    public void setPostOwnershipType(String postOwnershipType) {
        this.postOwnershipType = postOwnershipType;
    }

    public String getPostPropertyType() {
        return postPropertyType;
    }

    public void setPostPropertyType(String postPropertyType) {
        this.postPropertyType = postPropertyType;
    }

    public String getPostContactImg() {
        return postContactImg;
    }

    public void setPostContactImg(String postContactImg) {
        this.postContactImg = postContactImg;
    }

    public String getPostContactFullName() {
        return postContactFullName;
    }

    public void setPostContactFullName(String postContactFullName) {
        this.postContactFullName = postContactFullName;
    }

    public String getPostMobile() {
        return postMobile;
    }

    public void setPostMobile(String postMobile) {
        this.postMobile = postMobile;
    }

    public String getPostEmail() {
        return postEmail;
    }

    public void setPostEmail(String postEmail) {
        this.postEmail = postEmail;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostView() {
        return postView;
    }

    public void setPostView(String postView) {
        this.postView = postView;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getFeaturedPost() {
        return featuredPost;
    }

    public void setFeaturedPost(String featuredPost) {
        this.featuredPost = featuredPost;
    }

    public String getSliderPost() {
        return sliderPost;
    }

    public void setSliderPost(String sliderPost) {
        this.sliderPost = sliderPost;
    }

    public String getImage() {
        if (postPhotoFeatured.contains("https")) {
            return postPhotoFeatured;
        } else {
            return Constants.IMAGE_URL + postPhotoFeatured;
        }
    }

    public boolean isWifiAvailable() {
        return postWifi.equalsIgnoreCase("1");
    }

    public boolean isLiftAvailable() {
        return postLift.equalsIgnoreCase("1");
    }

    public boolean isParkingAvailable() {
        return postParking.equalsIgnoreCase("1");
    }

    public boolean isGasLineAvailable() {
        return postGas.equalsIgnoreCase("1");
    }

    public boolean isPostForGirls() {
        return postFor.equalsIgnoreCase("1");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(postAddress);
        parcel.writeString(postCity);
        parcel.writeString(postZip);
        parcel.writeString(postFor);
        parcel.writeString(postDp);
        parcel.writeString(postRent);
        parcel.writeString(postPhotoFeatured);
        parcel.writeString(postMaintenanceAmount);
        parcel.writeString(postPhoto1);
        parcel.writeString(postPhoto2);
        parcel.writeString(postPhoto3);
        parcel.writeString(postTitle);
        parcel.writeString(postInfo);
        parcel.writeString(postBedrooms);
        parcel.writeString(postBathrooms);
        parcel.writeString(postWifi);
        parcel.writeString(postLift);
        parcel.writeString(postParking);
        parcel.writeString(postGas);
        parcel.writeString(postPer);
        parcel.writeString(postOwnershipType);
        parcel.writeString(postPropertyType);
        parcel.writeString(postContactImg);
        parcel.writeString(postContactFullName);
        parcel.writeString(postMobile);
        parcel.writeString(postEmail);
        parcel.writeString(postBy);
        parcel.writeString(postStatus);
        parcel.writeString(postDate);
        parcel.writeString(postView);
        parcel.writeString(latitude);
        parcel.writeString(longitude);
        parcel.writeString(featuredPost);
        parcel.writeString(sliderPost);
    }
}
