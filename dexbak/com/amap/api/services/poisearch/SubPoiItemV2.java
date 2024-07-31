package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SubPoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<SubPoiItemV2> CREATOR = new Parcelable.Creator<SubPoiItemV2>() { // from class: com.amap.api.services.poisearch.SubPoiItemV2.1
        /* renamed from: a */
        private static SubPoiItemV2 m51844a(Parcel parcel) {
            return new SubPoiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItemV2 createFromParcel(Parcel parcel) {
            return m51844a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItemV2[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7527a;

    /* renamed from: b */
    private String f7528b;

    /* renamed from: c */
    private LatLonPoint f7529c;

    /* renamed from: d */
    private String f7530d;

    /* renamed from: e */
    private String f7531e;

    /* renamed from: f */
    private String f7532f;

    public SubPoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f7527a = str;
        this.f7529c = latLonPoint;
        this.f7528b = str2;
        this.f7530d = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f7529c;
    }

    public String getPoiId() {
        return this.f7527a;
    }

    public String getSnippet() {
        return this.f7530d;
    }

    public String getSubTypeDes() {
        return this.f7531e;
    }

    public String getTitle() {
        return this.f7528b;
    }

    public String getTypeCode() {
        return this.f7532f;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f7529c = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f7527a = str;
    }

    public void setSnippet(String str) {
        this.f7530d = str;
    }

    public void setSubTypeDes(String str) {
        this.f7531e = str;
    }

    public void setTitle(String str) {
        this.f7528b = str;
    }

    public void setTypeCode(String str) {
        this.f7532f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7527a);
        parcel.writeString(this.f7528b);
        parcel.writeValue(this.f7529c);
        parcel.writeString(this.f7530d);
        parcel.writeString(this.f7531e);
        parcel.writeString(this.f7532f);
    }

    public SubPoiItemV2(Parcel parcel) {
        this.f7527a = parcel.readString();
        this.f7528b = parcel.readString();
        this.f7529c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7530d = parcel.readString();
        this.f7531e = parcel.readString();
        this.f7532f = parcel.readString();
    }
}
