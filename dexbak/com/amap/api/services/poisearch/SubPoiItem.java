package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new Parcelable.Creator<SubPoiItem>() { // from class: com.amap.api.services.poisearch.SubPoiItem.1
        /* renamed from: a */
        private static SubPoiItem m51845a(Parcel parcel) {
            return new SubPoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItem createFromParcel(Parcel parcel) {
            return m51845a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItem[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7520a;

    /* renamed from: b */
    private String f7521b;

    /* renamed from: c */
    private String f7522c;

    /* renamed from: d */
    private int f7523d;

    /* renamed from: e */
    private LatLonPoint f7524e;

    /* renamed from: f */
    private String f7525f;

    /* renamed from: g */
    private String f7526g;

    public SubPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f7520a = str;
        this.f7524e = latLonPoint;
        this.f7521b = str2;
        this.f7525f = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f7523d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f7524e;
    }

    public String getPoiId() {
        return this.f7520a;
    }

    public String getSnippet() {
        return this.f7525f;
    }

    public String getSubName() {
        return this.f7522c;
    }

    public String getSubTypeDes() {
        return this.f7526g;
    }

    public String getTitle() {
        return this.f7521b;
    }

    public void setDistance(int i) {
        this.f7523d = i;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f7524e = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f7520a = str;
    }

    public void setSnippet(String str) {
        this.f7525f = str;
    }

    public void setSubName(String str) {
        this.f7522c = str;
    }

    public void setSubTypeDes(String str) {
        this.f7526g = str;
    }

    public void setTitle(String str) {
        this.f7521b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7520a);
        parcel.writeString(this.f7521b);
        parcel.writeString(this.f7522c);
        parcel.writeInt(this.f7523d);
        parcel.writeValue(this.f7524e);
        parcel.writeString(this.f7525f);
        parcel.writeString(this.f7526g);
    }

    public SubPoiItem(Parcel parcel) {
        this.f7520a = parcel.readString();
        this.f7521b = parcel.readString();
        this.f7522c = parcel.readString();
        this.f7523d = parcel.readInt();
        this.f7524e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7525f = parcel.readString();
        this.f7526g = parcel.readString();
    }
}
