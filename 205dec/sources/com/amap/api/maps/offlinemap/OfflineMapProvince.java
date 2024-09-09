package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new Parcelable.Creator<OfflineMapProvince>() { // from class: com.amap.api.maps.offlinemap.OfflineMapProvince.1
        private static OfflineMapProvince a(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince[] newArray(int i4) {
            return a(i4);
        }

        private static OfflineMapProvince[] a(int i4) {
            return new OfflineMapProvince[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10831a;

    /* renamed from: b  reason: collision with root package name */
    private int f10832b;

    /* renamed from: c  reason: collision with root package name */
    private long f10833c;

    /* renamed from: d  reason: collision with root package name */
    private String f10834d;

    /* renamed from: e  reason: collision with root package name */
    private int f10835e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<OfflineMapCity> f10836f;

    public OfflineMapProvince() {
        this.f10832b = 6;
        this.f10835e = 0;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        ArrayList<OfflineMapCity> arrayList = this.f10836f;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = this.f10836f;
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
        return this.f10833c;
    }

    public int getState() {
        return this.f10832b;
    }

    public String getUrl() {
        return this.f10831a;
    }

    public String getVersion() {
        return this.f10834d;
    }

    public int getcompleteCode() {
        return this.f10835e;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f10836f = arrayList;
    }

    public void setCompleteCode(int i4) {
        this.f10835e = i4;
    }

    public void setSize(long j4) {
        this.f10833c = j4;
    }

    public void setState(int i4) {
        this.f10832b = i4;
    }

    public void setUrl(String str) {
        this.f10831a = str;
    }

    public void setVersion(String str) {
        this.f10834d = str;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.f10831a);
        parcel.writeInt(this.f10832b);
        parcel.writeLong(this.f10833c);
        parcel.writeString(this.f10834d);
        parcel.writeInt(this.f10835e);
        parcel.writeTypedList(this.f10836f);
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f10832b = 6;
        this.f10835e = 0;
        this.f10831a = parcel.readString();
        this.f10832b = parcel.readInt();
        this.f10833c = parcel.readLong();
        this.f10834d = parcel.readString();
        this.f10835e = parcel.readInt();
        this.f10836f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }
}
