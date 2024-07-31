package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AutoTChargeStationResult implements Parcelable {
    public static final Parcelable.Creator<AutoTChargeStationResult> CREATOR = new Parcelable.Creator<AutoTChargeStationResult>() { // from class: com.amap.api.services.auto.AutoTChargeStationResult.1
        /* renamed from: a */
        private static AutoTChargeStationResult m51960a(Parcel parcel) {
            return new AutoTChargeStationResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AutoTChargeStationResult createFromParcel(Parcel parcel) {
            return m51960a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AutoTChargeStationResult[] newArray(int i) {
            return m51961a(i);
        }

        /* renamed from: a */
        private static AutoTChargeStationResult[] m51961a(int i) {
            return new AutoTChargeStationResult[i];
        }
    };
    public Classify classify;
    public int code;
    public ListData listData;
    public Lqii lqii;
    public String message;
    public Meta meta;
    public String originJson;

    public AutoTChargeStationResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.classify, i);
        parcel.writeParcelable(this.listData, i);
        parcel.writeParcelable(this.lqii, i);
        parcel.writeParcelable(this.meta, i);
        parcel.writeString(this.originJson);
    }

    protected AutoTChargeStationResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.classify = (Classify) parcel.readParcelable(Classify.class.getClassLoader());
        this.listData = (ListData) parcel.readParcelable(ListData.class.getClassLoader());
        this.lqii = (Lqii) parcel.readParcelable(Lqii.class.getClassLoader());
        this.meta = (Meta) parcel.readParcelable(Meta.class.getClassLoader());
        this.originJson = parcel.readString();
    }
}
