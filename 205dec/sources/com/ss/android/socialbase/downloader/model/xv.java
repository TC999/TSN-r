package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements Parcelable, Comparable {
    public static final Parcelable.Creator<xv> CREATOR = new Parcelable.Creator<xv>() { // from class: com.ss.android.socialbase.downloader.model.xv.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public xv createFromParcel(Parcel parcel) {
            return new xv(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public xv[] newArray(int i4) {
            return new xv[i4];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final String f49988c;

    /* renamed from: w  reason: collision with root package name */
    private final String f49989w;

    public xv(String str, String str2) {
        this.f49988c = str;
        this.f49989w = str2;
    }

    public String c() {
        return this.f49988c;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof xv) {
            xv xvVar = (xv) obj;
            if (TextUtils.equals(this.f49988c, xvVar.c())) {
                return 0;
            }
            String str = this.f49988c;
            if (str == null) {
                return -1;
            }
            int compareTo = str.compareTo(xvVar.c());
            if (compareTo > 0) {
                return 1;
            }
            return compareTo < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xv xvVar = (xv) obj;
        return TextUtils.equals(this.f49988c, xvVar.f49988c) && TextUtils.equals(this.f49989w, xvVar.f49989w);
    }

    public int hashCode() {
        String str = this.f49988c;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f49989w;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.f49988c + "', value='" + this.f49989w + "'}";
    }

    public String w() {
        return this.f49989w;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f49988c);
        parcel.writeString(this.f49989w);
    }

    protected xv(Parcel parcel) {
        this.f49988c = parcel.readString();
        this.f49989w = parcel.readString();
    }
}
