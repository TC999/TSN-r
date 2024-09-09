package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() { // from class: com.amap.api.services.core.LatLonSharePoint.1
        private static LatLonSharePoint a(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint[] newArray(int i4) {
            return a(i4);
        }

        private static LatLonSharePoint[] a(int i4) {
            return new LatLonSharePoint[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10965a;

    public LatLonSharePoint(double d4, double d5, String str) {
        super(d4, d5);
        this.f10965a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass()) {
            LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
            String str = this.f10965a;
            if (str == null) {
                if (latLonSharePoint.f10965a != null) {
                    return false;
                }
            } else if (!str.equals(latLonSharePoint.f10965a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getSharePointName() {
        return this.f10965a;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f10965a;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public void setSharePointName(String str) {
        this.f10965a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.f10965a;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.f10965a);
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f10965a = parcel.readString();
    }
}
