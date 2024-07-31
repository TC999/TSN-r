package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new Parcelable.Creator<Tip>() { // from class: com.amap.api.services.help.Tip.1
        /* renamed from: a */
        private static Tip m51868a(Parcel parcel) {
            return new Tip(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Tip createFromParcel(Parcel parcel) {
            return m51868a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Tip[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7412a;

    /* renamed from: b */
    private LatLonPoint f7413b;

    /* renamed from: c */
    private String f7414c;

    /* renamed from: d */
    private String f7415d;

    /* renamed from: e */
    private String f7416e;

    /* renamed from: f */
    private String f7417f;

    /* renamed from: g */
    private String f7418g;

    /* renamed from: h */
    private String f7419h;

    /* synthetic */ Tip(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f7416e;
    }

    public String getAddress() {
        return this.f7417f;
    }

    public String getDistrict() {
        return this.f7415d;
    }

    public String getName() {
        return this.f7414c;
    }

    public String getPoiID() {
        return this.f7412a;
    }

    public LatLonPoint getPoint() {
        return this.f7413b;
    }

    public String getTypeCode() {
        return this.f7418g;
    }

    public void setAdcode(String str) {
        this.f7416e = str;
    }

    public void setAddress(String str) {
        this.f7417f = str;
    }

    public void setDistrict(String str) {
        this.f7415d = str;
    }

    public void setID(String str) {
        this.f7412a = str;
    }

    public void setName(String str) {
        this.f7414c = str;
    }

    public void setPostion(LatLonPoint latLonPoint) {
        this.f7413b = latLonPoint;
    }

    public void setTypeCode(String str) {
        this.f7418g = str;
    }

    public String toString() {
        return "name:" + this.f7414c + " district:" + this.f7415d + " adcode:" + this.f7416e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7414c);
        parcel.writeString(this.f7416e);
        parcel.writeString(this.f7415d);
        parcel.writeString(this.f7412a);
        parcel.writeValue(this.f7413b);
        parcel.writeString(this.f7417f);
        parcel.writeString(this.f7418g);
        parcel.writeString(this.f7419h);
    }

    public Tip() {
        this.f7419h = "";
    }

    private Tip(Parcel parcel) {
        this.f7419h = "";
        this.f7414c = parcel.readString();
        this.f7416e = parcel.readString();
        this.f7415d = parcel.readString();
        this.f7412a = parcel.readString();
        this.f7413b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7417f = parcel.readString();
        this.f7418g = parcel.readString();
        this.f7419h = parcel.readString();
    }
}
