package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WalkRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResultV2> CREATOR = new Parcelable.Creator<WalkRouteResultV2>() { // from class: com.amap.api.services.route.WalkRouteResultV2.1
        /* renamed from: a */
        private static WalkRouteResultV2 m51748a(Parcel parcel) {
            return new WalkRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResultV2 createFromParcel(Parcel parcel) {
            return m51748a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResultV2[] newArray(int i) {
            return m51749a(i);
        }

        /* renamed from: a */
        private static WalkRouteResultV2[] m51749a(int i) {
            return new WalkRouteResultV2[i];
        }
    };

    /* renamed from: a */
    private List<WalkPath> f7891a;

    /* renamed from: b */
    private RouteSearchV2.WalkRouteQuery f7892b;

    public WalkRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f7891a = new ArrayList();
        this.f7891a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f7892b = (RouteSearchV2.WalkRouteQuery) parcel.readParcelable(RouteSearchV2.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f7891a;
    }

    public RouteSearchV2.WalkRouteQuery getWalkQuery() {
        return this.f7892b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f7891a = list;
    }

    public void setWalkQuery(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        this.f7892b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f7891a);
        parcel.writeParcelable(this.f7892b, i);
    }

    public WalkRouteResultV2() {
        this.f7891a = new ArrayList();
    }
}
