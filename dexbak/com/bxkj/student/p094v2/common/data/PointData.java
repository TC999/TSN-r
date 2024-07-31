package com.bxkj.student.p094v2.common.data;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.bxkj.student.v2.common.data.PointData */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PointData implements Parcelable {
    public static final Parcelable.Creator<PointData> CREATOR = new Parcelable.Creator<PointData>() { // from class: com.bxkj.student.v2.common.data.PointData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointData createFromParcel(Parcel source) {
            return new PointData(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointData[] newArray(int size) {
            return new PointData[size];
        }
    };

    /* renamed from: a */
    private double f19881a;

    /* renamed from: c */
    private long f19882c;

    /* renamed from: e */
    private int f19883e;

    /* renamed from: f */
    private Boolean f19884f;

    /* renamed from: h */
    private Boolean f19885h;

    /* renamed from: i */
    private boolean f19886i;

    /* renamed from: l */
    private int f19887l;

    /* renamed from: m */
    private Boolean f19888m;

    /* renamed from: o */
    private double f19889o;

    /* renamed from: s */
    private float f19890s;

    /* renamed from: t */
    private long f19891t;

    public PointData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getA() {
        return this.f19881a;
    }

    public long getC() {
        return this.f19882c;
    }

    public long getE() {
        return this.f19883e;
    }

    public Boolean getF() {
        return this.f19884f;
    }

    public Boolean getH() {
        return this.f19885h;
    }

    public int getL() {
        return this.f19887l;
    }

    public Boolean getM() {
        return this.f19888m;
    }

    public double getO() {
        return this.f19889o;
    }

    public float getS() {
        return this.f19890s;
    }

    public long getT() {
        return this.f19891t;
    }

    public boolean isI() {
        return this.f19886i;
    }

    public void readFromParcel(Parcel source) {
        this.f19881a = source.readDouble();
        this.f19889o = source.readDouble();
        this.f19891t = source.readLong();
        this.f19890s = source.readFloat();
        this.f19886i = source.readByte() != 0;
        this.f19887l = source.readInt();
        this.f19882c = source.readLong();
        this.f19883e = source.readInt();
        this.f19884f = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.f19888m = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.f19885h = (Boolean) source.readValue(Boolean.class.getClassLoader());
    }

    public PointData setA(double a) {
        this.f19881a = a;
        return this;
    }

    public PointData setC(long c) {
        this.f19882c = c;
        return this;
    }

    public PointData setE(int e) {
        this.f19883e = e;
        return this;
    }

    public PointData setF(Boolean f) {
        this.f19884f = f;
        return this;
    }

    public PointData setH(Boolean h) {
        this.f19885h = h;
        return this;
    }

    public PointData setI(boolean i) {
        this.f19886i = i;
        return this;
    }

    public PointData setL(int l) {
        this.f19887l = l;
        return this;
    }

    public PointData setM(Boolean m) {
        this.f19888m = m;
        return this;
    }

    public PointData setO(double o) {
        this.f19889o = o;
        return this;
    }

    public PointData setS(float s) {
        this.f19890s = s;
        return this;
    }

    public PointData setT(long t) {
        this.f19891t = t;
        return this;
    }

    public String toString() {
        return "PointData{a=" + this.f19881a + ", o=" + this.f19889o + ", t=" + this.f19891t + ", s=" + this.f19890s + ", i=" + this.f19886i + ", l=" + this.f19887l + ", c=" + this.f19882c + ", e=" + this.f19883e + ", f=" + this.f19884f + ", m=" + this.f19888m + ", h=" + this.f19885h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.f19881a);
        dest.writeDouble(this.f19889o);
        dest.writeLong(this.f19891t);
        dest.writeFloat(this.f19890s);
        dest.writeByte(this.f19886i ? (byte) 1 : (byte) 0);
        dest.writeInt(this.f19887l);
        dest.writeLong(this.f19882c);
        dest.writeInt(this.f19883e);
        dest.writeValue(this.f19884f);
        dest.writeValue(this.f19888m);
        dest.writeValue(this.f19885h);
    }

    public PointData(double a, double o, long t, float s, boolean i, int l, long c, int e) {
        this.f19881a = a;
        this.f19889o = o;
        this.f19891t = t;
        this.f19890s = s;
        this.f19886i = i;
        this.f19887l = l;
        this.f19882c = c;
        this.f19883e = e;
    }

    protected PointData(Parcel in) {
        this.f19881a = in.readDouble();
        this.f19889o = in.readDouble();
        this.f19891t = in.readLong();
        this.f19890s = in.readFloat();
        this.f19886i = in.readByte() != 0;
        this.f19887l = in.readInt();
        this.f19882c = in.readLong();
        this.f19883e = in.readInt();
        this.f19884f = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.f19888m = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.f19885h = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }
}
