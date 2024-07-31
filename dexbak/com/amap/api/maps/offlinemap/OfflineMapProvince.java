package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new Parcelable.Creator<OfflineMapProvince>() { // from class: com.amap.api.maps.offlinemap.OfflineMapProvince.1
        /* renamed from: a */
        private static OfflineMapProvince m51980a(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince createFromParcel(Parcel parcel) {
            return m51980a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince[] newArray(int i) {
            return m51981a(i);
        }

        /* renamed from: a */
        private static OfflineMapProvince[] m51981a(int i) {
            return new OfflineMapProvince[i];
        }
    };

    /* renamed from: a */
    private String f7133a;

    /* renamed from: b */
    private int f7134b;

    /* renamed from: c */
    private long f7135c;

    /* renamed from: d */
    private String f7136d;

    /* renamed from: e */
    private int f7137e;

    /* renamed from: f */
    private ArrayList<OfflineMapCity> f7138f;

    public OfflineMapProvince() {
        this.f7134b = 6;
        this.f7137e = 0;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        ArrayList<OfflineMapCity> arrayList = this.f7138f;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = this.f7138f;
        if (arrayList2 == null) {
            return arrayList;
        }
        Iterator<OfflineMapCity> it = arrayList2.iterator();
        while (it.hasNext()) {
            OfflineMapCity next = it.next();
            if (next.getState() != 6) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public long getSize() {
        return this.f7135c;
    }

    public int getState() {
        return this.f7134b;
    }

    public String getUrl() {
        return this.f7133a;
    }

    public String getVersion() {
        return this.f7136d;
    }

    public int getcompleteCode() {
        return this.f7137e;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f7138f = arrayList;
    }

    public void setCompleteCode(int i) {
        this.f7137e = i;
    }

    public void setSize(long j) {
        this.f7135c = j;
    }

    public void setState(int i) {
        this.f7134b = i;
    }

    public void setUrl(String str) {
        this.f7133a = str;
    }

    public void setVersion(String str) {
        this.f7136d = str;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f7133a);
        parcel.writeInt(this.f7134b);
        parcel.writeLong(this.f7135c);
        parcel.writeString(this.f7136d);
        parcel.writeInt(this.f7137e);
        parcel.writeTypedList(this.f7138f);
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f7134b = 6;
        this.f7137e = 0;
        this.f7133a = parcel.readString();
        this.f7134b = parcel.readInt();
        this.f7135c = parcel.readLong();
        this.f7136d = parcel.readString();
        this.f7137e = parcel.readInt();
        this.f7138f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }
}
