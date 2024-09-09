package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new Parcelable.Creator<RoutePOIItem>() { // from class: com.amap.api.services.routepoisearch.RoutePOIItem.1
        private static RoutePOIItem a(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem[] newArray(int i4) {
            return a(i4);
        }

        private static RoutePOIItem[] a(int i4) {
            return new RoutePOIItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11596a;

    /* renamed from: b  reason: collision with root package name */
    private String f11597b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f11598c;

    /* renamed from: d  reason: collision with root package name */
    private float f11599d;

    /* renamed from: e  reason: collision with root package name */
    private float f11600e;

    /* renamed from: f  reason: collision with root package name */
    private String f11601f;

    public RoutePOIItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCPID() {
        return this.f11601f;
    }

    public float getDistance() {
        return this.f11599d;
    }

    public float getDuration() {
        return this.f11600e;
    }

    public String getID() {
        return this.f11596a;
    }

    public LatLonPoint getPoint() {
        return this.f11598c;
    }

    public String getTitle() {
        return this.f11597b;
    }

    public void setCPID(String str) {
        this.f11601f = str;
    }

    public void setDistance(float f4) {
        this.f11599d = f4;
    }

    public void setDuration(float f4) {
        this.f11600e = f4;
    }

    public void setID(String str) {
        this.f11596a = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f11598c = latLonPoint;
    }

    public void setTitle(String str) {
        this.f11597b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11596a);
        parcel.writeString(this.f11597b);
        parcel.writeParcelable(this.f11598c, i4);
        parcel.writeFloat(this.f11599d);
        parcel.writeFloat(this.f11600e);
        parcel.writeString(this.f11601f);
    }

    protected RoutePOIItem(Parcel parcel) {
        this.f11596a = parcel.readString();
        this.f11597b = parcel.readString();
        this.f11598c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11599d = parcel.readFloat();
        this.f11600e = parcel.readFloat();
        this.f11601f = parcel.readString();
    }
}
