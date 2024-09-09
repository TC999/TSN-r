package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() { // from class: com.amap.api.services.poisearch.Photo.1
        private static Photo a(Parcel parcel) {
            return new Photo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Photo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Photo[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11150a;

    /* renamed from: b  reason: collision with root package name */
    private String f11151b;

    public Photo() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.f11150a;
    }

    public final String getUrl() {
        return this.f11151b;
    }

    public final void setTitle(String str) {
        this.f11150a = str;
    }

    public final void setUrl(String str) {
        this.f11151b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11150a);
        parcel.writeString(this.f11151b);
    }

    public Photo(String str, String str2) {
        this.f11150a = str;
        this.f11151b = str2;
    }

    public Photo(Parcel parcel) {
        this.f11150a = parcel.readString();
        this.f11151b = parcel.readString();
    }
}
