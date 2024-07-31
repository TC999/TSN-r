package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TruckPath implements Parcelable {
    public static final Parcelable.Creator<TruckPath> CREATOR = new Parcelable.Creator<TruckPath>() { // from class: com.amap.api.services.route.TruckPath.1
        /* renamed from: a */
        private static TruckPath m51757a(Parcel parcel) {
            return new TruckPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath createFromParcel(Parcel parcel) {
            return m51757a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath[] newArray(int i) {
            return m51758a(i);
        }

        /* renamed from: a */
        private static TruckPath[] m51758a(int i) {
            return new TruckPath[i];
        }
    };

    /* renamed from: a */
    private float f7863a;

    /* renamed from: b */
    private long f7864b;

    /* renamed from: c */
    private String f7865c;

    /* renamed from: d */
    private float f7866d;

    /* renamed from: e */
    private float f7867e;

    /* renamed from: f */
    private int f7868f;

    /* renamed from: g */
    private int f7869g;

    /* renamed from: h */
    private List<TruckStep> f7870h;

    public TruckPath() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f7863a;
    }

    public long getDuration() {
        return this.f7864b;
    }

    public int getRestriction() {
        return this.f7869g;
    }

    public List<TruckStep> getSteps() {
        return this.f7870h;
    }

    public String getStrategy() {
        return this.f7865c;
    }

    public float getTollDistance() {
        return this.f7867e;
    }

    public float getTolls() {
        return this.f7866d;
    }

    public int getTotalTrafficlights() {
        return this.f7868f;
    }

    public void setDistance(float f) {
        this.f7863a = f;
    }

    public void setDuration(long j) {
        this.f7864b = j;
    }

    public void setRestriction(int i) {
        this.f7869g = i;
    }

    public void setSteps(List<TruckStep> list) {
        this.f7870h = list;
    }

    public void setStrategy(String str) {
        this.f7865c = str;
    }

    public void setTollDistance(float f) {
        this.f7867e = f;
    }

    public void setTolls(float f) {
        this.f7866d = f;
    }

    public void setTotalTrafficlights(int i) {
        this.f7868f = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f7863a);
        parcel.writeLong(this.f7864b);
        parcel.writeString(this.f7865c);
        parcel.writeFloat(this.f7866d);
        parcel.writeFloat(this.f7867e);
        parcel.writeInt(this.f7868f);
        parcel.writeInt(this.f7869g);
        parcel.writeTypedList(this.f7870h);
    }

    protected TruckPath(Parcel parcel) {
        this.f7863a = parcel.readFloat();
        this.f7864b = parcel.readLong();
        this.f7865c = parcel.readString();
        this.f7866d = parcel.readFloat();
        this.f7867e = parcel.readFloat();
        this.f7868f = parcel.readInt();
        this.f7869g = parcel.readInt();
        this.f7870h = parcel.createTypedArrayList(TruckStep.CREATOR);
    }
}
