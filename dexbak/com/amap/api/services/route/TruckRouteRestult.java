package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new Parcelable.Creator<TruckRouteRestult>() { // from class: com.amap.api.services.route.TruckRouteRestult.1
        /* renamed from: a */
        private static TruckRouteRestult m51755a(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult createFromParcel(Parcel parcel) {
            return m51755a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult[] newArray(int i) {
            return m51756a(i);
        }

        /* renamed from: a */
        private static TruckRouteRestult[] m51756a(int i) {
            return new TruckRouteRestult[i];
        }
    };

    /* renamed from: a */
    private RouteSearch.TruckRouteQuery f7871a;

    /* renamed from: b */
    private List<TruckPath> f7872b;

    /* renamed from: c */
    private LatLonPoint f7873c;

    /* renamed from: d */
    private LatLonPoint f7874d;

    public TruckRouteRestult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TruckPath> getPaths() {
        return this.f7872b;
    }

    public LatLonPoint getStartPos() {
        return this.f7873c;
    }

    public LatLonPoint getTargetPos() {
        return this.f7874d;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.f7871a;
    }

    public void setPaths(List<TruckPath> list) {
        this.f7872b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f7873c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f7874d = latLonPoint;
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.f7871a = truckRouteQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f7872b);
        parcel.writeParcelable(this.f7873c, i);
        parcel.writeParcelable(this.f7874d, i);
    }

    protected TruckRouteRestult(Parcel parcel) {
        this.f7872b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.f7873c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7874d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
