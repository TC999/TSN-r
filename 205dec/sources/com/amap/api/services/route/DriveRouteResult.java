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
public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new Parcelable.Creator<DriveRouteResult>() { // from class: com.amap.api.services.route.DriveRouteResult.1
        private static DriveRouteResult a(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult[] newArray(int i4) {
            return a(i4);
        }

        private static DriveRouteResult[] a(int i4) {
            return new DriveRouteResult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11326a;

    /* renamed from: b  reason: collision with root package name */
    private List<DrivePath> f11327b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearch.DriveRouteQuery f11328c;

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f11327b = new ArrayList();
        this.f11326a = parcel.readFloat();
        this.f11327b = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f11328c = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.f11328c;
    }

    public List<DrivePath> getPaths() {
        return this.f11327b;
    }

    public float getTaxiCost() {
        return this.f11326a;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.f11328c = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.f11327b = list;
    }

    public void setTaxiCost(float f4) {
        this.f11326a = f4;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeFloat(this.f11326a);
        parcel.writeTypedList(this.f11327b);
        parcel.writeParcelable(this.f11328c, i4);
    }

    public DriveRouteResult() {
        this.f11327b = new ArrayList();
    }
}
