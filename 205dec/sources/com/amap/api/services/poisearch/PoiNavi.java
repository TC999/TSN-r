package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PoiNavi implements Parcelable {
    public static final Parcelable.Creator<PoiNavi> CREATOR = new Parcelable.Creator<PoiNavi>() { // from class: com.amap.api.services.poisearch.PoiNavi.1
        private static PoiNavi a(Parcel parcel) {
            return new PoiNavi(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiNavi createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PoiNavi[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11154a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11155b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f11156c;

    /* renamed from: d  reason: collision with root package name */
    private String f11157d;

    public PoiNavi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getEnter() {
        return this.f11155b;
    }

    public LatLonPoint getExit() {
        return this.f11156c;
    }

    public String getGridCode() {
        return this.f11157d;
    }

    public String getNaviPoiID() {
        return this.f11154a;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f11155b = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f11156c = latLonPoint;
    }

    public void setGridCode(String str) {
        this.f11157d = str;
    }

    public void setNaviPoiID(String str) {
        this.f11154a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11154a);
        parcel.writeValue(this.f11155b);
        parcel.writeValue(this.f11156c);
        parcel.writeString(this.f11157d);
    }

    public PoiNavi(String str, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, String str2) {
        this.f11154a = str;
        this.f11155b = latLonPoint;
        this.f11156c = latLonPoint2;
        this.f11157d = str2;
    }

    public PoiNavi(Parcel parcel) {
        this.f11154a = parcel.readString();
        this.f11155b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f11156c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f11157d = parcel.readString();
    }
}
