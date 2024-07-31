package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.C12828ap;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i) {
            return new CrashDetailBean[i];
        }
    };

    /* renamed from: A */
    public String f36314A;

    /* renamed from: B */
    public String f36315B;

    /* renamed from: C */
    public long f36316C;

    /* renamed from: D */
    public long f36317D;

    /* renamed from: E */
    public long f36318E;

    /* renamed from: F */
    public long f36319F;

    /* renamed from: G */
    public long f36320G;

    /* renamed from: H */
    public long f36321H;

    /* renamed from: I */
    public long f36322I;

    /* renamed from: J */
    public long f36323J;

    /* renamed from: K */
    public long f36324K;

    /* renamed from: L */
    public String f36325L;

    /* renamed from: M */
    public String f36326M;

    /* renamed from: N */
    public String f36327N;

    /* renamed from: O */
    public String f36328O;

    /* renamed from: P */
    public String f36329P;

    /* renamed from: Q */
    public long f36330Q;

    /* renamed from: R */
    public boolean f36331R;

    /* renamed from: S */
    public Map<String, String> f36332S;

    /* renamed from: T */
    public Map<String, String> f36333T;

    /* renamed from: U */
    public int f36334U;

    /* renamed from: V */
    public int f36335V;

    /* renamed from: W */
    public Map<String, String> f36336W;

    /* renamed from: X */
    public Map<String, String> f36337X;

    /* renamed from: Y */
    public byte[] f36338Y;

    /* renamed from: Z */
    public String f36339Z;

    /* renamed from: a */
    public long f36340a;

    /* renamed from: aa */
    public String f36341aa;

    /* renamed from: b */
    public int f36342b;

    /* renamed from: c */
    public String f36343c;

    /* renamed from: d */
    public boolean f36344d;

    /* renamed from: e */
    public String f36345e;

    /* renamed from: f */
    public String f36346f;

    /* renamed from: g */
    public String f36347g;

    /* renamed from: h */
    public Map<String, PlugInBean> f36348h;

    /* renamed from: i */
    public Map<String, PlugInBean> f36349i;

    /* renamed from: j */
    public boolean f36350j;

    /* renamed from: k */
    public boolean f36351k;

    /* renamed from: l */
    public int f36352l;

    /* renamed from: m */
    public String f36353m;

    /* renamed from: n */
    public String f36354n;

    /* renamed from: o */
    public String f36355o;

    /* renamed from: p */
    public String f36356p;

    /* renamed from: q */
    public String f36357q;

    /* renamed from: r */
    public long f36358r;

    /* renamed from: s */
    public String f36359s;

    /* renamed from: t */
    public int f36360t;

    /* renamed from: u */
    public String f36361u;

    /* renamed from: v */
    public String f36362v;

    /* renamed from: w */
    public String f36363w;

    /* renamed from: x */
    public String f36364x;

    /* renamed from: y */
    public byte[] f36365y;

    /* renamed from: z */
    public Map<String, String> f36366z;

    public CrashDetailBean() {
        this.f36340a = -1L;
        this.f36342b = 0;
        this.f36343c = UUID.randomUUID().toString();
        this.f36344d = false;
        this.f36345e = "";
        this.f36346f = "";
        this.f36347g = "";
        this.f36348h = null;
        this.f36349i = null;
        this.f36350j = false;
        this.f36351k = false;
        this.f36352l = 0;
        this.f36353m = "";
        this.f36354n = "";
        this.f36355o = "";
        this.f36356p = "";
        this.f36357q = "";
        this.f36358r = -1L;
        this.f36359s = null;
        this.f36360t = 0;
        this.f36361u = "";
        this.f36362v = "";
        this.f36363w = null;
        this.f36364x = null;
        this.f36365y = null;
        this.f36366z = null;
        this.f36314A = "";
        this.f36315B = "";
        this.f36316C = -1L;
        this.f36317D = -1L;
        this.f36318E = -1L;
        this.f36319F = -1L;
        this.f36320G = -1L;
        this.f36321H = -1L;
        this.f36322I = -1L;
        this.f36323J = -1L;
        this.f36324K = -1L;
        this.f36325L = "";
        this.f36326M = "";
        this.f36327N = "";
        this.f36328O = "";
        this.f36329P = "";
        this.f36330Q = -1L;
        this.f36331R = false;
        this.f36332S = null;
        this.f36333T = null;
        this.f36334U = -1;
        this.f36335V = -1;
        this.f36336W = null;
        this.f36337X = null;
        this.f36338Y = null;
        this.f36339Z = null;
        this.f36341aa = null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 != null) {
            long j = this.f36358r - crashDetailBean2.f36358r;
            if (j <= 0) {
                return j < 0 ? -1 : 0;
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f36342b);
        parcel.writeString(this.f36343c);
        parcel.writeByte(this.f36344d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f36345e);
        parcel.writeString(this.f36346f);
        parcel.writeString(this.f36347g);
        parcel.writeByte(this.f36350j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f36351k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f36352l);
        parcel.writeString(this.f36353m);
        parcel.writeString(this.f36354n);
        parcel.writeString(this.f36355o);
        parcel.writeString(this.f36356p);
        parcel.writeString(this.f36357q);
        parcel.writeLong(this.f36358r);
        parcel.writeString(this.f36359s);
        parcel.writeInt(this.f36360t);
        parcel.writeString(this.f36361u);
        parcel.writeString(this.f36362v);
        parcel.writeString(this.f36363w);
        C12828ap.m15819b(parcel, this.f36366z);
        parcel.writeString(this.f36314A);
        parcel.writeString(this.f36315B);
        parcel.writeLong(this.f36316C);
        parcel.writeLong(this.f36317D);
        parcel.writeLong(this.f36318E);
        parcel.writeLong(this.f36319F);
        parcel.writeLong(this.f36320G);
        parcel.writeLong(this.f36321H);
        parcel.writeString(this.f36325L);
        parcel.writeString(this.f36326M);
        parcel.writeString(this.f36327N);
        parcel.writeString(this.f36328O);
        parcel.writeString(this.f36329P);
        parcel.writeLong(this.f36330Q);
        parcel.writeByte(this.f36331R ? (byte) 1 : (byte) 0);
        C12828ap.m15819b(parcel, this.f36332S);
        C12828ap.m15841a(parcel, this.f36348h);
        C12828ap.m15841a(parcel, this.f36349i);
        parcel.writeInt(this.f36334U);
        parcel.writeInt(this.f36335V);
        C12828ap.m15819b(parcel, this.f36336W);
        C12828ap.m15819b(parcel, this.f36337X);
        parcel.writeByteArray(this.f36338Y);
        parcel.writeByteArray(this.f36365y);
        parcel.writeString(this.f36339Z);
        parcel.writeString(this.f36341aa);
        parcel.writeString(this.f36364x);
        parcel.writeLong(this.f36322I);
        parcel.writeLong(this.f36323J);
        parcel.writeLong(this.f36324K);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f36340a = -1L;
        this.f36342b = 0;
        this.f36343c = UUID.randomUUID().toString();
        this.f36344d = false;
        this.f36345e = "";
        this.f36346f = "";
        this.f36347g = "";
        this.f36348h = null;
        this.f36349i = null;
        this.f36350j = false;
        this.f36351k = false;
        this.f36352l = 0;
        this.f36353m = "";
        this.f36354n = "";
        this.f36355o = "";
        this.f36356p = "";
        this.f36357q = "";
        this.f36358r = -1L;
        this.f36359s = null;
        this.f36360t = 0;
        this.f36361u = "";
        this.f36362v = "";
        this.f36363w = null;
        this.f36364x = null;
        this.f36365y = null;
        this.f36366z = null;
        this.f36314A = "";
        this.f36315B = "";
        this.f36316C = -1L;
        this.f36317D = -1L;
        this.f36318E = -1L;
        this.f36319F = -1L;
        this.f36320G = -1L;
        this.f36321H = -1L;
        this.f36322I = -1L;
        this.f36323J = -1L;
        this.f36324K = -1L;
        this.f36325L = "";
        this.f36326M = "";
        this.f36327N = "";
        this.f36328O = "";
        this.f36329P = "";
        this.f36330Q = -1L;
        this.f36331R = false;
        this.f36332S = null;
        this.f36333T = null;
        this.f36334U = -1;
        this.f36335V = -1;
        this.f36336W = null;
        this.f36337X = null;
        this.f36338Y = null;
        this.f36339Z = null;
        this.f36341aa = null;
        this.f36342b = parcel.readInt();
        this.f36343c = parcel.readString();
        this.f36344d = parcel.readByte() == 1;
        this.f36345e = parcel.readString();
        this.f36346f = parcel.readString();
        this.f36347g = parcel.readString();
        this.f36350j = parcel.readByte() == 1;
        this.f36351k = parcel.readByte() == 1;
        this.f36352l = parcel.readInt();
        this.f36353m = parcel.readString();
        this.f36354n = parcel.readString();
        this.f36355o = parcel.readString();
        this.f36356p = parcel.readString();
        this.f36357q = parcel.readString();
        this.f36358r = parcel.readLong();
        this.f36359s = parcel.readString();
        this.f36360t = parcel.readInt();
        this.f36361u = parcel.readString();
        this.f36362v = parcel.readString();
        this.f36363w = parcel.readString();
        this.f36366z = C12828ap.m15820b(parcel);
        this.f36314A = parcel.readString();
        this.f36315B = parcel.readString();
        this.f36316C = parcel.readLong();
        this.f36317D = parcel.readLong();
        this.f36318E = parcel.readLong();
        this.f36319F = parcel.readLong();
        this.f36320G = parcel.readLong();
        this.f36321H = parcel.readLong();
        this.f36325L = parcel.readString();
        this.f36326M = parcel.readString();
        this.f36327N = parcel.readString();
        this.f36328O = parcel.readString();
        this.f36329P = parcel.readString();
        this.f36330Q = parcel.readLong();
        this.f36331R = parcel.readByte() == 1;
        this.f36332S = C12828ap.m15820b(parcel);
        this.f36348h = C12828ap.m15842a(parcel);
        this.f36349i = C12828ap.m15842a(parcel);
        this.f36334U = parcel.readInt();
        this.f36335V = parcel.readInt();
        this.f36336W = C12828ap.m15820b(parcel);
        this.f36337X = C12828ap.m15820b(parcel);
        this.f36338Y = parcel.createByteArray();
        this.f36365y = parcel.createByteArray();
        this.f36339Z = parcel.readString();
        this.f36341aa = parcel.readString();
        this.f36364x = parcel.readString();
        this.f36322I = parcel.readLong();
        this.f36323J = parcel.readLong();
        this.f36324K = parcel.readLong();
    }
}
