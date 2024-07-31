package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() { // from class: com.amap.api.services.core.LatLonSharePoint.1
        /* renamed from: a */
        private static LatLonSharePoint m51887a(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint createFromParcel(Parcel parcel) {
            return m51887a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint[] newArray(int i) {
            return m51888a(i);
        }

        /* renamed from: a */
        private static LatLonSharePoint[] m51888a(int i) {
            return new LatLonSharePoint[i];
        }
    };

    /* renamed from: a */
    private String f7269a;

    public LatLonSharePoint(double d, double d2, String str) {
        super(d, d2);
        this.f7269a = str;
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
            String str = this.f7269a;
            if (str == null) {
                if (latLonSharePoint.f7269a != null) {
                    return false;
                }
            } else if (!str.equals(latLonSharePoint.f7269a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getSharePointName() {
        return this.f7269a;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f7269a;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public void setSharePointName(String str) {
        this.f7269a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.f7269a;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f7269a);
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f7269a = parcel.readString();
    }
}
