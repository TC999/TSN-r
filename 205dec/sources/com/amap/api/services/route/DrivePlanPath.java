package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new Parcelable.Creator<DrivePlanPath>() { // from class: com.amap.api.services.route.DrivePlanPath.1
        private static DrivePlanPath a(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    float f11315a;

    /* renamed from: b  reason: collision with root package name */
    int f11316b;

    /* renamed from: c  reason: collision with root package name */
    private List<DrivePlanStep> f11317c;

    public DrivePlanPath(Parcel parcel) {
        this.f11317c = new ArrayList();
        this.f11315a = parcel.readFloat();
        this.f11316b = parcel.readInt();
        this.f11317c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f11315a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.f11317c;
    }

    public float getTrafficLights() {
        return this.f11316b;
    }

    public void setDistance(float f4) {
        this.f11315a = f4;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.f11317c = list;
    }

    public void setTrafficLights(int i4) {
        this.f11316b = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f11315a);
        parcel.writeInt(this.f11316b);
        parcel.writeTypedList(this.f11317c);
    }

    public DrivePlanPath() {
        this.f11317c = new ArrayList();
    }
}
