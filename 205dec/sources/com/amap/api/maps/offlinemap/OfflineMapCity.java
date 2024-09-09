package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = new Parcelable.Creator<OfflineMapCity>() { // from class: com.amap.api.maps.offlinemap.OfflineMapCity.1
        private static OfflineMapCity a(Parcel parcel) {
            return new OfflineMapCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity[] newArray(int i4) {
            return a(i4);
        }

        private static OfflineMapCity[] a(int i4) {
            return new OfflineMapCity[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10807a;

    /* renamed from: b  reason: collision with root package name */
    private long f10808b;

    /* renamed from: c  reason: collision with root package name */
    private int f10809c;

    /* renamed from: d  reason: collision with root package name */
    private String f10810d;

    /* renamed from: e  reason: collision with root package name */
    private int f10811e;

    public OfflineMapCity() {
        this.f10807a = "";
        this.f10808b = 0L;
        this.f10809c = 6;
        this.f10810d = "";
        this.f10811e = 0;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.f10808b;
    }

    public int getState() {
        return this.f10809c;
    }

    public String getUrl() {
        return this.f10807a;
    }

    public String getVersion() {
        return this.f10810d;
    }

    public int getcompleteCode() {
        return this.f10811e;
    }

    public void setCompleteCode(int i4) {
        this.f10811e = i4;
    }

    public void setSize(long j4) {
        this.f10808b = j4;
    }

    public void setState(int i4) {
        this.f10809c = i4;
    }

    public void setUrl(String str) {
        this.f10807a = str;
    }

    public void setVersion(String str) {
        this.f10810d = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.f10807a);
        parcel.writeLong(this.f10808b);
        parcel.writeInt(this.f10809c);
        parcel.writeString(this.f10810d);
        parcel.writeInt(this.f10811e);
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f10807a = "";
        this.f10808b = 0L;
        this.f10809c = 6;
        this.f10810d = "";
        this.f10811e = 0;
        this.f10807a = parcel.readString();
        this.f10808b = parcel.readLong();
        this.f10809c = parcel.readInt();
        this.f10810d = parcel.readString();
        this.f10811e = parcel.readInt();
    }
}
