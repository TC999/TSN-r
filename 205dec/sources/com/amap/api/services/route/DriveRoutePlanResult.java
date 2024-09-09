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
public class DriveRoutePlanResult extends RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new Parcelable.Creator<DriveRoutePlanResult>() { // from class: com.amap.api.services.route.DriveRoutePlanResult.1
        private static DriveRoutePlanResult a(Parcel parcel) {
            return new DriveRoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult[] newArray(int i4) {
            return a(i4);
        }

        private static DriveRoutePlanResult[] a(int i4) {
            return new DriveRoutePlanResult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<DrivePlanPath> f11323a;

    /* renamed from: b  reason: collision with root package name */
    private List<TimeInfo> f11324b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearch.DrivePlanQuery f11325c;

    public DriveRoutePlanResult(Parcel parcel) {
        super(parcel);
        this.f11323a = new ArrayList();
        this.f11324b = new ArrayList();
        this.f11323a = parcel.createTypedArrayList(DrivePlanPath.CREATOR);
        this.f11324b = parcel.createTypedArrayList(TimeInfo.CREATOR);
        this.f11325c = (RouteSearch.DrivePlanQuery) parcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivePlanPath> getPaths() {
        return this.f11323a;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.f11324b;
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.f11325c = drivePlanQuery;
        RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    public void setPaths(List<DrivePlanPath> list) {
        this.f11323a = list;
    }

    public void setTimeInfos(List<TimeInfo> list) {
        this.f11324b = list;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f11323a);
        parcel.writeTypedList(this.f11324b);
        parcel.writeParcelable(this.f11325c, i4);
    }

    public DriveRoutePlanResult() {
        this.f11323a = new ArrayList();
        this.f11324b = new ArrayList();
    }
}
