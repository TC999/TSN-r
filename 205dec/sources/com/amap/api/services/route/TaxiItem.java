package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = new Parcelable.Creator<TaxiItem>() { // from class: com.amap.api.services.route.TaxiItem.1
        private static TaxiItem a(Parcel parcel) {
            return new TaxiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItem[] newArray(int i4) {
            return a(i4);
        }

        private static TaxiItem[] a(int i4) {
            return new TaxiItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f11536a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11537b;

    /* renamed from: c  reason: collision with root package name */
    private float f11538c;

    /* renamed from: d  reason: collision with root package name */
    private float f11539d;

    /* renamed from: e  reason: collision with root package name */
    private String f11540e;

    /* renamed from: f  reason: collision with root package name */
    private String f11541f;

    public TaxiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f11537b;
    }

    public float getDistance() {
        return this.f11538c;
    }

    public float getDuration() {
        return this.f11539d;
    }

    public LatLonPoint getOrigin() {
        return this.f11536a;
    }

    public String getmSname() {
        return this.f11540e;
    }

    public String getmTname() {
        return this.f11541f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f11537b = latLonPoint;
    }

    public void setDistance(float f4) {
        this.f11538c = f4;
    }

    public void setDuration(float f4) {
        this.f11539d = f4;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f11536a = latLonPoint;
    }

    public void setSname(String str) {
        this.f11540e = str;
    }

    public void setTname(String str) {
        this.f11541f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f11536a, i4);
        parcel.writeParcelable(this.f11537b, i4);
        parcel.writeFloat(this.f11538c);
        parcel.writeFloat(this.f11539d);
        parcel.writeString(this.f11540e);
        parcel.writeString(this.f11541f);
    }

    protected TaxiItem(Parcel parcel) {
        this.f11536a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11537b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11538c = parcel.readFloat();
        this.f11539d = parcel.readFloat();
        this.f11540e = parcel.readString();
        this.f11541f = parcel.readString();
    }
}
