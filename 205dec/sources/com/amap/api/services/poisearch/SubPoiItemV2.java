package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SubPoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<SubPoiItemV2> CREATOR = new Parcelable.Creator<SubPoiItemV2>() { // from class: com.amap.api.services.poisearch.SubPoiItemV2.1
        private static SubPoiItemV2 a(Parcel parcel) {
            return new SubPoiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItemV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItemV2[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11221a;

    /* renamed from: b  reason: collision with root package name */
    private String f11222b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f11223c;

    /* renamed from: d  reason: collision with root package name */
    private String f11224d;

    /* renamed from: e  reason: collision with root package name */
    private String f11225e;

    /* renamed from: f  reason: collision with root package name */
    private String f11226f;

    public SubPoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f11221a = str;
        this.f11223c = latLonPoint;
        this.f11222b = str2;
        this.f11224d = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f11223c;
    }

    public String getPoiId() {
        return this.f11221a;
    }

    public String getSnippet() {
        return this.f11224d;
    }

    public String getSubTypeDes() {
        return this.f11225e;
    }

    public String getTitle() {
        return this.f11222b;
    }

    public String getTypeCode() {
        return this.f11226f;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f11223c = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f11221a = str;
    }

    public void setSnippet(String str) {
        this.f11224d = str;
    }

    public void setSubTypeDes(String str) {
        this.f11225e = str;
    }

    public void setTitle(String str) {
        this.f11222b = str;
    }

    public void setTypeCode(String str) {
        this.f11226f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11221a);
        parcel.writeString(this.f11222b);
        parcel.writeValue(this.f11223c);
        parcel.writeString(this.f11224d);
        parcel.writeString(this.f11225e);
        parcel.writeString(this.f11226f);
    }

    public SubPoiItemV2(Parcel parcel) {
        this.f11221a = parcel.readString();
        this.f11222b = parcel.readString();
        this.f11223c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f11224d = parcel.readString();
        this.f11225e = parcel.readString();
        this.f11226f = parcel.readString();
    }
}
