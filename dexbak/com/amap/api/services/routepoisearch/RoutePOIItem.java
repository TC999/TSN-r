package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new Parcelable.Creator<RoutePOIItem>() { // from class: com.amap.api.services.routepoisearch.RoutePOIItem.1
        /* renamed from: a */
        private static RoutePOIItem m51745a(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem createFromParcel(Parcel parcel) {
            return m51745a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem[] newArray(int i) {
            return m51746a(i);
        }

        /* renamed from: a */
        private static RoutePOIItem[] m51746a(int i) {
            return new RoutePOIItem[i];
        }
    };

    /* renamed from: a */
    private String f7902a;

    /* renamed from: b */
    private String f7903b;

    /* renamed from: c */
    private LatLonPoint f7904c;

    /* renamed from: d */
    private float f7905d;

    /* renamed from: e */
    private float f7906e;

    /* renamed from: f */
    private String f7907f;

    public RoutePOIItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCPID() {
        return this.f7907f;
    }

    public float getDistance() {
        return this.f7905d;
    }

    public float getDuration() {
        return this.f7906e;
    }

    public String getID() {
        return this.f7902a;
    }

    public LatLonPoint getPoint() {
        return this.f7904c;
    }

    public String getTitle() {
        return this.f7903b;
    }

    public void setCPID(String str) {
        this.f7907f = str;
    }

    public void setDistance(float f) {
        this.f7905d = f;
    }

    public void setDuration(float f) {
        this.f7906e = f;
    }

    public void setID(String str) {
        this.f7902a = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f7904c = latLonPoint;
    }

    public void setTitle(String str) {
        this.f7903b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7902a);
        parcel.writeString(this.f7903b);
        parcel.writeParcelable(this.f7904c, i);
        parcel.writeFloat(this.f7905d);
        parcel.writeFloat(this.f7906e);
        parcel.writeString(this.f7907f);
    }

    protected RoutePOIItem(Parcel parcel) {
        this.f7902a = parcel.readString();
        this.f7903b = parcel.readString();
        this.f7904c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7905d = parcel.readFloat();
        this.f7906e = parcel.readFloat();
        this.f7907f = parcel.readString();
    }
}
