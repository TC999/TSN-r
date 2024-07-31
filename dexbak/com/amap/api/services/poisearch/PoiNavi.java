package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PoiNavi implements Parcelable {
    public static final Parcelable.Creator<PoiNavi> CREATOR = new Parcelable.Creator<PoiNavi>() { // from class: com.amap.api.services.poisearch.PoiNavi.1
        /* renamed from: a */
        private static PoiNavi m51857a(Parcel parcel) {
            return new PoiNavi(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiNavi createFromParcel(Parcel parcel) {
            return m51857a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PoiNavi[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7460a;

    /* renamed from: b */
    private LatLonPoint f7461b;

    /* renamed from: c */
    private LatLonPoint f7462c;

    /* renamed from: d */
    private String f7463d;

    public PoiNavi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getEnter() {
        return this.f7461b;
    }

    public LatLonPoint getExit() {
        return this.f7462c;
    }

    public String getGridCode() {
        return this.f7463d;
    }

    public String getNaviPoiID() {
        return this.f7460a;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f7461b = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f7462c = latLonPoint;
    }

    public void setGridCode(String str) {
        this.f7463d = str;
    }

    public void setNaviPoiID(String str) {
        this.f7460a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7460a);
        parcel.writeValue(this.f7461b);
        parcel.writeValue(this.f7462c);
        parcel.writeString(this.f7463d);
    }

    public PoiNavi(String str, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, String str2) {
        this.f7460a = str;
        this.f7461b = latLonPoint;
        this.f7462c = latLonPoint2;
        this.f7463d = str2;
    }

    public PoiNavi(Parcel parcel) {
        this.f7460a = parcel.readString();
        this.f7461b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7462c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7463d = parcel.readString();
    }
}
