package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new Parcelable.Creator<RouteBusWalkItem>() { // from class: com.amap.api.services.route.RouteBusWalkItem.1
        /* renamed from: a */
        private static RouteBusWalkItem m51798a(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusWalkItem createFromParcel(Parcel parcel) {
            return m51798a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusWalkItem[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private LatLonPoint f7702a;

    /* renamed from: b */
    private LatLonPoint f7703b;

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f7702a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7703b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f7703b;
    }

    public LatLonPoint getOrigin() {
        return this.f7702a;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f7703b = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f7702a = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f7702a, i);
        parcel.writeParcelable(this.f7703b, i);
    }

    public RouteBusWalkItem() {
    }
}
