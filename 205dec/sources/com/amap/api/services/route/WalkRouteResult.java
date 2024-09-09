package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new Parcelable.Creator<WalkRouteResult>() { // from class: com.amap.api.services.route.WalkRouteResult.1
        private static WalkRouteResult a(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult[] newArray(int i4) {
            return a(i4);
        }

        private static WalkRouteResult[] a(int i4) {
            return new WalkRouteResult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<WalkPath> f11583a;

    /* renamed from: b  reason: collision with root package name */
    private RouteSearch.WalkRouteQuery f11584b;

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f11583a = new ArrayList();
        this.f11583a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f11584b = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f11583a;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.f11584b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f11583a = list;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.f11584b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f11583a);
        parcel.writeParcelable(this.f11584b, i4);
    }

    public WalkRouteResult() {
        this.f11583a = new ArrayList();
    }
}
