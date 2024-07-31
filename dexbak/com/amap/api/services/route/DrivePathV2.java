package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrivePathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePathV2> CREATOR = new Parcelable.Creator<DrivePathV2>() { // from class: com.amap.api.services.route.DrivePathV2.1
        /* renamed from: a */
        private static DrivePathV2 m51824a(Parcel parcel) {
            return new DrivePathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePathV2 createFromParcel(Parcel parcel) {
            return m51824a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePathV2[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7615a;

    /* renamed from: b */
    private List<DriveStepV2> f7616b;

    /* renamed from: c */
    private int f7617c;

    /* renamed from: d */
    private Cost f7618d;

    /* renamed from: e */
    private ElecConsumeInfo f7619e;

    /* renamed from: f */
    private List<ChargeStationInfo> f7620f;

    public DrivePathV2(Parcel parcel) {
        super(parcel);
        this.f7616b = new ArrayList();
        this.f7620f = new ArrayList();
        this.f7615a = parcel.readString();
        this.f7616b = parcel.createTypedArrayList(DriveStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ChargeStationInfo> getChargeStationInfo() {
        return this.f7620f;
    }

    public Cost getCost() {
        return this.f7618d;
    }

    public ElecConsumeInfo getElecConsumeInfo() {
        return this.f7619e;
    }

    public int getRestriction() {
        return this.f7617c;
    }

    public List<DriveStepV2> getSteps() {
        return this.f7616b;
    }

    public String getStrategy() {
        return this.f7615a;
    }

    public void setChargeStationInfo(List<ChargeStationInfo> list) {
        this.f7620f = list;
    }

    public void setCost(Cost cost) {
        this.f7618d = cost;
    }

    public void setElecConsumeInfo(ElecConsumeInfo elecConsumeInfo) {
        this.f7619e = elecConsumeInfo;
    }

    public void setRestriction(int i) {
        this.f7617c = i;
    }

    public void setSteps(List<DriveStepV2> list) {
        this.f7616b = list;
    }

    public void setStrategy(String str) {
        this.f7615a = str;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f7616b);
    }

    public DrivePathV2() {
        this.f7616b = new ArrayList();
        this.f7620f = new ArrayList();
    }
}
