package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new Parcelable.Creator<IndoorData>() { // from class: com.amap.api.services.poisearch.IndoorData.1
        /* renamed from: a */
        private static IndoorData m51863a(Parcel parcel) {
            return new IndoorData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData createFromParcel(Parcel parcel) {
            return m51863a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData[] newArray(int i) {
            return m51864a(i);
        }

        /* renamed from: a */
        private static IndoorData[] m51864a(int i) {
            return new IndoorData[i];
        }
    };

    /* renamed from: a */
    private String f7449a;

    /* renamed from: b */
    private int f7450b;

    /* renamed from: c */
    private String f7451c;

    public IndoorData(String str, int i, String str2) {
        this.f7449a = str;
        this.f7450b = i;
        this.f7451c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f7450b;
    }

    public String getFloorName() {
        return this.f7451c;
    }

    public String getPoiId() {
        return this.f7449a;
    }

    public void setFloor(int i) {
        this.f7450b = i;
    }

    public void setFloorName(String str) {
        this.f7451c = str;
    }

    public void setPoiId(String str) {
        this.f7449a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7449a);
        parcel.writeInt(this.f7450b);
        parcel.writeString(this.f7451c);
    }

    protected IndoorData(Parcel parcel) {
        this.f7449a = parcel.readString();
        this.f7450b = parcel.readInt();
        this.f7451c = parcel.readString();
    }
}
