package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new Parcelable.Creator<GeocodeAddress>() { // from class: com.amap.api.services.geocoder.GeocodeAddress.1
        /* renamed from: a */
        private static GeocodeAddress m51872a(Parcel parcel) {
            return new GeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeocodeAddress createFromParcel(Parcel parcel) {
            return m51872a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GeocodeAddress[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7352a;

    /* renamed from: b */
    private String f7353b;

    /* renamed from: c */
    private String f7354c;

    /* renamed from: d */
    private String f7355d;

    /* renamed from: e */
    private String f7356e;

    /* renamed from: f */
    private String f7357f;

    /* renamed from: g */
    private String f7358g;

    /* renamed from: h */
    private String f7359h;

    /* renamed from: i */
    private LatLonPoint f7360i;

    /* renamed from: j */
    private String f7361j;

    /* renamed from: k */
    private String f7362k;

    /* renamed from: l */
    private String f7363l;

    /* synthetic */ GeocodeAddress(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAdcode() {
        return this.f7359h;
    }

    public final String getBuilding() {
        return this.f7358g;
    }

    public final String getCity() {
        return this.f7354c;
    }

    public final String getCountry() {
        return this.f7362k;
    }

    public final String getDistrict() {
        return this.f7355d;
    }

    public final String getFormatAddress() {
        return this.f7352a;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f7360i;
    }

    public final String getLevel() {
        return this.f7361j;
    }

    public final String getNeighborhood() {
        return this.f7357f;
    }

    public final String getPostcode() {
        return this.f7363l;
    }

    public final String getProvince() {
        return this.f7353b;
    }

    public final String getTownship() {
        return this.f7356e;
    }

    public final void setAdcode(String str) {
        this.f7359h = str;
    }

    public final void setBuilding(String str) {
        this.f7358g = str;
    }

    public final void setCity(String str) {
        this.f7354c = str;
    }

    public final void setCountry(String str) {
        this.f7362k = str;
    }

    public final void setDistrict(String str) {
        this.f7355d = str;
    }

    public final void setFormatAddress(String str) {
        this.f7352a = str;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f7360i = latLonPoint;
    }

    public final void setLevel(String str) {
        this.f7361j = str;
    }

    public final void setNeighborhood(String str) {
        this.f7357f = str;
    }

    public final void setPostcode(String str) {
        this.f7363l = str;
    }

    public final void setProvince(String str) {
        this.f7353b = str;
    }

    public final void setTownship(String str) {
        this.f7356e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7352a);
        parcel.writeString(this.f7353b);
        parcel.writeString(this.f7354c);
        parcel.writeString(this.f7355d);
        parcel.writeString(this.f7356e);
        parcel.writeString(this.f7357f);
        parcel.writeString(this.f7358g);
        parcel.writeString(this.f7359h);
        parcel.writeValue(this.f7360i);
        parcel.writeString(this.f7361j);
        parcel.writeString(this.f7362k);
        parcel.writeString(this.f7363l);
    }

    public GeocodeAddress() {
    }

    private GeocodeAddress(Parcel parcel) {
        this.f7352a = parcel.readString();
        this.f7353b = parcel.readString();
        this.f7354c = parcel.readString();
        this.f7355d = parcel.readString();
        this.f7356e = parcel.readString();
        this.f7357f = parcel.readString();
        this.f7358g = parcel.readString();
        this.f7359h = parcel.readString();
        this.f7360i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7361j = parcel.readString();
        this.f7362k = parcel.readString();
        this.f7363l = parcel.readString();
    }
}
