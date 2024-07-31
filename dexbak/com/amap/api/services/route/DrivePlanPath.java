package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new Parcelable.Creator<DrivePlanPath>() { // from class: com.amap.api.services.route.DrivePlanPath.1
        /* renamed from: a */
        private static DrivePlanPath m51823a(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanPath createFromParcel(Parcel parcel) {
            return m51823a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    float f7621a;

    /* renamed from: b */
    int f7622b;

    /* renamed from: c */
    private List<DrivePlanStep> f7623c;

    public DrivePlanPath(Parcel parcel) {
        this.f7623c = new ArrayList();
        this.f7621a = parcel.readFloat();
        this.f7622b = parcel.readInt();
        this.f7623c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f7621a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.f7623c;
    }

    public float getTrafficLights() {
        return this.f7622b;
    }

    public void setDistance(float f) {
        this.f7621a = f;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.f7623c = list;
    }

    public void setTrafficLights(int i) {
        this.f7622b = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f7621a);
        parcel.writeInt(this.f7622b);
        parcel.writeTypedList(this.f7623c);
    }

    public DrivePlanPath() {
        this.f7623c = new ArrayList();
    }
}
