package com.p521ss.android.downloadlib.p537ok.p538ok;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.ss.android.downloadlib.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12246a implements Parcelable {
    public static final Parcelable.Creator<C12246a> CREATOR = new Parcelable.Creator<C12246a>() { // from class: com.ss.android.downloadlib.ok.ok.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public C12246a createFromParcel(Parcel parcel) {
            return new C12246a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public C12246a[] newArray(int i) {
            return new C12246a[i];
        }
    };

    /* renamed from: a */
    public int f34541a;

    /* renamed from: bl */
    public String f34542bl;

    /* renamed from: kf */
    public String f34543kf;

    /* renamed from: n */
    public String f34544n;

    /* renamed from: ok */
    public int f34545ok;

    /* renamed from: s */
    public int f34546s;

    public C12246a() {
        this.f34542bl = "";
        this.f34544n = "";
        this.f34543kf = "";
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
            C12246a c12246a = (C12246a) obj;
            if (this.f34545ok == c12246a.f34545ok && this.f34541a == c12246a.f34541a) {
                String str = this.f34542bl;
                if (str != null) {
                    return str.equals(c12246a.f34542bl);
                }
                if (c12246a.f34542bl == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f34545ok * 31) + this.f34541a) * 31;
        String str = this.f34542bl;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f34545ok);
        parcel.writeInt(this.f34541a);
        parcel.writeString(this.f34542bl);
        parcel.writeString(this.f34544n);
        parcel.writeString(this.f34543kf);
        parcel.writeInt(this.f34546s);
    }

    protected C12246a(Parcel parcel) {
        this.f34542bl = "";
        this.f34544n = "";
        this.f34543kf = "";
        this.f34545ok = parcel.readInt();
        this.f34541a = parcel.readInt();
        this.f34542bl = parcel.readString();
        this.f34544n = parcel.readString();
        this.f34543kf = parcel.readString();
        this.f34546s = parcel.readInt();
    }
}
