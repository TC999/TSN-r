package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new Parcelable.Creator<TMC>() { // from class: com.amap.api.services.route.TMC.1
        /* renamed from: a */
        private static TMC m51765a(Parcel parcel) {
            return new TMC(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TMC createFromParcel(Parcel parcel) {
            return m51765a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TMC[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private int f7839a;

    /* renamed from: b */
    private String f7840b;

    /* renamed from: c */
    private List<LatLonPoint> f7841c;

    public TMC(Parcel parcel) {
        this.f7841c = new ArrayList();
        this.f7839a = parcel.readInt();
        this.f7840b = parcel.readString();
        this.f7841c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f7839a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7841c;
    }

    public String getStatus() {
        return this.f7840b;
    }

    public void setDistance(int i) {
        this.f7839a = i;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7841c = list;
    }

    public void setStatus(String str) {
        this.f7840b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7839a);
        parcel.writeString(this.f7840b);
        parcel.writeTypedList(this.f7841c);
    }

    public TMC() {
        this.f7841c = new ArrayList();
    }
}
