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
public class DriveRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResultV2> CREATOR = new Parcelable.Creator<DriveRouteResultV2>() { // from class: com.amap.api.services.route.DriveRouteResultV2.1
        private static DriveRouteResultV2 a(Parcel parcel) {
            return new DriveRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2[] newArray(int i4) {
            return a(i4);
        }

        private static DriveRouteResultV2[] a(int i4) {
            return new DriveRouteResultV2[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11329a;

    /* renamed from: b  reason: collision with root package name */
    private List<DrivePathV2> f11330b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearchV2.DriveRouteQuery f11331c;

    public DriveRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f11330b = new ArrayList();
        this.f11329a = parcel.readFloat();
        this.f11330b = parcel.createTypedArrayList(DrivePathV2.CREATOR);
        this.f11331c = (RouteSearchV2.DriveRouteQuery) parcel.readParcelable(RouteSearchV2.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.DriveRouteQuery getDriveQuery() {
        return this.f11331c;
    }

    public List<DrivePathV2> getPaths() {
        return this.f11330b;
    }

    public float getTaxiCost() {
        return this.f11329a;
    }

    public void setDriveQuery(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        this.f11331c = driveRouteQuery;
    }

    public void setPaths(List<DrivePathV2> list) {
        this.f11330b = list;
    }

    public void setTaxiCost(float f4) {
        this.f11329a = f4;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeFloat(this.f11329a);
        parcel.writeTypedList(this.f11330b);
        parcel.writeParcelable(this.f11331c, i4);
    }

    public DriveRouteResultV2() {
        this.f11330b = new ArrayList();
    }
}
