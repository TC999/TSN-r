package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new Parcelable.Creator<RouteBusWalkItem>() { // from class: com.amap.api.services.route.RouteBusWalkItem.1
        private static RouteBusWalkItem a(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusWalkItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusWalkItem[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f11396a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11397b;

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f11396a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11397b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f11397b;
    }

    public LatLonPoint getOrigin() {
        return this.f11396a;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f11397b = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f11396a = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.f11396a, i4);
        parcel.writeParcelable(this.f11397b, i4);
    }

    public RouteBusWalkItem() {
    }
}
