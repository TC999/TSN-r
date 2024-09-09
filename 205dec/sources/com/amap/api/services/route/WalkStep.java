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
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new Parcelable.Creator<WalkStep>() { // from class: com.amap.api.services.route.WalkStep.1
        private static WalkStep a(Parcel parcel) {
            return new WalkStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WalkStep[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11587a;

    /* renamed from: b  reason: collision with root package name */
    private String f11588b;

    /* renamed from: c  reason: collision with root package name */
    private String f11589c;

    /* renamed from: d  reason: collision with root package name */
    private float f11590d;

    /* renamed from: e  reason: collision with root package name */
    private float f11591e;

    /* renamed from: f  reason: collision with root package name */
    private List<LatLonPoint> f11592f;

    /* renamed from: g  reason: collision with root package name */
    private String f11593g;

    /* renamed from: h  reason: collision with root package name */
    private String f11594h;

    /* renamed from: i  reason: collision with root package name */
    private int f11595i;

    public WalkStep(Parcel parcel) {
        this.f11592f = new ArrayList();
        this.f11587a = parcel.readString();
        this.f11588b = parcel.readString();
        this.f11589c = parcel.readString();
        this.f11590d = parcel.readFloat();
        this.f11591e = parcel.readFloat();
        this.f11592f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f11593g = parcel.readString();
        this.f11594h = parcel.readString();
        this.f11595i = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f11593g;
    }

    public String getAssistantAction() {
        return this.f11594h;
    }

    public float getDistance() {
        return this.f11590d;
    }

    public float getDuration() {
        return this.f11591e;
    }

    public String getInstruction() {
        return this.f11587a;
    }

    public String getOrientation() {
        return this.f11588b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11592f;
    }

    public String getRoad() {
        return this.f11589c;
    }

    public int getRoadType() {
        return this.f11595i;
    }

    public void setAction(String str) {
        this.f11593g = str;
    }

    public void setAssistantAction(String str) {
        this.f11594h = str;
    }

    public void setDistance(float f4) {
        this.f11590d = f4;
    }

    public void setDuration(float f4) {
        this.f11591e = f4;
    }

    public void setInstruction(String str) {
        this.f11587a = str;
    }

    public void setOrientation(String str) {
        this.f11588b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11592f = list;
    }

    public void setRoad(String str) {
        this.f11589c = str;
    }

    public void setRoadType(int i4) {
        this.f11595i = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11587a);
        parcel.writeString(this.f11588b);
        parcel.writeString(this.f11589c);
        parcel.writeFloat(this.f11590d);
        parcel.writeFloat(this.f11591e);
        parcel.writeTypedList(this.f11592f);
        parcel.writeString(this.f11593g);
        parcel.writeString(this.f11594h);
        parcel.writeInt(this.f11595i);
    }

    public WalkStep() {
        this.f11592f = new ArrayList();
    }
}
