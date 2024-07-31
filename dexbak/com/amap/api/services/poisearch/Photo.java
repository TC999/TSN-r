package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() { // from class: com.amap.api.services.poisearch.Photo.1
        /* renamed from: a */
        private static Photo m51860a(Parcel parcel) {
            return new Photo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Photo createFromParcel(Parcel parcel) {
            return m51860a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Photo[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7456a;

    /* renamed from: b */
    private String f7457b;

    public Photo() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.f7456a;
    }

    public final String getUrl() {
        return this.f7457b;
    }

    public final void setTitle(String str) {
        this.f7456a = str;
    }

    public final void setUrl(String str) {
        this.f7457b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7456a);
        parcel.writeString(this.f7457b);
    }

    public Photo(String str, String str2) {
        this.f7456a = str;
        this.f7457b = str2;
    }

    public Photo(Parcel parcel) {
        this.f7456a = parcel.readString();
        this.f7457b = parcel.readString();
    }
}
