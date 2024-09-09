package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusPath extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPath> CREATOR = new Parcelable.Creator<BusPath>() { // from class: com.amap.api.services.route.BusPath.1
        private static BusPath a(Parcel parcel) {
            return new BusPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPath[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11239a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11240b;

    /* renamed from: c  reason: collision with root package name */
    private float f11241c;

    /* renamed from: d  reason: collision with root package name */
    private float f11242d;

    /* renamed from: e  reason: collision with root package name */
    private List<BusStep> f11243e;

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f11243e = new ArrayList();
        this.f11239a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f11240b = zArr[0];
        this.f11241c = parcel.readFloat();
        this.f11242d = parcel.readFloat();
        this.f11243e = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f11242d;
    }

    public float getCost() {
        return this.f11239a;
    }

    public List<BusStep> getSteps() {
        return this.f11243e;
    }

    public float getWalkDistance() {
        return this.f11241c;
    }

    public boolean isNightBus() {
        return this.f11240b;
    }

    public void setBusDistance(float f4) {
        this.f11242d = f4;
    }

    public void setCost(float f4) {
        this.f11239a = f4;
    }

    public void setNightBus(boolean z3) {
        this.f11240b = z3;
    }

    public void setSteps(List<BusStep> list) {
        this.f11243e = list;
    }

    public void setWalkDistance(float f4) {
        this.f11241c = f4;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeFloat(this.f11239a);
        parcel.writeBooleanArray(new boolean[]{this.f11240b});
        parcel.writeFloat(this.f11241c);
        parcel.writeFloat(this.f11242d);
        parcel.writeTypedList(this.f11243e);
    }

    public BusPath() {
        this.f11243e = new ArrayList();
    }
}
