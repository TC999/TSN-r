package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DriveRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResultV2> CREATOR = new Parcelable.Creator<DriveRouteResultV2>() { // from class: com.amap.api.services.route.DriveRouteResultV2.1
        /* renamed from: a */
        private static DriveRouteResultV2 m51816a(Parcel parcel) {
            return new DriveRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2 createFromParcel(Parcel parcel) {
            return m51816a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2[] newArray(int i) {
            return m51817a(i);
        }

        /* renamed from: a */
        private static DriveRouteResultV2[] m51817a(int i) {
            return new DriveRouteResultV2[i];
        }
    };

    /* renamed from: a */
    private float f7635a;

    /* renamed from: b */
    private List<DrivePathV2> f7636b;

    /* renamed from: c */
    private RouteSearchV2.DriveRouteQuery f7637c;

    public DriveRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f7636b = new ArrayList();
        this.f7635a = parcel.readFloat();
        this.f7636b = parcel.createTypedArrayList(DrivePathV2.CREATOR);
        this.f7637c = (RouteSearchV2.DriveRouteQuery) parcel.readParcelable(RouteSearchV2.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.DriveRouteQuery getDriveQuery() {
        return this.f7637c;
    }

    public List<DrivePathV2> getPaths() {
        return this.f7636b;
    }

    public float getTaxiCost() {
        return this.f7635a;
    }

    public void setDriveQuery(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        this.f7637c = driveRouteQuery;
    }

    public void setPaths(List<DrivePathV2> list) {
        this.f7636b = list;
    }

    public void setTaxiCost(float f) {
        this.f7635a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f7635a);
        parcel.writeTypedList(this.f7636b);
        parcel.writeParcelable(this.f7637c, i);
    }

    public DriveRouteResultV2() {
        this.f7636b = new ArrayList();
    }
}
