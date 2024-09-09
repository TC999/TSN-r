package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = new Parcelable.Creator<DrivePlanStep>() { // from class: com.amap.api.services.route.DrivePlanStep.1
        private static DrivePlanStep a(Parcel parcel) {
            return new DrivePlanStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanStep[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11318a;

    /* renamed from: b  reason: collision with root package name */
    private String f11319b;

    /* renamed from: c  reason: collision with root package name */
    private float f11320c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11321d;

    /* renamed from: e  reason: collision with root package name */
    private List<LatLonPoint> f11322e;

    public DrivePlanStep(Parcel parcel) {
        this.f11322e = new ArrayList();
        this.f11318a = parcel.readString();
        this.f11319b = parcel.readString();
        this.f11320c = parcel.readFloat();
        this.f11321d = parcel.readInt() == 1;
        this.f11320c = parcel.readFloat();
        this.f11322e = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f11319b;
    }

    public float getDistance() {
        return this.f11320c;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11322e;
    }

    public String getRoad() {
        return this.f11318a;
    }

    public boolean getToll() {
        return this.f11321d;
    }

    public void setAdCode(String str) {
        this.f11319b = str;
    }

    public void setDistance(float f4) {
        this.f11320c = f4;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11322e = list;
    }

    public void setRoad(String str) {
        this.f11318a = str;
    }

    public void setToll(boolean z3) {
        this.f11321d = z3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11318a);
        parcel.writeString(this.f11319b);
        parcel.writeFloat(this.f11320c);
        parcel.writeInt(this.f11321d ? 1 : 0);
        parcel.writeFloat(this.f11320c);
        parcel.writeTypedList(this.f11322e);
    }

    public DrivePlanStep() {
        this.f11322e = new ArrayList();
    }
}
