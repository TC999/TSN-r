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
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new Parcelable.Creator<TMC>() { // from class: com.amap.api.services.route.TMC.1
        private static TMC a(Parcel parcel) {
            return new TMC(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TMC createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TMC[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f11533a;

    /* renamed from: b  reason: collision with root package name */
    private String f11534b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLonPoint> f11535c;

    public TMC(Parcel parcel) {
        this.f11535c = new ArrayList();
        this.f11533a = parcel.readInt();
        this.f11534b = parcel.readString();
        this.f11535c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f11533a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11535c;
    }

    public String getStatus() {
        return this.f11534b;
    }

    public void setDistance(int i4) {
        this.f11533a = i4;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11535c = list;
    }

    public void setStatus(String str) {
        this.f11534b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f11533a);
        parcel.writeString(this.f11534b);
        parcel.writeTypedList(this.f11535c);
    }

    public TMC() {
        this.f11535c = new ArrayList();
    }
}
