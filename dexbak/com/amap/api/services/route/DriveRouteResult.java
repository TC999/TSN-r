package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new Parcelable.Creator<DriveRouteResult>() { // from class: com.amap.api.services.route.DriveRouteResult.1
        /* renamed from: a */
        private static DriveRouteResult m51818a(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult createFromParcel(Parcel parcel) {
            return m51818a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult[] newArray(int i) {
            return m51819a(i);
        }

        /* renamed from: a */
        private static DriveRouteResult[] m51819a(int i) {
            return new DriveRouteResult[i];
        }
    };

    /* renamed from: a */
    private float f7632a;

    /* renamed from: b */
    private List<DrivePath> f7633b;

    /* renamed from: c */
    private RouteSearch.DriveRouteQuery f7634c;

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f7633b = new ArrayList();
        this.f7632a = parcel.readFloat();
        this.f7633b = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f7634c = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.f7634c;
    }

    public List<DrivePath> getPaths() {
        return this.f7633b;
    }

    public float getTaxiCost() {
        return this.f7632a;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.f7634c = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.f7633b = list;
    }

    public void setTaxiCost(float f) {
        this.f7632a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f7632a);
        parcel.writeTypedList(this.f7633b);
        parcel.writeParcelable(this.f7634c, i);
    }

    public DriveRouteResult() {
        this.f7633b = new ArrayList();
    }
}
