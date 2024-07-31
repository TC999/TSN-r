package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = new Parcelable.Creator<TaxiItem>() { // from class: com.amap.api.services.route.TaxiItem.1
        /* renamed from: a */
        private static TaxiItem m51763a(Parcel parcel) {
            return new TaxiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItem createFromParcel(Parcel parcel) {
            return m51763a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItem[] newArray(int i) {
            return m51764a(i);
        }

        /* renamed from: a */
        private static TaxiItem[] m51764a(int i) {
            return new TaxiItem[i];
        }
    };

    /* renamed from: a */
    private LatLonPoint f7842a;

    /* renamed from: b */
    private LatLonPoint f7843b;

    /* renamed from: c */
    private float f7844c;

    /* renamed from: d */
    private float f7845d;

    /* renamed from: e */
    private String f7846e;

    /* renamed from: f */
    private String f7847f;

    public TaxiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f7843b;
    }

    public float getDistance() {
        return this.f7844c;
    }

    public float getDuration() {
        return this.f7845d;
    }

    public LatLonPoint getOrigin() {
        return this.f7842a;
    }

    public String getmSname() {
        return this.f7846e;
    }

    public String getmTname() {
        return this.f7847f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f7843b = latLonPoint;
    }

    public void setDistance(float f) {
        this.f7844c = f;
    }

    public void setDuration(float f) {
        this.f7845d = f;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f7842a = latLonPoint;
    }

    public void setSname(String str) {
        this.f7846e = str;
    }

    public void setTname(String str) {
        this.f7847f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7842a, i);
        parcel.writeParcelable(this.f7843b, i);
        parcel.writeFloat(this.f7844c);
        parcel.writeFloat(this.f7845d);
        parcel.writeString(this.f7846e);
        parcel.writeString(this.f7847f);
    }

    protected TaxiItem(Parcel parcel) {
        this.f7842a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7843b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7844c = parcel.readFloat();
        this.f7845d = parcel.readFloat();
        this.f7846e = parcel.readString();
        this.f7847f = parcel.readString();
    }
}
