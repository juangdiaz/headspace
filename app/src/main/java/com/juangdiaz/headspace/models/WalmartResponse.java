package com.juangdiaz.headspace.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class WalmartResponse implements Parcelable {

    private String format;
    private String nextPage;
    private String totalPages;
    private List<Items> items;

    public static Creator<WalmartResponse> CREATOR = new Creator<WalmartResponse>() {

        @Override
        public WalmartResponse createFromParcel(Parcel source) {

            return new WalmartResponse(source);
        }

        @Override
        public WalmartResponse[] newArray(int size) {

            return new WalmartResponse[size];
        }
    };

    public WalmartResponse() {}


    public WalmartResponse(Parcel parcel) {

        format = parcel.readString();
        nextPage = parcel.readString();
        totalPages = parcel.readString();

        items = new ArrayList<>();
        parcel.readList(items, Items.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(format);
        parcel.writeString(nextPage);
        parcel.writeString(totalPages);
        parcel.writeTypedList(items);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
