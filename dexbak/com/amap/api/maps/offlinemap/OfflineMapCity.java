package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = new Parcelable.Creator<OfflineMapCity>() { // from class: com.amap.api.maps.offlinemap.OfflineMapCity.1
        /* renamed from: a */
        private static OfflineMapCity m51993a(Parcel parcel) {
            return new OfflineMapCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity createFromParcel(Parcel parcel) {
            return m51993a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity[] newArray(int i) {
            return m51994a(i);
        }

        /* renamed from: a */
        private static OfflineMapCity[] m51994a(int i) {
            return new OfflineMapCity[i];
        }
    };

    /* renamed from: a */
    private String f7109a;

    /* renamed from: b */
    private long f7110b;

    /* renamed from: c */
    private int f7111c;

    /* renamed from: d */
    private String f7112d;

    /* renamed from: e */
    private int f7113e;

    public OfflineMapCity() {
        this.f7109a = "";
        this.f7110b = 0L;
        this.f7111c = 6;
        this.f7112d = "";
        this.f7113e = 0;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.f7110b;
    }

    public int getState() {
        return this.f7111c;
    }

    public String getUrl() {
        return this.f7109a;
    }

    public String getVersion() {
        return this.f7112d;
    }

    public int getcompleteCode() {
        return this.f7113e;
    }

    public void setCompleteCode(int i) {
        this.f7113e = i;
    }

    public void setSize(long j) {
        this.f7110b = j;
    }

    public void setState(int i) {
        this.f7111c = i;
    }

    public void setUrl(String str) {
        this.f7109a = str;
    }

    public void setVersion(String str) {
        this.f7112d = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f7109a);
        parcel.writeLong(this.f7110b);
        parcel.writeInt(this.f7111c);
        parcel.writeString(this.f7112d);
        parcel.writeInt(this.f7113e);
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f7109a = "";
        this.f7110b = 0L;
        this.f7111c = 6;
        this.f7112d = "";
        this.f7113e = 0;
        this.f7109a = parcel.readString();
        this.f7110b = parcel.readLong();
        this.f7111c = parcel.readInt();
        this.f7112d = parcel.readString();
        this.f7113e = parcel.readInt();
    }
}
