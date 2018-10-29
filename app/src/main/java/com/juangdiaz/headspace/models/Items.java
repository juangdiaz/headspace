package com.juangdiaz.headspace.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Items implements Parcelable {

    private String largeImage;
    private String name;
    private double salePrice;

    public static Creator<Items> CREATOR = new Creator<Items>() {

        @Override
        public Items createFromParcel(Parcel source) {

            return new Items(source);
        }

        @Override
        public Items[] newArray(int size) {

            return new Items[size];
        }
    };

    public Items() {}


    public Items(Parcel parcel) {

        largeImage = parcel.readString();
        name = parcel.readString();
        salePrice = parcel.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(largeImage);
        parcel.writeString(name);
        parcel.writeDouble(salePrice);
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
