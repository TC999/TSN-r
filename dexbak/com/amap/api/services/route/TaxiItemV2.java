package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TaxiItemV2 implements Parcelable {
    public static final Parcelable.Creator<TaxiItemV2> CREATOR = new Parcelable.Creator<TaxiItemV2>() { // from class: com.amap.api.services.route.TaxiItemV2.1
        /* renamed from: a */
        private static TaxiItemV2 m51761a(Parcel parcel) {
            return new TaxiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItemV2 createFromParcel(Parcel parcel) {
            return m51761a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItemV2[] newArray(int i) {
            return m51762a(i);
        }

        /* renamed from: a */
        private static TaxiItemV2[] m51762a(int i) {
            return new TaxiItemV2[i];
        }
    };

    /* renamed from: a */
    private LatLonPoint f7848a;

    /* renamed from: b */
    private LatLonPoint f7849b;

    /* renamed from: c */
    private float f7850c;

    /* renamed from: d */
    private float f7851d;

    /* renamed from: e */
    private String f7852e;

    /* renamed from: f */
    private String f7853f;

    /* renamed from: g */
    private float f7854g;

    /* renamed from: h */
    private List<LatLonPoint> f7855h;

    public TaxiItemV2() {
        this.f7855h = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f7849b;
    }

    public float getDistance() {
        return this.f7850c;
    }

    public float getDuration() {
        return this.f7851d;
    }

    public LatLonPoint getOrigin() {
        return this.f7848a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7855h;
    }

    public float getPrice() {
        return this.f7854g;
    }

    public String getmSname() {
        return this.f7852e;
    }

    public String getmTname() {
        return this.f7853f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f7849b = latLonPoint;
    }

    public void setDistance(float f) {
        this.f7850c = f;
    }

    public void setDuration(float f) {
        this.f7851d = f;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f7848a = latLonPoint;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7855h = list;
    }

    public void setPrice(float f) {
        this.f7854g = f;
    }

    public void setSname(String str) {
        this.f7852e = str;
    }

    public void setTname(String str) {
        this.f7853f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7848a, i);
        parcel.writeParcelable(this.f7849b, i);
        parcel.writeFloat(this.f7850c);
        parcel.writeFloat(this.f7851d);
        parcel.writeString(this.f7852e);
        parcel.writeString(this.f7853f);
        parcel.writeFloat(this.f7854g);
        parcel.writeTypedList(this.f7855h);
    }

    protected TaxiItemV2(Parcel parcel) {
        this.f7855h = new ArrayList();
        this.f7848a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7849b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7850c = parcel.readFloat();
        this.f7851d = parcel.readFloat();
        this.f7852e = parcel.readString();
        this.f7853f = parcel.readString();
        this.f7854g = parcel.readFloat();
        this.f7855h = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }
}
