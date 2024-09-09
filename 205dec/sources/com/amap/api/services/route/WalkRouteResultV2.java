package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class WalkRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResultV2> CREATOR = new Parcelable.Creator<WalkRouteResultV2>() { // from class: com.amap.api.services.route.WalkRouteResultV2.1
        private static WalkRouteResultV2 a(Parcel parcel) {
            return new WalkRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResultV2[] newArray(int i4) {
            return a(i4);
        }

        private static WalkRouteResultV2[] a(int i4) {
            return new WalkRouteResultV2[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<WalkPath> f11585a;

    /* renamed from: b  reason: collision with root package name */
    private RouteSearchV2.WalkRouteQuery f11586b;

    public WalkRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f11585a = new ArrayList();
        this.f11585a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f11586b = (RouteSearchV2.WalkRouteQuery) parcel.readParcelable(RouteSearchV2.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f11585a;
    }

    public RouteSearchV2.WalkRouteQuery getWalkQuery() {
        return this.f11586b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f11585a = list;
    }

    public void setWalkQuery(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        this.f11586b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f11585a);
        parcel.writeParcelable(this.f11586b, i4);
    }

    public WalkRouteResultV2() {
        this.f11585a = new ArrayList();
    }
}
