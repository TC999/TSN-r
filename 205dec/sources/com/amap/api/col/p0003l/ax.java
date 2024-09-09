package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.p0003l.by;
import com.amap.api.col.p0003l.t0;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CityObject.java */
/* renamed from: com.amap.api.col.3l.ax  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ax extends OfflineMapCity implements k0, b1 {
    public static final Parcelable.Creator<ax> CREATOR = new b();

    /* renamed from: f  reason: collision with root package name */
    public final f1 f7134f;

    /* renamed from: g  reason: collision with root package name */
    public final f1 f7135g;

    /* renamed from: h  reason: collision with root package name */
    public final f1 f7136h;

    /* renamed from: i  reason: collision with root package name */
    public final f1 f7137i;

    /* renamed from: j  reason: collision with root package name */
    public final f1 f7138j;

    /* renamed from: k  reason: collision with root package name */
    public final f1 f7139k;

    /* renamed from: l  reason: collision with root package name */
    public final f1 f7140l;

    /* renamed from: m  reason: collision with root package name */
    public final f1 f7141m;

    /* renamed from: n  reason: collision with root package name */
    public final f1 f7142n;

    /* renamed from: o  reason: collision with root package name */
    public final f1 f7143o;

    /* renamed from: p  reason: collision with root package name */
    public final f1 f7144p;

    /* renamed from: q  reason: collision with root package name */
    f1 f7145q;

    /* renamed from: r  reason: collision with root package name */
    Context f7146r;

    /* renamed from: s  reason: collision with root package name */
    private String f7147s;

    /* renamed from: t  reason: collision with root package name */
    private String f7148t;

    /* renamed from: u  reason: collision with root package name */
    boolean f7149u;

    /* renamed from: v  reason: collision with root package name */
    private long f7150v;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CityObject.java */
    /* renamed from: com.amap.api.col.3l.ax$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class b implements Parcelable.Creator<ax> {
        b() {
        }

        private static ax a(Parcel parcel) {
            return new ax(parcel);
        }

        private static ax[] b(int i4) {
            return new ax[i4];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ax createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ax[] newArray(int i4) {
            return b(i4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CityObject.java */
    /* renamed from: com.amap.api.col.3l.ax$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7154a;

        static {
            int[] iArr = new int[by.a.values().length];
            f7154a = iArr;
            try {
                iArr[by.a.amap_exception.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7154a[by.a.file_io_exception.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7154a[by.a.network_exception.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ax(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        I();
    }

    private void K() {
        b0 b4 = b0.b(this.f7146r);
        if (b4 != null) {
            b4.e(this);
        }
    }

    private String g() {
        if (TextUtils.isEmpty(this.f7147s)) {
            return null;
        }
        String str = this.f7147s;
        return str.substring(0, str.lastIndexOf("."));
    }

    private String h() {
        if (TextUtils.isEmpty(this.f7147s)) {
            return null;
        }
        String g4 = g();
        return g4.substring(0, g4.lastIndexOf(46));
    }

    private boolean i() {
        z0.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    private void o(File file, File file2, String str) {
        new t0().b(file, file2, -1L, z0.b(file), new a(str, file));
    }

    public final void A() {
        b0 b4 = b0.b(this.f7146r);
        if (b4 != null) {
            b4.x(this);
            z();
        }
    }

    public final void B() {
        s().d();
        if (this.f7145q.equals(this.f7137i)) {
            this.f7145q.g();
        } else if (this.f7145q.equals(this.f7136h)) {
            this.f7145q.i();
        } else if (!this.f7145q.equals(this.f7140l) && !this.f7145q.equals(this.f7141m)) {
            if (!this.f7145q.equals(this.f7143o) && !this.f7145q.equals(this.f7142n) && !this.f7145q.c(this.f7144p)) {
                s().h();
            } else {
                this.f7145q.f();
            }
        } else {
            K();
            this.f7149u = true;
        }
    }

    public final void C() {
        this.f7145q.i();
    }

    public final void D() {
        this.f7145q.b(this.f7144p.d());
    }

    public final void E() {
        this.f7145q.a();
        if (this.f7149u) {
            this.f7145q.h();
        }
        this.f7149u = false;
    }

    public final void F() {
        this.f7145q.equals(this.f7139k);
        this.f7145q.j();
    }

    public final void G() {
        b0 b4 = b0.b(this.f7146r);
        if (b4 != null) {
            b4.k(this);
        }
    }

    public final void H() {
        b0 b4 = b0.b(this.f7146r);
        if (b4 != null) {
            b4.u(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I() {
        String str = b0.f7174o;
        String i4 = z0.i(getUrl());
        if (i4 != null) {
            this.f7147s = str + i4 + ".zip.tmp";
            return;
        }
        this.f7147s = str + getPinyin() + ".zip.tmp";
    }

    public final m0 J() {
        setState(this.f7145q.d());
        m0 m0Var = new m0(this, this.f7146r);
        m0Var.m(l());
        l();
        return m0Var;
    }

    @Override // com.amap.api.col.p0003l.by
    public final void a(long j4, long j5) {
        int i4 = (int) ((j5 * 100) / j4);
        if (i4 != getcompleteCode()) {
            setCompleteCode(i4);
            z();
        }
    }

    @Override // com.amap.api.col.p0003l.k0
    public final String b() {
        return getUrl();
    }

    @Override // com.amap.api.col.p0003l.by
    public final void d() {
        A();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.amap.api.col.p0003l.by
    public final void e(by.a aVar) {
        int d4;
        int i4 = c.f7154a[aVar.ordinal()];
        if (i4 == 1) {
            d4 = this.f7143o.d();
        } else if (i4 != 2) {
            d4 = i4 != 3 ? 6 : this.f7142n.d();
        } else {
            d4 = this.f7144p.d();
        }
        if (this.f7145q.equals(this.f7136h) || this.f7145q.equals(this.f7135g)) {
            this.f7145q.b(d4);
        }
    }

    public final String l() {
        return this.f7148t;
    }

    public final void m(int i4) {
        if (i4 == -1) {
            this.f7145q = this.f7141m;
        } else if (i4 == 0) {
            this.f7145q = this.f7136h;
        } else if (i4 == 1) {
            this.f7145q = this.f7138j;
        } else if (i4 == 2) {
            this.f7145q = this.f7135g;
        } else if (i4 == 3) {
            this.f7145q = this.f7137i;
        } else if (i4 == 4) {
            this.f7145q = this.f7139k;
        } else if (i4 == 6) {
            this.f7145q = this.f7134f;
        } else if (i4 != 7) {
            switch (i4) {
                case 101:
                    this.f7145q = this.f7142n;
                    break;
                case 102:
                    this.f7145q = this.f7143o;
                    break;
                case 103:
                    this.f7145q = this.f7144p;
                    break;
                default:
                    if (i4 < 0) {
                        this.f7145q = this.f7141m;
                        break;
                    }
                    break;
            }
        } else {
            this.f7145q = this.f7140l;
        }
        setState(i4);
    }

    public final void n(f1 f1Var) {
        this.f7145q = f1Var;
        setState(f1Var.d());
    }

    public final void p(String str) {
        this.f7148t = str;
    }

    @Override // com.amap.api.col.p0003l.u0
    public final void q() {
        this.f7145q.equals(this.f7138j);
        this.f7145q.b(this.f7141m.d());
    }

    @Override // com.amap.api.col.p0003l.u0
    public final void r() {
        A();
    }

    public final f1 s() {
        return this.f7145q;
    }

    @Override // com.amap.api.col.p0003l.b1
    public final boolean u() {
        return i();
    }

    @Override // com.amap.api.col.p0003l.b1
    public final String v() {
        StringBuffer stringBuffer = new StringBuffer();
        String i4 = z0.i(getUrl());
        if (i4 != null) {
            stringBuffer.append(i4);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003l.b1
    public final String w() {
        return getAdcode();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.f7148t);
    }

    @Override // com.amap.api.col.p0003l.v0
    public final String x() {
        return g();
    }

    @Override // com.amap.api.col.p0003l.v0
    public final String y() {
        return h();
    }

    public final void z() {
        b0 b4 = b0.b(this.f7146r);
        if (b4 != null) {
            b4.q(this);
        }
    }

    @Override // com.amap.api.col.p0003l.u0
    public final void b(String str) {
        this.f7145q.equals(this.f7138j);
        this.f7148t = str;
        String g4 = g();
        String h4 = h();
        if (!TextUtils.isEmpty(g4) && !TextUtils.isEmpty(h4)) {
            File file = new File(h4 + TTPathConst.sSeparator);
            File file2 = new File(a3.v(this.f7146r) + File.separator + "map/");
            File file3 = new File(a3.v(this.f7146r));
            if (file3.exists() || file3.mkdir()) {
                if (file2.exists() || file2.mkdir()) {
                    o(file, file2, g4);
                    return;
                }
                return;
            }
            return;
        }
        q();
    }

    @Override // com.amap.api.col.p0003l.u0
    public final void p() {
        this.f7150v = 0L;
        setCompleteCode(0);
        this.f7145q.equals(this.f7138j);
        this.f7145q.f();
    }

    @Override // com.amap.api.col.p0003l.by
    public final void n() {
        this.f7145q.equals(this.f7136h);
        this.f7145q.k();
    }

    public final f1 q(int i4) {
        switch (i4) {
            case 101:
                return this.f7142n;
            case 102:
                return this.f7143o;
            case 103:
                return this.f7144p;
            default:
                return this.f7141m;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CityObject.java */
    /* renamed from: com.amap.api.col.3l.ax$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements t0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7151a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f7152b;

        a(String str, File file) {
            this.f7151a = str;
            this.f7152b = file;
        }

        @Override // com.amap.api.col.p0003l.t0.a
        public final void a(float f4) {
            int i4 = ax.this.getcompleteCode();
            double d4 = f4;
            Double.isNaN(d4);
            int i5 = (int) ((d4 * 0.39d) + 60.0d);
            if (i5 - i4 <= 0 || System.currentTimeMillis() - ax.this.f7150v <= 1000) {
                return;
            }
            ax.this.setCompleteCode(i5);
            ax.this.f7150v = System.currentTimeMillis();
        }

        @Override // com.amap.api.col.p0003l.t0.a
        public final void b() {
            ax axVar = ax.this;
            axVar.f7145q.b(axVar.f7144p.d());
        }

        @Override // com.amap.api.col.p0003l.t0.a
        public final void a() {
            try {
                if (new File(this.f7151a).delete()) {
                    z0.l(this.f7152b);
                    ax.this.setCompleteCode(100);
                    ax.this.f7145q.k();
                }
            } catch (Exception unused) {
                ax axVar = ax.this;
                axVar.f7145q.b(axVar.f7144p.d());
            }
        }
    }

    @Override // com.amap.api.col.p0003l.u0
    public final void a(long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f7150v > 500) {
            int i4 = (int) j4;
            if (i4 > getcompleteCode()) {
                setCompleteCode(i4);
                z();
            }
            this.f7150v = currentTimeMillis;
        }
    }

    private ax(Context context, int i4) {
        this.f7134f = new h1(this);
        this.f7135g = new o1(this);
        this.f7136h = new k1(this);
        this.f7137i = new m1(this);
        this.f7138j = new n1(this);
        this.f7139k = new g1(this);
        this.f7140l = new l1(this);
        this.f7141m = new i1(-1, this);
        this.f7142n = new i1(101, this);
        this.f7143o = new i1(102, this);
        this.f7144p = new i1(103, this);
        this.f7147s = null;
        this.f7148t = "";
        this.f7149u = false;
        this.f7150v = 0L;
        this.f7146r = context;
        m(i4);
    }

    @Override // com.amap.api.col.p0003l.by
    public final void m() {
        this.f7150v = 0L;
        this.f7145q.equals(this.f7135g);
        this.f7145q.f();
    }

    public ax(Parcel parcel) {
        super(parcel);
        this.f7134f = new h1(this);
        this.f7135g = new o1(this);
        this.f7136h = new k1(this);
        this.f7137i = new m1(this);
        this.f7138j = new n1(this);
        this.f7139k = new g1(this);
        this.f7140l = new l1(this);
        this.f7141m = new i1(-1, this);
        this.f7142n = new i1(101, this);
        this.f7143o = new i1(102, this);
        this.f7144p = new i1(103, this);
        this.f7147s = null;
        this.f7148t = "";
        this.f7149u = false;
        this.f7150v = 0L;
        this.f7148t = parcel.readString();
    }
}
