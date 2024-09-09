package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new Parcelable.Creator<SearchCity>() { // from class: com.amap.api.services.route.SearchCity.1
        private static SearchCity a(Parcel parcel) {
            return new SearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SearchCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SearchCity[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11530a;

    /* renamed from: b  reason: collision with root package name */
    private String f11531b;

    /* renamed from: c  reason: collision with root package name */
    private String f11532c;

    public SearchCity(Parcel parcel) {
        this.f11530a = parcel.readString();
        this.f11531b = parcel.readString();
        this.f11532c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.f11532c;
    }

    public String getSearchCityName() {
        return this.f11530a;
    }

    public String getSearchCitycode() {
        return this.f11531b;
    }

    public void setSearchCityName(String str) {
        this.f11530a = str;
    }

    public void setSearchCitycode(String str) {
        this.f11531b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.f11532c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11530a);
        parcel.writeString(this.f11531b);
        parcel.writeString(this.f11532c);
    }

    public SearchCity() {
    }
}
