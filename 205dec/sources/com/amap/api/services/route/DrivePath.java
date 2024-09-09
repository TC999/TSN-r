package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DrivePath extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePath> CREATOR = new Parcelable.Creator<DrivePath>() { // from class: com.amap.api.services.route.DrivePath.1
        private static DrivePath a(Parcel parcel) {
            return new DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePath[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11303a;

    /* renamed from: b  reason: collision with root package name */
    private float f11304b;

    /* renamed from: c  reason: collision with root package name */
    private float f11305c;

    /* renamed from: d  reason: collision with root package name */
    private int f11306d;

    /* renamed from: e  reason: collision with root package name */
    private List<DriveStep> f11307e;

    /* renamed from: f  reason: collision with root package name */
    private int f11308f;

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f11307e = new ArrayList();
        this.f11303a = parcel.readString();
        this.f11304b = parcel.readFloat();
        this.f11305c = parcel.readFloat();
        this.f11307e = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.f11306d = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f11308f;
    }

    public List<DriveStep> getSteps() {
        return this.f11307e;
    }

    public String getStrategy() {
        return this.f11303a;
    }

    public float getTollDistance() {
        return this.f11305c;
    }

    public float getTolls() {
        return this.f11304b;
    }

    public int getTotalTrafficlights() {
        return this.f11306d;
    }

    public void setRestriction(int i4) {
        this.f11308f = i4;
    }

    public void setSteps(List<DriveStep> list) {
        this.f11307e = list;
    }

    public void setStrategy(String str) {
        this.f11303a = str;
    }

    public void setTollDistance(float f4) {
        this.f11305c = f4;
    }

    public void setTolls(float f4) {
        this.f11304b = f4;
    }

    public void setTotalTrafficlights(int i4) {
        this.f11306d = i4;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.f11303a);
        parcel.writeFloat(this.f11304b);
        parcel.writeFloat(this.f11305c);
        parcel.writeTypedList(this.f11307e);
        parcel.writeInt(this.f11306d);
    }

    public DrivePath() {
        this.f11307e = new ArrayList();
    }
}
