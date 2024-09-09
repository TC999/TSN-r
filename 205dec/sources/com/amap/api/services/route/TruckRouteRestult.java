package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new Parcelable.Creator<TruckRouteRestult>() { // from class: com.amap.api.services.route.TruckRouteRestult.1
        private static TruckRouteRestult a(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult[] newArray(int i4) {
            return a(i4);
        }

        private static TruckRouteRestult[] a(int i4) {
            return new TruckRouteRestult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private RouteSearch.TruckRouteQuery f11565a;

    /* renamed from: b  reason: collision with root package name */
    private List<TruckPath> f11566b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f11567c;

    /* renamed from: d  reason: collision with root package name */
    private LatLonPoint f11568d;

    public TruckRouteRestult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TruckPath> getPaths() {
        return this.f11566b;
    }

    public LatLonPoint getStartPos() {
        return this.f11567c;
    }

    public LatLonPoint getTargetPos() {
        return this.f11568d;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.f11565a;
    }

    public void setPaths(List<TruckPath> list) {
        this.f11566b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f11567c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f11568d = latLonPoint;
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.f11565a = truckRouteQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.f11566b);
        parcel.writeParcelable(this.f11567c, i4);
        parcel.writeParcelable(this.f11568d, i4);
    }

    protected TruckRouteRestult(Parcel parcel) {
        this.f11566b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.f11567c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11568d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
