package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() { // from class: com.amap.api.maps.offlinemap.Province.1
        /* renamed from: a */
        private static Province m51978a(Parcel parcel) {
            return new Province(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province createFromParcel(Parcel parcel) {
            return m51978a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province[] newArray(int i) {
            return m51979a(i);
        }

        /* renamed from: a */
        private static Province[] m51979a(int i) {
            return new Province[i];
        }
    };

    /* renamed from: a */
    private String f7139a;

    /* renamed from: b */
    private String f7140b;

    /* renamed from: c */
    private String f7141c;

    /* renamed from: d */
    private String f7142d;

    public Province() {
        this.f7139a = "";
        this.f7142d = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.f7140b;
    }

    public String getPinyin() {
        return this.f7141c;
    }

    public String getProvinceCode() {
        return this.f7142d;
    }

    public String getProvinceName() {
        return this.f7139a;
    }

    public void setJianpin(String str) {
        this.f7140b = str;
    }

    public void setPinyin(String str) {
        this.f7141c = str;
    }

    public void setProvinceCode(String str) {
        this.f7142d = str;
    }

    public void setProvinceName(String str) {
        this.f7139a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7139a);
        parcel.writeString(this.f7140b);
        parcel.writeString(this.f7141c);
        parcel.writeString(this.f7142d);
    }

    public Province(Parcel parcel) {
        this.f7139a = "";
        this.f7142d = "";
        this.f7139a = parcel.readString();
        this.f7140b = parcel.readString();
        this.f7141c = parcel.readString();
        this.f7142d = parcel.readString();
    }
}
