package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() { // from class: com.amap.api.services.route.District.1
        /* renamed from: a */
        private static District m51827a(Parcel parcel) {
            return new District(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ District createFromParcel(Parcel parcel) {
            return m51827a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ District[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7605a;

    /* renamed from: b */
    private String f7606b;

    public District(Parcel parcel) {
        this.f7605a = parcel.readString();
        this.f7606b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.f7606b;
    }

    public String getDistrictName() {
        return this.f7605a;
    }

    public void setDistrictAdcode(String str) {
        this.f7606b = str;
    }

    public void setDistrictName(String str) {
        this.f7605a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7605a);
        parcel.writeString(this.f7606b);
    }

    public District() {
    }
}
