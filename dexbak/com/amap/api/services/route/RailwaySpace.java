package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() { // from class: com.amap.api.services.route.RailwaySpace.1
        /* renamed from: a */
        private static RailwaySpace m51809a(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace createFromParcel(Parcel parcel) {
            return m51809a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace[] newArray(int i) {
            return m51810a(i);
        }

        /* renamed from: a */
        private static RailwaySpace[] m51810a(int i) {
            return new RailwaySpace[i];
        }
    };

    /* renamed from: a */
    private String f7672a;

    /* renamed from: b */
    private float f7673b;

    public RailwaySpace(String str, float f) {
        this.f7672a = str;
        this.f7673b = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.f7672a;
    }

    public float getCost() {
        return this.f7673b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7672a);
        parcel.writeFloat(this.f7673b);
    }

    protected RailwaySpace(Parcel parcel) {
        this.f7672a = parcel.readString();
        this.f7673b = parcel.readFloat();
    }
}
