package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusPathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPathV2> CREATOR = new Parcelable.Creator<BusPathV2>() { // from class: com.amap.api.services.route.BusPathV2.1
        /* renamed from: a */
        private static BusPathV2 m51840a(Parcel parcel) {
            return new BusPathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPathV2 createFromParcel(Parcel parcel) {
            return m51840a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPathV2[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private float f7550a;

    /* renamed from: b */
    private boolean f7551b;

    /* renamed from: c */
    private float f7552c;

    /* renamed from: d */
    private float f7553d;

    /* renamed from: e */
    private List<BusStepV2> f7554e;

    public BusPathV2(Parcel parcel) {
        super(parcel);
        this.f7554e = new ArrayList();
        this.f7550a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f7551b = zArr[0];
        this.f7552c = parcel.readFloat();
        this.f7553d = parcel.readFloat();
        this.f7554e = parcel.createTypedArrayList(BusStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f7553d;
    }

    public float getCost() {
        return this.f7550a;
    }

    public List<BusStepV2> getSteps() {
        return this.f7554e;
    }

    public float getWalkDistance() {
        return this.f7552c;
    }

    public boolean isNightBus() {
        return this.f7551b;
    }

    public void setBusDistance(float f) {
        this.f7553d = f;
    }

    public void setCost(float f) {
        this.f7550a = f;
    }

    public void setNightBus(boolean z) {
        this.f7551b = z;
    }

    public void setSteps(List<BusStepV2> list) {
        this.f7554e = list;
    }

    public void setWalkDistance(float f) {
        this.f7552c = f;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f7550a);
        parcel.writeBooleanArray(new boolean[]{this.f7551b});
        parcel.writeFloat(this.f7552c);
        parcel.writeFloat(this.f7553d);
        parcel.writeTypedList(this.f7554e);
    }

    public BusPathV2() {
        this.f7554e = new ArrayList();
    }
}
