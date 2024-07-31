package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new Parcelable.Creator<BusinessArea>() { // from class: com.amap.api.services.geocoder.BusinessArea.1
        /* renamed from: a */
        private static BusinessArea m51873a(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea createFromParcel(Parcel parcel) {
            return m51873a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea[] newArray(int i) {
            return m51874a(i);
        }

        /* renamed from: a */
        private static BusinessArea[] m51874a(int i) {
            return new BusinessArea[i];
        }
    };

    /* renamed from: a */
    private LatLonPoint f7350a;

    /* renamed from: b */
    private String f7351b;

    public BusinessArea() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f7350a;
    }

    public String getName() {
        return this.f7351b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f7350a = latLonPoint;
    }

    public void setName(String str) {
        this.f7351b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7350a, i);
        parcel.writeString(this.f7351b);
    }

    public BusinessArea(Parcel parcel) {
        this.f7350a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7351b = parcel.readString();
    }
}
