package com.app.pgbooking.ui.pgdetails.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gautam on 21/04/18.
 */

public class RoomDetailsDataResponse implements Parcelable {

    @SerializedName("data")
    private List<RoomDetailsData> data = null;

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    protected RoomDetailsDataResponse(Parcel in) {
        data = in.createTypedArrayList(RoomDetailsData.CREATOR);
        status = in.readByte() != 0;
        message = in.readString();
    }

    public static final Creator<RoomDetailsDataResponse> CREATOR = new Creator<RoomDetailsDataResponse>() {
        @Override
        public RoomDetailsDataResponse createFromParcel(Parcel in) {
            return new RoomDetailsDataResponse(in);
        }

        @Override
        public RoomDetailsDataResponse[] newArray(int size) {
            return new RoomDetailsDataResponse[size];
        }
    };

    public List<RoomDetailsData> getData() {
        return data;
    }

    public void setData(List<RoomDetailsData> data) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(data);
        parcel.writeByte((byte) (status ? 1 : 0));
        parcel.writeString(message);
    }
}
