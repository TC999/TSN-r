package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TruckPath implements Parcelable {
    public static final Parcelable.Creator<TruckPath> CREATOR = new Parcelable.Creator<TruckPath>() { // from class: com.amap.api.services.route.TruckPath.1
        private static TruckPath a(Parcel parcel) {
            return new TruckPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath[] newArray(int i4) {
            return a(i4);
        }

        private static TruckPath[] a(int i4) {
            return new TruckPath[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11557a;

    /* renamed from: b  reason: collision with root package name */
    private long f11558b;

    /* renamed from: c  reason: collision with root package name */
    private String f11559c;

    /* renamed from: d  reason: collision with root package name */
    private float f11560d;

    /* renamed from: e  reason: collision with root package name */
    private float f11561e;

    /* renamed from: f  reason: collision with root package name */
    private int f11562f;

    /* renamed from: g  reason: collision with root package name */
    private int f11563g;

    /* renamed from: h  reason: collision with root package name */
    private List<TruckStep> f11564h;

    public TruckPath() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f11557a;
    }

    public long getDuration() {
        return this.f11558b;
    }

    public int getRestriction() {
        return this.f11563g;
    }

    public List<TruckStep> getSteps() {
        return this.f11564h;
    }

    public String getStrategy() {
        return this.f11559c;
    }

    public float getTollDistance() {
        return this.f11561e;
    }

    public float getTolls() {
        return this.f11560d;
    }

    public int getTotalTrafficlights() {
        return this.f11562f;
    }

    public void setDistance(float f4) {
        this.f11557a = f4;
    }

    public void setDuration(long j4) {
        this.f11558b = j4;
    }

    public void setRestriction(int i4) {
        this.f11563g = i4;
    }

    public void setSteps(List<TruckStep> list) {
        this.f11564h = list;
    }

    public void setStrategy(String str) {
        this.f11559c = str;
    }

    public void setTollDistance(float f4) {
        this.f11561e = f4;
    }

    public void setTolls(float f4) {
        this.f11560d = f4;
    }

    public void setTotalTrafficlights(int i4) {
        this.f11562f = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f11557a);
        parcel.writeLong(this.f11558b);
        parcel.writeString(this.f11559c);
        parcel.writeFloat(this.f11560d);
        parcel.writeFloat(this.f11561e);
        parcel.writeInt(this.f11562f);
        parcel.writeInt(this.f11563g);
        parcel.writeTypedList(this.f11564h);
    }

    protected TruckPath(Parcel parcel) {
        this.f11557a = parcel.readFloat();
        this.f11558b = parcel.readLong();
        this.f11559c = parcel.readString();
        this.f11560d = parcel.readFloat();
        this.f11561e = parcel.readFloat();
        this.f11562f = parcel.readInt();
        this.f11563g = parcel.readInt();
        this.f11564h = parcel.createTypedArrayList(TruckStep.CREATOR);
    }
}
