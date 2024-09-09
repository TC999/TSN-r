package com.ss.android.downloadlib.c.c;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements Parcelable {
    public static final Parcelable.Creator<w> CREATOR = new Parcelable.Creator<w>() { // from class: com.ss.android.downloadlib.c.c.w.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public w createFromParcel(Parcel parcel) {
            return new w(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public w[] newArray(int i4) {
            return new w[i4];
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public int f48781c;

    /* renamed from: f  reason: collision with root package name */
    public String f48782f;
    public int sr;
    public String ux;

    /* renamed from: w  reason: collision with root package name */
    public int f48783w;
    public String xv;

    public w() {
        this.xv = "";
        this.ux = "";
        this.f48782f = "";
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
            w wVar = (w) obj;
            if (this.f48781c == wVar.f48781c && this.f48783w == wVar.f48783w) {
                String str = this.xv;
                if (str != null) {
                    return str.equals(wVar.xv);
                }
                if (wVar.xv == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i4 = ((this.f48781c * 31) + this.f48783w) * 31;
        String str = this.xv;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f48781c);
        parcel.writeInt(this.f48783w);
        parcel.writeString(this.xv);
        parcel.writeString(this.ux);
        parcel.writeString(this.f48782f);
        parcel.writeInt(this.sr);
    }

    protected w(Parcel parcel) {
        this.xv = "";
        this.ux = "";
        this.f48782f = "";
        this.f48781c = parcel.readInt();
        this.f48783w = parcel.readInt();
        this.xv = parcel.readString();
        this.ux = parcel.readString();
        this.f48782f = parcel.readString();
        this.sr = parcel.readInt();
    }
}
