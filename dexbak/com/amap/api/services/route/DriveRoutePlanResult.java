package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DriveRoutePlanResult extends RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new Parcelable.Creator<DriveRoutePlanResult>() { // from class: com.amap.api.services.route.DriveRoutePlanResult.1
        /* renamed from: a */
        private static DriveRoutePlanResult m51820a(Parcel parcel) {
            return new DriveRoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult createFromParcel(Parcel parcel) {
            return m51820a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult[] newArray(int i) {
            return m51821a(i);
        }

        /* renamed from: a */
        private static DriveRoutePlanResult[] m51821a(int i) {
            return new DriveRoutePlanResult[i];
        }
    };

    /* renamed from: a */
    private List<DrivePlanPath> f7629a;

    /* renamed from: b */
    private List<TimeInfo> f7630b;

    /* renamed from: c */
    private RouteSearch.DrivePlanQuery f7631c;

    public DriveRoutePlanResult(Parcel parcel) {
        super(parcel);
        this.f7629a = new ArrayList();
        this.f7630b = new ArrayList();
        this.f7629a = parcel.createTypedArrayList(DrivePlanPath.CREATOR);
        this.f7630b = parcel.createTypedArrayList(TimeInfo.CREATOR);
        this.f7631c = (RouteSearch.DrivePlanQuery) parcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivePlanPath> getPaths() {
        return this.f7629a;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.f7630b;
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.f7631c = drivePlanQuery;
        RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    public void setPaths(List<DrivePlanPath> list) {
        this.f7629a = list;
    }

    public void setTimeInfos(List<TimeInfo> list) {
        this.f7630b = list;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f7629a);
        parcel.writeTypedList(this.f7630b);
        parcel.writeParcelable(this.f7631c, i);
    }

    public DriveRoutePlanResult() {
        this.f7629a = new ArrayList();
        this.f7630b = new ArrayList();
    }
}
