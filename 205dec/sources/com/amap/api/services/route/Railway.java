package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new Parcelable.Creator<Railway>() { // from class: com.amap.api.services.route.Railway.1
        private static Railway a(Parcel parcel) {
            return new Railway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway[] newArray(int i4) {
            return a(i4);
        }

        private static Railway[] a(int i4) {
            return new Railway[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11364a;

    /* renamed from: b  reason: collision with root package name */
    private String f11365b;

    public Railway() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getID() {
        return this.f11364a;
    }

    public String getName() {
        return this.f11365b;
    }

    public void setID(String str) {
        this.f11364a = str;
    }

    public void setName(String str) {
        this.f11365b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11364a);
        parcel.writeString(this.f11365b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Railway(Parcel parcel) {
        this.f11364a = parcel.readString();
        this.f11365b = parcel.readString();
    }
}
