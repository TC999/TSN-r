package com.ss.android.downloadlib.ok.ok;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.ss.android.downloadlib.ok.ok.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public a[] newArray(int i4) {
            return new a[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f48867a;
    public String bl;
    public String kf;

    /* renamed from: n  reason: collision with root package name */
    public String f48868n;
    public int ok;

    /* renamed from: s  reason: collision with root package name */
    public int f48869s;

    public a() {
        this.bl = "";
        this.f48868n = "";
        this.kf = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.ok == aVar.ok && this.f48867a == aVar.f48867a) {
                String str = this.bl;
                if (str != null) {
                    return str.equals(aVar.bl);
                }
                if (aVar.bl == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i4 = ((this.ok * 31) + this.f48867a) * 31;
        String str = this.bl;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.ok);
        parcel.writeInt(this.f48867a);
        parcel.writeString(this.bl);
        parcel.writeString(this.f48868n);
        parcel.writeString(this.kf);
        parcel.writeInt(this.f48869s);
    }

    protected a(Parcel parcel) {
        this.bl = "";
        this.f48868n = "";
        this.kf = "";
        this.ok = parcel.readInt();
        this.f48867a = parcel.readInt();
        this.bl = parcel.readString();
        this.f48868n = parcel.readString();
        this.kf = parcel.readString();
        this.f48869s = parcel.readInt();
    }
}
