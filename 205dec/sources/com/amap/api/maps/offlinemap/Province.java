package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() { // from class: com.amap.api.maps.offlinemap.Province.1
        private static Province a(Parcel parcel) {
            return new Province(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province[] newArray(int i4) {
            return a(i4);
        }

        private static Province[] a(int i4) {
            return new Province[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10837a;

    /* renamed from: b  reason: collision with root package name */
    private String f10838b;

    /* renamed from: c  reason: collision with root package name */
    private String f10839c;

    /* renamed from: d  reason: collision with root package name */
    private String f10840d;

    public Province() {
        this.f10837a = "";
        this.f10840d = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.f10838b;
    }

    public String getPinyin() {
        return this.f10839c;
    }

    public String getProvinceCode() {
        return this.f10840d;
    }

    public String getProvinceName() {
        return this.f10837a;
    }

    public void setJianpin(String str) {
        this.f10838b = str;
    }

    public void setPinyin(String str) {
        this.f10839c = str;
    }

    public void setProvinceCode(String str) {
        this.f10840d = str;
    }

    public void setProvinceName(String str) {
        this.f10837a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10837a);
        parcel.writeString(this.f10838b);
        parcel.writeString(this.f10839c);
        parcel.writeString(this.f10840d);
    }

    public Province(Parcel parcel) {
        this.f10837a = "";
        this.f10840d = "";
        this.f10837a = parcel.readString();
        this.f10838b = parcel.readString();
        this.f10839c = parcel.readString();
        this.f10840d = parcel.readString();
    }
}
