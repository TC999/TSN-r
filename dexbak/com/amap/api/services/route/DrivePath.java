package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrivePath extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePath> CREATOR = new Parcelable.Creator<DrivePath>() { // from class: com.amap.api.services.route.DrivePath.1
        /* renamed from: a */
        private static DrivePath m51825a(Parcel parcel) {
            return new DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePath createFromParcel(Parcel parcel) {
            return m51825a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePath[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7609a;

    /* renamed from: b */
    private float f7610b;

    /* renamed from: c */
    private float f7611c;

    /* renamed from: d */
    private int f7612d;

    /* renamed from: e */
    private List<DriveStep> f7613e;

    /* renamed from: f */
    private int f7614f;

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f7613e = new ArrayList();
        this.f7609a = parcel.readString();
        this.f7610b = parcel.readFloat();
        this.f7611c = parcel.readFloat();
        this.f7613e = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.f7612d = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f7614f;
    }

    public List<DriveStep> getSteps() {
        return this.f7613e;
    }

    public String getStrategy() {
        return this.f7609a;
    }

    public float getTollDistance() {
        return this.f7611c;
    }

    public float getTolls() {
        return this.f7610b;
    }

    public int getTotalTrafficlights() {
        return this.f7612d;
    }

    public void setRestriction(int i) {
        this.f7614f = i;
    }

    public void setSteps(List<DriveStep> list) {
        this.f7613e = list;
    }

    public void setStrategy(String str) {
        this.f7609a = str;
    }

    public void setTollDistance(float f) {
        this.f7611c = f;
    }

    public void setTolls(float f) {
        this.f7610b = f;
    }

    public void setTotalTrafficlights(int i) {
        this.f7612d = i;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f7609a);
        parcel.writeFloat(this.f7610b);
        parcel.writeFloat(this.f7611c);
        parcel.writeTypedList(this.f7613e);
        parcel.writeInt(this.f7612d);
    }

    public DrivePath() {
        this.f7613e = new ArrayList();
    }
}
