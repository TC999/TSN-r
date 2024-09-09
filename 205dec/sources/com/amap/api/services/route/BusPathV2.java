package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusPathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPathV2> CREATOR = new Parcelable.Creator<BusPathV2>() { // from class: com.amap.api.services.route.BusPathV2.1
        private static BusPathV2 a(Parcel parcel) {
            return new BusPathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPathV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPathV2[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11244a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11245b;

    /* renamed from: c  reason: collision with root package name */
    private float f11246c;

    /* renamed from: d  reason: collision with root package name */
    private float f11247d;

    /* renamed from: e  reason: collision with root package name */
    private List<BusStepV2> f11248e;

    public BusPathV2(Parcel parcel) {
        super(parcel);
        this.f11248e = new ArrayList();
        this.f11244a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f11245b = zArr[0];
        this.f11246c = parcel.readFloat();
        this.f11247d = parcel.readFloat();
        this.f11248e = parcel.createTypedArrayList(BusStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f11247d;
    }

    public float getCost() {
        return this.f11244a;
    }

    public List<BusStepV2> getSteps() {
        return this.f11248e;
    }

    public float getWalkDistance() {
        return this.f11246c;
    }

    public boolean isNightBus() {
        return this.f11245b;
    }

    public void setBusDistance(float f4) {
        this.f11247d = f4;
    }

    public void setCost(float f4) {
        this.f11244a = f4;
    }

    public void setNightBus(boolean z3) {
        this.f11245b = z3;
    }

    public void setSteps(List<BusStepV2> list) {
        this.f11248e = list;
    }

    public void setWalkDistance(float f4) {
        this.f11246c = f4;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeFloat(this.f11244a);
        parcel.writeBooleanArray(new boolean[]{this.f11245b});
        parcel.writeFloat(this.f11246c);
        parcel.writeFloat(this.f11247d);
        parcel.writeTypedList(this.f11248e);
    }

    public BusPathV2() {
        this.f11248e = new ArrayList();
    }
}
