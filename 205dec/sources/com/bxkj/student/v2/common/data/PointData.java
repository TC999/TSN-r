package com.bxkj.student.v2.common.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    /* renamed from: a  reason: collision with root package name */
    private double f23111a;

    /* renamed from: c  reason: collision with root package name */
    private long f23112c;

    /* renamed from: e  reason: collision with root package name */
    private int f23113e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f23114f;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f23115h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23116i;

    /* renamed from: l  reason: collision with root package name */
    private int f23117l;

    /* renamed from: m  reason: collision with root package name */
    private Boolean f23118m;

    /* renamed from: o  reason: collision with root package name */
    private double f23119o;

    /* renamed from: s  reason: collision with root package name */
    private float f23120s;

    /* renamed from: t  reason: collision with root package name */
    private long f23121t;

    public PointData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getA() {
        return this.f23111a;
    }

    public long getC() {
        return this.f23112c;
    }

    public long getE() {
        return this.f23113e;
    }

    public Boolean getF() {
        return this.f23114f;
    }

    public Boolean getH() {
        return this.f23115h;
    }

    public int getL() {
        return this.f23117l;
    }

    public Boolean getM() {
        return this.f23118m;
    }

    public double getO() {
        return this.f23119o;
    }

    public float getS() {
        return this.f23120s;
    }

    public long getT() {
        return this.f23121t;
    }

    public boolean isI() {
        return this.f23116i;
    }

    public void readFromParcel(Parcel source) {
        this.f23111a = source.readDouble();
        this.f23119o = source.readDouble();
        this.f23121t = source.readLong();
        this.f23120s = source.readFloat();
        this.f23116i = source.readByte() != 0;
        this.f23117l = source.readInt();
        this.f23112c = source.readLong();
        this.f23113e = source.readInt();
        this.f23114f = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.f23118m = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.f23115h = (Boolean) source.readValue(Boolean.class.getClassLoader());
    }

    public PointData setA(double a4) {
        this.f23111a = a4;
        return this;
    }

    public PointData setC(long c4) {
        this.f23112c = c4;
        return this;
    }

    public PointData setE(int e4) {
        this.f23113e = e4;
        return this;
    }

    public PointData setF(Boolean f4) {
        this.f23114f = f4;
        return this;
    }

    public PointData setH(Boolean h4) {
        this.f23115h = h4;
        return this;
    }

    public PointData setI(boolean i4) {
        this.f23116i = i4;
        return this;
    }

    public PointData setL(int l4) {
        this.f23117l = l4;
        return this;
    }

    public PointData setM(Boolean m4) {
        this.f23118m = m4;
        return this;
    }

    public PointData setO(double o4) {
        this.f23119o = o4;
        return this;
    }

    public PointData setS(float s3) {
        this.f23120s = s3;
        return this;
    }

    public PointData setT(long t3) {
        this.f23121t = t3;
        return this;
    }

    public String toString() {
        return "PointData{a=" + this.f23111a + ", o=" + this.f23119o + ", t=" + this.f23121t + ", s=" + this.f23120s + ", i=" + this.f23116i + ", l=" + this.f23117l + ", c=" + this.f23112c + ", e=" + this.f23113e + ", f=" + this.f23114f + ", m=" + this.f23118m + ", h=" + this.f23115h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.f23111a);
        dest.writeDouble(this.f23119o);
        dest.writeLong(this.f23121t);
        dest.writeFloat(this.f23120s);
        dest.writeByte(this.f23116i ? (byte) 1 : (byte) 0);
        dest.writeInt(this.f23117l);
        dest.writeLong(this.f23112c);
        dest.writeInt(this.f23113e);
        dest.writeValue(this.f23114f);
        dest.writeValue(this.f23118m);
        dest.writeValue(this.f23115h);
    }

    public PointData(double a4, double o4, long t3, float s3, boolean i4, int l4, long c4, int e4) {
        this.f23111a = a4;
        this.f23119o = o4;
        this.f23121t = t3;
        this.f23120s = s3;
        this.f23116i = i4;
        this.f23117l = l4;
        this.f23112c = c4;
        this.f23113e = e4;
    }

    protected PointData(Parcel in) {
        this.f23111a = in.readDouble();
        this.f23119o = in.readDouble();
        this.f23121t = in.readLong();
        this.f23120s = in.readFloat();
        this.f23116i = in.readByte() != 0;
        this.f23117l = in.readInt();
        this.f23112c = in.readLong();
        this.f23113e = in.readInt();
        this.f23114f = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.f23118m = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.f23115h = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }
}
