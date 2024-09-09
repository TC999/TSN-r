package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new Parcelable.Creator<BusinessArea>() { // from class: com.amap.api.services.geocoder.BusinessArea.1
        private static BusinessArea a(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea[] newArray(int i4) {
            return a(i4);
        }

        private static BusinessArea[] a(int i4) {
            return new BusinessArea[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f11044a;

    /* renamed from: b  reason: collision with root package name */
    private String f11045b;

    public BusinessArea() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f11044a;
    }

    public String getName() {
        return this.f11045b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f11044a = latLonPoint;
    }

    public void setName(String str) {
        this.f11045b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f11044a, i4);
        parcel.writeString(this.f11045b);
    }

    public BusinessArea(Parcel parcel) {
        this.f11044a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11045b = parcel.readString();
    }
}
