package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusPath extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPath> CREATOR = new Parcelable.Creator<BusPath>() { // from class: com.amap.api.services.route.BusPath.1
        /* renamed from: a */
        private static BusPath m51841a(Parcel parcel) {
            return new BusPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPath createFromParcel(Parcel parcel) {
            return m51841a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPath[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private float f7545a;

    /* renamed from: b */
    private boolean f7546b;

    /* renamed from: c */
    private float f7547c;

    /* renamed from: d */
    private float f7548d;

    /* renamed from: e */
    private List<BusStep> f7549e;

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f7549e = new ArrayList();
        this.f7545a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f7546b = zArr[0];
        this.f7547c = parcel.readFloat();
        this.f7548d = parcel.readFloat();
        this.f7549e = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f7548d;
    }

    public float getCost() {
        return this.f7545a;
    }

    public List<BusStep> getSteps() {
        return this.f7549e;
    }

    public float getWalkDistance() {
        return this.f7547c;
    }

    public boolean isNightBus() {
        return this.f7546b;
    }

    public void setBusDistance(float f) {
        this.f7548d = f;
    }

    public void setCost(float f) {
        this.f7545a = f;
    }

    public void setNightBus(boolean z) {
        this.f7546b = z;
    }

    public void setSteps(List<BusStep> list) {
        this.f7549e = list;
    }

    public void setWalkDistance(float f) {
        this.f7547c = f;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f7545a);
        parcel.writeBooleanArray(new boolean[]{this.f7546b});
        parcel.writeFloat(this.f7547c);
        parcel.writeFloat(this.f7548d);
        parcel.writeTypedList(this.f7549e);
    }

    public BusPath() {
        this.f7549e = new ArrayList();
    }
}
