package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new Parcelable.Creator<SearchCity>() { // from class: com.amap.api.services.route.SearchCity.1
        /* renamed from: a */
        private static SearchCity m51766a(Parcel parcel) {
            return new SearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SearchCity createFromParcel(Parcel parcel) {
            return m51766a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SearchCity[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7836a;

    /* renamed from: b */
    private String f7837b;

    /* renamed from: c */
    private String f7838c;

    public SearchCity(Parcel parcel) {
        this.f7836a = parcel.readString();
        this.f7837b = parcel.readString();
        this.f7838c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.f7838c;
    }

    public String getSearchCityName() {
        return this.f7836a;
    }

    public String getSearchCitycode() {
        return this.f7837b;
    }

    public void setSearchCityName(String str) {
        this.f7836a = str;
    }

    public void setSearchCitycode(String str) {
        this.f7837b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.f7838c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7836a);
        parcel.writeString(this.f7837b);
        parcel.writeString(this.f7838c);
    }

    public SearchCity() {
    }
}
