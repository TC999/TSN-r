package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DrivePathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePathV2> CREATOR = new Parcelable.Creator<DrivePathV2>() { // from class: com.amap.api.services.route.DrivePathV2.1
        private static DrivePathV2 a(Parcel parcel) {
            return new DrivePathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePathV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePathV2[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11309a;

    /* renamed from: b  reason: collision with root package name */
    private List<DriveStepV2> f11310b;

    /* renamed from: c  reason: collision with root package name */
    private int f11311c;

    /* renamed from: d  reason: collision with root package name */
    private Cost f11312d;

    /* renamed from: e  reason: collision with root package name */
    private ElecConsumeInfo f11313e;

    /* renamed from: f  reason: collision with root package name */
    private List<ChargeStationInfo> f11314f;

    public DrivePathV2(Parcel parcel) {
        super(parcel);
        this.f11310b = new ArrayList();
        this.f11314f = new ArrayList();
        this.f11309a = parcel.readString();
        this.f11310b = parcel.createTypedArrayList(DriveStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ChargeStationInfo> getChargeStationInfo() {
        return this.f11314f;
    }

    public Cost getCost() {
        return this.f11312d;
    }

    public ElecConsumeInfo getElecConsumeInfo() {
        return this.f11313e;
    }

    public int getRestriction() {
        return this.f11311c;
    }

    public List<DriveStepV2> getSteps() {
        return this.f11310b;
    }

    public String getStrategy() {
        return this.f11309a;
    }

    public void setChargeStationInfo(List<ChargeStationInfo> list) {
        this.f11314f = list;
    }

    public void setCost(Cost cost) {
        this.f11312d = cost;
    }

    public void setElecConsumeInfo(ElecConsumeInfo elecConsumeInfo) {
        this.f11313e = elecConsumeInfo;
    }

    public void setRestriction(int i4) {
        this.f11311c = i4;
    }

    public void setSteps(List<DriveStepV2> list) {
        this.f11310b = list;
    }

    public void setStrategy(String str) {
        this.f11309a = str;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f11310b);
    }

    public DrivePathV2() {
        this.f11310b = new ArrayList();
        this.f11314f = new ArrayList();
    }
}
