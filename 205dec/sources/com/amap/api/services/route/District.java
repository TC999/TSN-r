package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() { // from class: com.amap.api.services.route.District.1
        private static District a(Parcel parcel) {
            return new District(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ District createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ District[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11299a;

    /* renamed from: b  reason: collision with root package name */
    private String f11300b;

    public District(Parcel parcel) {
        this.f11299a = parcel.readString();
        this.f11300b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.f11300b;
    }

    public String getDistrictName() {
        return this.f11299a;
    }

    public void setDistrictAdcode(String str) {
        this.f11300b = str;
    }

    public void setDistrictName(String str) {
        this.f11299a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11299a);
        parcel.writeString(this.f11300b);
    }

    public District() {
    }
}
