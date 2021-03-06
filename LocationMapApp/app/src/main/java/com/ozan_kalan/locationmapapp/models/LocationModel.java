package com.ozan_kalan.locationmapapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ozan.kalan on 6/28/17.
 * <p>
 * This class represents the location objects that are returned from the json
 */

public class LocationModel implements Parcelable {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("ArrivalTime")
    @Expose
    private String arrivalTime;

    public final static Parcelable.Creator<LocationModel> CREATOR = new Creator<LocationModel>() {

        @SuppressWarnings({"unchecked"})
        public LocationModel createFromParcel(Parcel in) {
            LocationModel instance = new LocationModel();
            instance.iD = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.latitude = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.longitude = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.address = ((String) in.readValue((String.class.getClassLoader())));
            instance.arrivalTime = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public LocationModel[] newArray(int size) {
            return (new LocationModel[size]);
        }

    };

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(iD);
        dest.writeValue(name);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(address);
        dest.writeValue(arrivalTime);
    }
}
