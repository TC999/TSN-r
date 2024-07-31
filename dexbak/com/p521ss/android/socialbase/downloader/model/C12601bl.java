package com.p521ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* renamed from: com.ss.android.socialbase.downloader.model.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12601bl implements Parcelable, Comparable {
    public static final Parcelable.Creator<C12601bl> CREATOR = new Parcelable.Creator<C12601bl>() { // from class: com.ss.android.socialbase.downloader.model.bl.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public C12601bl createFromParcel(Parcel parcel) {
            return new C12601bl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public C12601bl[] newArray(int i) {
            return new C12601bl[i];
        }
    };

    /* renamed from: a */
    private final String f35516a;

    /* renamed from: ok */
    private final String f35517ok;

    public C12601bl(String str, String str2) {
        this.f35517ok = str;
        this.f35516a = str2;
    }

    /* renamed from: a */
    public String m17000a() {
        return this.f35516a;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof C12601bl) {
            C12601bl c12601bl = (C12601bl) obj;
            if (TextUtils.equals(this.f35517ok, c12601bl.m16999ok())) {
                return 0;
            }
            String str = this.f35517ok;
            if (str == null) {
                return -1;
            }
            int compareTo = str.compareTo(c12601bl.m16999ok());
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
        C12601bl c12601bl = (C12601bl) obj;
        return TextUtils.equals(this.f35517ok, c12601bl.f35517ok) && TextUtils.equals(this.f35516a, c12601bl.f35516a);
    }

    public int hashCode() {
        String str = this.f35517ok;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f35516a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    /* renamed from: ok */
    public String m16999ok() {
        return this.f35517ok;
    }

    public String toString() {
        return "HttpHeader{name='" + this.f35517ok + "', value='" + this.f35516a + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f35517ok);
        parcel.writeString(this.f35516a);
    }

    protected C12601bl(Parcel parcel) {
        this.f35517ok = parcel.readString();
        this.f35516a = parcel.readString();
    }
}
