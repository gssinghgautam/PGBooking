package com.app.pgbooking.ui.pgrooms.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gautam on 20/04/18.
 */

public class RoomDataResponse implements Parcelable {

    @SerializedName("data")
    private List<RoomData> data = null;

    @SerializedName("status")
    private Boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("page")
    private Integer page;

    public List<RoomData> getData() {
        return data;
    }

    public void setData(List<RoomData> data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.data);
        dest.writeValue(this.status);
        dest.writeString(this.message);
        dest.writeValue(this.page);
    }

    public RoomDataResponse() {
    }

    protected RoomDataResponse(Parcel in) {
        this.data = in.createTypedArrayList(RoomData.CREATOR);
        this.status = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.message = in.readString();
        this.page = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<RoomDataResponse> CREATOR = new Parcelable.Creator<RoomDataResponse>() {
        @Override
        public RoomDataResponse createFromParcel(Parcel source) {
            return new RoomDataResponse(source);
        }

        @Override
        public RoomDataResponse[] newArray(int size) {
            return new RoomDataResponse[size];
        }
    };
}
