package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = new Parcelable.Creator<Doorway>() { // from class: com.amap.api.services.route.Doorway.1
        /* renamed from: a */
        private static Doorway m51826a(Parcel parcel) {
            return new Doorway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Doorway createFromParcel(Parcel parcel) {
            return m51826a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Doorway[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7607a;

    /* renamed from: b */
    private LatLonPoint f7608b;

    public Doorway(Parcel parcel) {
        this.f7607a = parcel.readString();
        this.f7608b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f7608b;
    }

    public String getName() {
        return this.f7607a;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f7608b = latLonPoint;
    }

    public void setName(String str) {
        this.f7607a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7607a);
        parcel.writeParcelable(this.f7608b, i);
    }

    public Doorway() {
    }
}
