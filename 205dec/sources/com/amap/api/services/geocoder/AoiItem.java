package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new Parcelable.Creator<AoiItem>() { // from class: com.amap.api.services.geocoder.AoiItem.1
        private static AoiItem a(Parcel parcel) {
            return new AoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem[] newArray(int i4) {
            return a(i4);
        }

        private static AoiItem[] a(int i4) {
            return new AoiItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11039a;

    /* renamed from: b  reason: collision with root package name */
    private String f11040b;

    /* renamed from: c  reason: collision with root package name */
    private String f11041c;

    /* renamed from: d  reason: collision with root package name */
    private LatLonPoint f11042d;

    /* renamed from: e  reason: collision with root package name */
    private Float f11043e;

    public AoiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f11041c;
    }

    public Float getAoiArea() {
        return this.f11043e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.f11042d;
    }

    public String getAoiId() {
        return this.f11039a;
    }

    public String getAoiName() {
        return this.f11040b;
    }

    public void setAdcode(String str) {
        this.f11041c = str;
    }

    public void setArea(Float f4) {
        this.f11043e = f4;
    }

    public void setId(String str) {
        this.f11039a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f11042d = latLonPoint;
    }

    public void setName(String str) {
        this.f11040b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11039a);
        parcel.writeString(this.f11040b);
        parcel.writeString(this.f11041c);
        parcel.writeParcelable(this.f11042d, i4);
        parcel.writeFloat(this.f11043e.floatValue());
    }

    public AoiItem(Parcel parcel) {
        this.f11039a = parcel.readString();
        this.f11040b = parcel.readString();
        this.f11041c = parcel.readString();
        this.f11042d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11043e = Float.valueOf(parcel.readFloat());
    }
}
