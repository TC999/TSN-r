package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ap;
import java.util.Map;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i4) {
            return new CrashDetailBean[i4];
        }
    };
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;

    /* renamed from: L  reason: collision with root package name */
    public String f50764L;
    public String M;
    public String N;
    public String O;
    public String P;
    public long Q;
    public boolean R;
    public Map<String, String> S;
    public Map<String, String> T;
    public int U;
    public int V;
    public Map<String, String> W;
    public Map<String, String> X;
    public byte[] Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public long f50765a;
    public String aa;

    /* renamed from: b  reason: collision with root package name */
    public int f50766b;

    /* renamed from: c  reason: collision with root package name */
    public String f50767c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50768d;

    /* renamed from: e  reason: collision with root package name */
    public String f50769e;

    /* renamed from: f  reason: collision with root package name */
    public String f50770f;

    /* renamed from: g  reason: collision with root package name */
    public String f50771g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, PlugInBean> f50772h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, PlugInBean> f50773i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50774j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f50775k;

    /* renamed from: l  reason: collision with root package name */
    public int f50776l;

    /* renamed from: m  reason: collision with root package name */
    public String f50777m;

    /* renamed from: n  reason: collision with root package name */
    public String f50778n;

    /* renamed from: o  reason: collision with root package name */
    public String f50779o;

    /* renamed from: p  reason: collision with root package name */
    public String f50780p;

    /* renamed from: q  reason: collision with root package name */
    public String f50781q;

    /* renamed from: r  reason: collision with root package name */
    public long f50782r;

    /* renamed from: s  reason: collision with root package name */
    public String f50783s;

    /* renamed from: t  reason: collision with root package name */
    public int f50784t;

    /* renamed from: u  reason: collision with root package name */
    public String f50785u;

    /* renamed from: v  reason: collision with root package name */
    public String f50786v;

    /* renamed from: w  reason: collision with root package name */
    public String f50787w;

    /* renamed from: x  reason: collision with root package name */
    public String f50788x;

    /* renamed from: y  reason: collision with root package name */
    public byte[] f50789y;

    /* renamed from: z  reason: collision with root package name */
    public Map<String, String> f50790z;

    public CrashDetailBean() {
        this.f50765a = -1L;
        this.f50766b = 0;
        this.f50767c = UUID.randomUUID().toString();
        this.f50768d = false;
        this.f50769e = "";
        this.f50770f = "";
        this.f50771g = "";
        this.f50772h = null;
        this.f50773i = null;
        this.f50774j = false;
        this.f50775k = false;
        this.f50776l = 0;
        this.f50777m = "";
        this.f50778n = "";
        this.f50779o = "";
        this.f50780p = "";
        this.f50781q = "";
        this.f50782r = -1L;
        this.f50783s = null;
        this.f50784t = 0;
        this.f50785u = "";
        this.f50786v = "";
        this.f50787w = null;
        this.f50788x = null;
        this.f50789y = null;
        this.f50790z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.f50764L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 != null) {
            long j4 = this.f50782r - crashDetailBean2.f50782r;
            if (j4 <= 0) {
                return j4 < 0 ? -1 : 0;
            }
            return 1;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f50766b);
        parcel.writeString(this.f50767c);
        parcel.writeByte(this.f50768d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f50769e);
        parcel.writeString(this.f50770f);
        parcel.writeString(this.f50771g);
        parcel.writeByte(this.f50774j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f50775k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f50776l);
        parcel.writeString(this.f50777m);
        parcel.writeString(this.f50778n);
        parcel.writeString(this.f50779o);
        parcel.writeString(this.f50780p);
        parcel.writeString(this.f50781q);
        parcel.writeLong(this.f50782r);
        parcel.writeString(this.f50783s);
        parcel.writeInt(this.f50784t);
        parcel.writeString(this.f50785u);
        parcel.writeString(this.f50786v);
        parcel.writeString(this.f50787w);
        ap.b(parcel, this.f50790z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.f50764L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeLong(this.Q);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        ap.b(parcel, this.S);
        ap.a(parcel, this.f50772h);
        ap.a(parcel, this.f50773i);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        ap.b(parcel, this.W);
        ap.b(parcel, this.X);
        parcel.writeByteArray(this.Y);
        parcel.writeByteArray(this.f50789y);
        parcel.writeString(this.Z);
        parcel.writeString(this.aa);
        parcel.writeString(this.f50788x);
        parcel.writeLong(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f50765a = -1L;
        this.f50766b = 0;
        this.f50767c = UUID.randomUUID().toString();
        this.f50768d = false;
        this.f50769e = "";
        this.f50770f = "";
        this.f50771g = "";
        this.f50772h = null;
        this.f50773i = null;
        this.f50774j = false;
        this.f50775k = false;
        this.f50776l = 0;
        this.f50777m = "";
        this.f50778n = "";
        this.f50779o = "";
        this.f50780p = "";
        this.f50781q = "";
        this.f50782r = -1L;
        this.f50783s = null;
        this.f50784t = 0;
        this.f50785u = "";
        this.f50786v = "";
        this.f50787w = null;
        this.f50788x = null;
        this.f50789y = null;
        this.f50790z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.f50764L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.f50766b = parcel.readInt();
        this.f50767c = parcel.readString();
        this.f50768d = parcel.readByte() == 1;
        this.f50769e = parcel.readString();
        this.f50770f = parcel.readString();
        this.f50771g = parcel.readString();
        this.f50774j = parcel.readByte() == 1;
        this.f50775k = parcel.readByte() == 1;
        this.f50776l = parcel.readInt();
        this.f50777m = parcel.readString();
        this.f50778n = parcel.readString();
        this.f50779o = parcel.readString();
        this.f50780p = parcel.readString();
        this.f50781q = parcel.readString();
        this.f50782r = parcel.readLong();
        this.f50783s = parcel.readString();
        this.f50784t = parcel.readInt();
        this.f50785u = parcel.readString();
        this.f50786v = parcel.readString();
        this.f50787w = parcel.readString();
        this.f50790z = ap.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.f50764L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readLong();
        this.R = parcel.readByte() == 1;
        this.S = ap.b(parcel);
        this.f50772h = ap.a(parcel);
        this.f50773i = ap.a(parcel);
        this.U = parcel.readInt();
        this.V = parcel.readInt();
        this.W = ap.b(parcel);
        this.X = ap.b(parcel);
        this.Y = parcel.createByteArray();
        this.f50789y = parcel.createByteArray();
        this.Z = parcel.readString();
        this.aa = parcel.readString();
        this.f50788x = parcel.readString();
        this.I = parcel.readLong();
        this.J = parcel.readLong();
        this.K = parcel.readLong();
    }
}
