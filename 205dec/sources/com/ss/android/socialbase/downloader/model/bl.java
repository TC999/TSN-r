package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements Parcelable, Comparable {
    public static final Parcelable.Creator<bl> CREATOR = new Parcelable.Creator<bl>() { // from class: com.ss.android.socialbase.downloader.model.bl.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public bl createFromParcel(Parcel parcel) {
            return new bl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public bl[] newArray(int i4) {
            return new bl[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f49964a;
    private final String ok;

    public bl(String str, String str2) {
        this.ok = str;
        this.f49964a = str2;
    }

    public String a() {
        return this.f49964a;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof bl) {
            bl blVar = (bl) obj;
            if (TextUtils.equals(this.ok, blVar.ok())) {
                return 0;
            }
            String str = this.ok;
            if (str == null) {
                return -1;
            }
            int compareTo = str.compareTo(blVar.ok());
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
        bl blVar = (bl) obj;
        return TextUtils.equals(this.ok, blVar.ok) && TextUtils.equals(this.f49964a, blVar.f49964a);
    }

    public int hashCode() {
        String str = this.ok;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f49964a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String ok() {
        return this.ok;
    }

    public String toString() {
        return "HttpHeader{name='" + this.ok + "', value='" + this.f49964a + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.ok);
        parcel.writeString(this.f49964a);
    }

    protected bl(Parcel parcel) {
        this.ok = parcel.readString();
        this.f49964a = parcel.readString();
    }
}
