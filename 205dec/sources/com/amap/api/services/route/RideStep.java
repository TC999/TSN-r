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
public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = new Parcelable.Creator<RideStep>() { // from class: com.amap.api.services.route.RideStep.1
        private static RideStep a(Parcel parcel) {
            return new RideStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideStep[] newArray(int i4) {
            return a(i4);
        }

        private static RideStep[] a(int i4) {
            return new RideStep[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11381a;

    /* renamed from: b  reason: collision with root package name */
    private String f11382b;

    /* renamed from: c  reason: collision with root package name */
    private String f11383c;

    /* renamed from: d  reason: collision with root package name */
    private float f11384d;

    /* renamed from: e  reason: collision with root package name */
    private float f11385e;

    /* renamed from: f  reason: collision with root package name */
    private List<LatLonPoint> f11386f;

    /* renamed from: g  reason: collision with root package name */
    private String f11387g;

    /* renamed from: h  reason: collision with root package name */
    private String f11388h;

    /* renamed from: i  reason: collision with root package name */
    private int f11389i;

    public RideStep() {
        this.f11386f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f11387g;
    }

    public String getAssistantAction() {
        return this.f11388h;
    }

    public float getDistance() {
        return this.f11384d;
    }

    public float getDuration() {
        return this.f11385e;
    }

    public String getInstruction() {
        return this.f11381a;
    }

    public String getOrientation() {
        return this.f11382b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11386f;
    }

    public String getRoad() {
        return this.f11383c;
    }

    public int getRoadType() {
        return this.f11389i;
    }

    public void setAction(String str) {
        this.f11387g = str;
    }

    public void setAssistantAction(String str) {
        this.f11388h = str;
    }

    public void setDistance(float f4) {
        this.f11384d = f4;
    }

    public void setDuration(float f4) {
        this.f11385e = f4;
    }

    public void setInstruction(String str) {
        this.f11381a = str;
    }

    public void setOrientation(String str) {
        this.f11382b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11386f = list;
    }

    public void setRoad(String str) {
        this.f11383c = str;
    }

    public void setRoadType(int i4) {
        this.f11389i = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11381a);
        parcel.writeString(this.f11382b);
        parcel.writeString(this.f11383c);
        parcel.writeFloat(this.f11384d);
        parcel.writeFloat(this.f11385e);
        parcel.writeTypedList(this.f11386f);
        parcel.writeString(this.f11387g);
        parcel.writeString(this.f11388h);
    }

    protected RideStep(Parcel parcel) {
        this.f11386f = new ArrayList();
        this.f11381a = parcel.readString();
        this.f11382b = parcel.readString();
        this.f11383c = parcel.readString();
        this.f11384d = parcel.readFloat();
        this.f11385e = parcel.readFloat();
        this.f11386f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f11387g = parcel.readString();
        this.f11388h = parcel.readString();
    }
}
