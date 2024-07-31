package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new Parcelable.Creator<WalkRouteResult>() { // from class: com.amap.api.services.route.WalkRouteResult.1
        /* renamed from: a */
        private static WalkRouteResult m51750a(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult createFromParcel(Parcel parcel) {
            return m51750a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult[] newArray(int i) {
            return m51751a(i);
        }

        /* renamed from: a */
        private static WalkRouteResult[] m51751a(int i) {
            return new WalkRouteResult[i];
        }
    };

    /* renamed from: a */
    private List<WalkPath> f7889a;

    /* renamed from: b */
    private RouteSearch.WalkRouteQuery f7890b;

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f7889a = new ArrayList();
        this.f7889a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f7890b = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f7889a;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.f7890b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f7889a = list;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.f7890b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f7889a);
        parcel.writeParcelable(this.f7890b, i);
    }

    public WalkRouteResult() {
        this.f7889a = new ArrayList();
    }
}
