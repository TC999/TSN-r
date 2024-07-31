package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new Parcelable.Creator<Railway>() { // from class: com.amap.api.services.route.Railway.1
        /* renamed from: a */
        private static Railway m51811a(Parcel parcel) {
            return new Railway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway createFromParcel(Parcel parcel) {
            return m51811a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway[] newArray(int i) {
            return m51812a(i);
        }

        /* renamed from: a */
        private static Railway[] m51812a(int i) {
            return new Railway[i];
        }
    };

    /* renamed from: a */
    private String f7670a;

    /* renamed from: b */
    private String f7671b;

    public Railway() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getID() {
        return this.f7670a;
    }

    public String getName() {
        return this.f7671b;
    }

    public void setID(String str) {
        this.f7670a = str;
    }

    public void setName(String str) {
        this.f7671b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7670a);
        parcel.writeString(this.f7671b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Railway(Parcel parcel) {
        this.f7670a = parcel.readString();
        this.f7671b = parcel.readString();
    }
}
