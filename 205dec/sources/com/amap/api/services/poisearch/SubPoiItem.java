package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new Parcelable.Creator<SubPoiItem>() { // from class: com.amap.api.services.poisearch.SubPoiItem.1
        private static SubPoiItem a(Parcel parcel) {
            return new SubPoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItem[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11214a;

    /* renamed from: b  reason: collision with root package name */
    private String f11215b;

    /* renamed from: c  reason: collision with root package name */
    private String f11216c;

    /* renamed from: d  reason: collision with root package name */
    private int f11217d;

    /* renamed from: e  reason: collision with root package name */
    private LatLonPoint f11218e;

    /* renamed from: f  reason: collision with root package name */
    private String f11219f;

    /* renamed from: g  reason: collision with root package name */
    private String f11220g;

    public SubPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f11214a = str;
        this.f11218e = latLonPoint;
        this.f11215b = str2;
        this.f11219f = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f11217d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f11218e;
    }

    public String getPoiId() {
        return this.f11214a;
    }

    public String getSnippet() {
        return this.f11219f;
    }

    public String getSubName() {
        return this.f11216c;
    }

    public String getSubTypeDes() {
        return this.f11220g;
    }

    public String getTitle() {
        return this.f11215b;
    }

    public void setDistance(int i4) {
        this.f11217d = i4;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f11218e = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f11214a = str;
    }

    public void setSnippet(String str) {
        this.f11219f = str;
    }

    public void setSubName(String str) {
        this.f11216c = str;
    }

    public void setSubTypeDes(String str) {
        this.f11220g = str;
    }

    public void setTitle(String str) {
        this.f11215b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11214a);
        parcel.writeString(this.f11215b);
        parcel.writeString(this.f11216c);
        parcel.writeInt(this.f11217d);
        parcel.writeValue(this.f11218e);
        parcel.writeString(this.f11219f);
        parcel.writeString(this.f11220g);
    }

    public SubPoiItem(Parcel parcel) {
        this.f11214a = parcel.readString();
        this.f11215b = parcel.readString();
        this.f11216c = parcel.readString();
        this.f11217d = parcel.readInt();
        this.f11218e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f11219f = parcel.readString();
        this.f11220g = parcel.readString();
    }
}
