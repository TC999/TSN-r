package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new Parcelable.Creator<AoiItem>() { // from class: com.amap.api.services.geocoder.AoiItem.1
        /* renamed from: a */
        private static AoiItem m51875a(Parcel parcel) {
            return new AoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem createFromParcel(Parcel parcel) {
            return m51875a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem[] newArray(int i) {
            return m51876a(i);
        }

        /* renamed from: a */
        private static AoiItem[] m51876a(int i) {
            return new AoiItem[i];
        }
    };

    /* renamed from: a */
    private String f7345a;

    /* renamed from: b */
    private String f7346b;

    /* renamed from: c */
    private String f7347c;

    /* renamed from: d */
    private LatLonPoint f7348d;

    /* renamed from: e */
    private Float f7349e;

    public AoiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f7347c;
    }

    public Float getAoiArea() {
        return this.f7349e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.f7348d;
    }

    public String getAoiId() {
        return this.f7345a;
    }

    public String getAoiName() {
        return this.f7346b;
    }

    public void setAdcode(String str) {
        this.f7347c = str;
    }

    public void setArea(Float f) {
        this.f7349e = f;
    }

    public void setId(String str) {
        this.f7345a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f7348d = latLonPoint;
    }

    public void setName(String str) {
        this.f7346b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7345a);
        parcel.writeString(this.f7346b);
        parcel.writeString(this.f7347c);
        parcel.writeParcelable(this.f7348d, i);
        parcel.writeFloat(this.f7349e.floatValue());
    }

    public AoiItem(Parcel parcel) {
        this.f7345a = parcel.readString();
        this.f7346b = parcel.readString();
        this.f7347c = parcel.readString();
        this.f7348d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7349e = Float.valueOf(parcel.readFloat());
    }
}
