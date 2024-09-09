package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() { // from class: com.amap.api.services.route.RailwaySpace.1
        private static RailwaySpace a(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace[] newArray(int i4) {
            return a(i4);
        }

        private static RailwaySpace[] a(int i4) {
            return new RailwaySpace[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11366a;

    /* renamed from: b  reason: collision with root package name */
    private float f11367b;

    public RailwaySpace(String str, float f4) {
        this.f11366a = str;
        this.f11367b = f4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.f11366a;
    }

    public float getCost() {
        return this.f11367b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11366a);
        parcel.writeFloat(this.f11367b);
    }

    protected RailwaySpace(Parcel parcel) {
        this.f11366a = parcel.readString();
        this.f11367b = parcel.readFloat();
    }
}
