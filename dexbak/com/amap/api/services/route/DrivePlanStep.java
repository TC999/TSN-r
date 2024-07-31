package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = new Parcelable.Creator<DrivePlanStep>() { // from class: com.amap.api.services.route.DrivePlanStep.1
        /* renamed from: a */
        private static DrivePlanStep m51822a(Parcel parcel) {
            return new DrivePlanStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanStep createFromParcel(Parcel parcel) {
            return m51822a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanStep[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7624a;

    /* renamed from: b */
    private String f7625b;

    /* renamed from: c */
    private float f7626c;

    /* renamed from: d */
    private boolean f7627d;

    /* renamed from: e */
    private List<LatLonPoint> f7628e;

    public DrivePlanStep(Parcel parcel) {
        this.f7628e = new ArrayList();
        this.f7624a = parcel.readString();
        this.f7625b = parcel.readString();
        this.f7626c = parcel.readFloat();
        this.f7627d = parcel.readInt() == 1;
        this.f7626c = parcel.readFloat();
        this.f7628e = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f7625b;
    }

    public float getDistance() {
        return this.f7626c;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7628e;
    }

    public String getRoad() {
        return this.f7624a;
    }

    public boolean getToll() {
        return this.f7627d;
    }

    public void setAdCode(String str) {
        this.f7625b = str;
    }

    public void setDistance(float f) {
        this.f7626c = f;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7628e = list;
    }

    public void setRoad(String str) {
        this.f7624a = str;
    }

    public void setToll(boolean z) {
        this.f7627d = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7624a);
        parcel.writeString(this.f7625b);
        parcel.writeFloat(this.f7626c);
        parcel.writeInt(this.f7627d ? 1 : 0);
        parcel.writeFloat(this.f7626c);
        parcel.writeTypedList(this.f7628e);
    }

    public DrivePlanStep() {
        this.f7628e = new ArrayList();
    }
}
