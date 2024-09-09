package com.qq.e.comm.plugin.util.v2;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements c {

    /* renamed from: y  reason: collision with root package name */
    private static final AtomicInteger f46654y = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f46655a;

    /* renamed from: b  reason: collision with root package name */
    private final String f46656b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f46657c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.d f46658d;

    /* renamed from: e  reason: collision with root package name */
    private final int f46659e;

    /* renamed from: f  reason: collision with root package name */
    private int f46660f;

    /* renamed from: g  reason: collision with root package name */
    private int f46661g;

    /* renamed from: h  reason: collision with root package name */
    private int f46662h;

    /* renamed from: i  reason: collision with root package name */
    private int f46663i;

    /* renamed from: j  reason: collision with root package name */
    private int f46664j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f46665k;

    /* renamed from: l  reason: collision with root package name */
    private e f46666l;

    /* renamed from: m  reason: collision with root package name */
    private volatile int f46667m;

    /* renamed from: o  reason: collision with root package name */
    private int f46669o;

    /* renamed from: p  reason: collision with root package name */
    private int f46670p;

    /* renamed from: q  reason: collision with root package name */
    private int f46671q;

    /* renamed from: u  reason: collision with root package name */
    private double f46675u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f46676v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f46677w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f46678x;

    /* renamed from: n  reason: collision with root package name */
    private String f46668n = "";

    /* renamed from: r  reason: collision with root package name */
    private int f46672r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f46673s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f46674t = Integer.MIN_VALUE;

    public b(com.qq.e.comm.plugin.g0.e eVar, e eVar2) {
        this.f46655a = eVar;
        this.f46666l = eVar2;
        this.f46659e = eVar.M0() * 1000;
        this.f46656b = this.f46655a.L0();
        this.f46657c = com.qq.e.comm.plugin.n0.c.a(this.f46655a);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        this.f46658d = dVar;
        dVar.a("du", Integer.valueOf(this.f46655a.M0()));
        k();
    }

    private int i() {
        return this.f46665k ? 1 : 2;
    }

    private void j() {
        if (this.f46667m <= 0) {
            this.f46667m = Math.min(this.f46661g, this.f46659e);
        }
    }

    private void k() {
        int i4;
        this.f46661g = a("sptime", 20000);
        this.f46662h = a("lbtime", 10000);
        this.f46663i = a("btime", 10000);
        this.f46664j = a("dnbtime", 2000);
        int a4 = a("minvdu", 20000);
        int a5 = a("delimit", 5);
        boolean m4 = m();
        boolean l4 = l();
        boolean z3 = a5 <= f46654y.get();
        this.f46678x = z3;
        this.f46665k = m4 && (i4 = this.f46659e) > a4 && !z3 && i4 > 0 && l4 && a.b(this.f46655a);
        File c4 = b1.c(this.f46656b);
        this.f46676v = c4 != null && c4.exists();
        d1.a("CDNVideoDownloadTrigger", "mSafePlayTime = %d, mVideoDuration = %d, mTriggerBufferTime = %d, minEffectVideoDuration = %d, isTriggerOn = %b,isDeviceEnable = %b, errorTimes = %d, mIsEnable = %b, mIsVideoLoaded = %b", Integer.valueOf(this.f46661g), Integer.valueOf(this.f46659e), Integer.valueOf(this.f46662h), Integer.valueOf(a4), Boolean.valueOf(m4), Boolean.valueOf(l4), Integer.valueOf(f46654y.get()), Boolean.valueOf(this.f46665k), Boolean.valueOf(this.f46676v));
    }

    private boolean l() {
        String str = com.qq.e.comm.plugin.d0.a.d().c().f42280j;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("vdisde", "");
        if (TextUtils.isEmpty(c4)) {
            return true;
        }
        return !c4.contains(str.toLowerCase());
    }

    private boolean m() {
        int a4 = a("vbufferAdType", 0);
        this.f46669o = a4;
        if (a4 > 10000) {
            int a5 = com.qq.e.comm.plugin.t.a.b().a(this.f46655a.p0(), String.valueOf(this.f46669o), 0);
            this.f46669o = a5;
            if (a5 == 2) {
                this.f46668n = "_" + this.f46655a.o().f42000e + "_vbase_";
                return false;
            } else if (a5 == 3) {
                this.f46668n = "_" + this.f46655a.o().f42000e + "_vAA_";
                return false;
            } else if (a5 != 4) {
                d1.b("CDNVideoDownloadTrigger", "error adtype value:" + this.f46669o);
                return false;
            } else {
                this.f46668n = "_" + this.f46655a.o().f42000e + "_vAB_";
                return true;
            }
        }
        boolean z3 = a4 == 1;
        this.f46668n = "_" + this.f46655a.o().f42000e + "_v";
        return z3;
    }

    private boolean n() {
        int i4 = this.f46669o;
        return i4 > 1 && i4 <= 4;
    }

    private void o() {
        if (this.f46670p > 0 || this.f46671q > 0) {
            h b4 = new h(2020007).b(this.f46670p).b(this.f46659e);
            b4.a(this.f46657c);
            v.a(b4);
            v.a(1406007, this.f46657c, Integer.valueOf(this.f46670p / 1000), Integer.valueOf(this.f46671q / 1000), this.f46658d);
        }
    }

    private void p() {
        if (this.f46673s > 0 || this.f46672r > 0) {
            v.a(1406009, this.f46657c, Integer.valueOf(this.f46673s), Integer.valueOf(this.f46672r), this.f46658d);
        }
    }

    private void q() {
        if (this.f46667m > 0) {
            h b4 = new h(2020008).b((this.f46667m * 100) / this.f46659e).b(this.f46659e);
            b4.a(this.f46657c);
            v.a(b4);
        }
    }

    private void r() {
        if (n()) {
            v.a(1406011, this.f46657c, Integer.valueOf(this.f46676v ? 1 : 0), null, this.f46658d);
        }
    }

    private void s() {
        if (this.f46660f > 0) {
            h b4 = new h(2020006).b((this.f46660f * 100) / this.f46659e).b(this.f46659e);
            b4.a(this.f46657c);
            v.a(b4);
        }
    }

    private void t() {
        if (this.f46667m > 0 || this.f46660f > 0) {
            v.a(1406008, this.f46657c, Integer.valueOf((int) (this.f46675u * 100.0d)), Integer.valueOf((this.f46660f * 100) / this.f46659e), this.f46658d);
        }
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void a(int i4, int i5, int i6) {
        if (this.f46666l == null || !this.f46665k) {
            return;
        }
        j();
        a(i6);
        this.f46660f = i4;
        int i7 = this.f46667m - this.f46662h;
        d1.a("CDNVideoDownloadTrigger", "onPositionUpdate: currentPosition = %d, mCurrentDownloadTime = %d, mTriggerBufferTime = %d, leftTime = %d, mVideoDuration = %d, mCurrentDownloadRatio = %.4f", Integer.valueOf(i4), Integer.valueOf(this.f46667m), Integer.valueOf(this.f46662h), Integer.valueOf(i7), Integer.valueOf(this.f46659e), Double.valueOf(this.f46675u));
        if (i7 > i4 || this.f46675u >= 1.0d) {
            return;
        }
        double min = Math.min(Math.max(this.f46667m, i4) + this.f46663i, this.f46659e);
        double d4 = this.f46659e;
        Double.isNaN(min);
        Double.isNaN(d4);
        a(min / d4);
        d1.a("CDNVideoDownloadTrigger", "onPositionUpdate callback : nextDownloadBufferTime = %.4f, mCurrentDownloadTime = %d, mNextBufferTime = %d, mVideoDuration = %d", Double.valueOf(min), Integer.valueOf(this.f46667m), Integer.valueOf(this.f46663i), Integer.valueOf(this.f46659e));
        this.f46667m = (int) min;
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public double b() {
        if (this.f46665k) {
            double d4 = this.f46661g;
            double d5 = this.f46659e;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = d4 / d5;
            d1.a("CDNVideoDownloadTrigger", "getFirstDownloadRatio: ratio = %.4f, safePlayTimeDouble = %.4f, mVideoDuration = %d", Double.valueOf(d6), Double.valueOf(d4), Integer.valueOf(this.f46659e));
            this.f46675u = Math.min(d6, 1.0d);
        } else {
            this.f46675u = 1.0d;
        }
        return this.f46675u;
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void c() {
        if (n()) {
            v.a(1406013, this.f46657c, Integer.valueOf(this.f46669o), Integer.valueOf(i()), this.f46658d);
        }
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public String d() {
        String str = this.f46668n + this.f46665k;
        String b4 = a.b("vcrn");
        if (TextUtils.isEmpty(b4)) {
            return str;
        }
        return str + "_" + b4;
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public boolean e() {
        return this.f46665k;
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void f() {
        if (n()) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d(this.f46658d.a());
            dVar.a("msg", this.f46659e + "-" + this.f46661g + "-" + this.f46662h + "-" + this.f46663i + "-" + this.f46664j + "-" + this.f46667m + "-" + this.f46660f + "-" + this.f46674t + "-" + this.f46670p + "-" + this.f46671q + "-" + this.f46673s + "-" + this.f46672r + "-" + this.f46665k);
            v.a(1406005, this.f46657c, Integer.valueOf(this.f46669o), Integer.valueOf(i()), dVar);
            if (this.f46665k) {
                v.a(1406014, this.f46657c, Integer.valueOf(this.f46660f / 1000), Integer.valueOf(this.f46659e / 1000), dVar);
            }
        }
        if (!this.f46665k || this.f46677w) {
            return;
        }
        this.f46677w = true;
        f46654y.incrementAndGet();
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void g() {
        if (n()) {
            v.a(1406006, this.f46657c, Integer.valueOf(this.f46669o), Integer.valueOf(i()), this.f46658d);
            if (this.f46678x) {
                v.a(1406012, this.f46657c, Integer.valueOf(this.f46669o), Integer.valueOf(i()), this.f46658d);
            }
        }
    }

    public void h() {
        this.f46665k = false;
    }

    private void b(f fVar) {
        if (this.f46667m > 0) {
            com.qq.e.comm.plugin.p0.e.a().b(this.f46655a.L0(), this.f46655a.o().f42000e, fVar != null ? String.valueOf(fVar.hashCode()) : "12345567");
        }
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void a(int i4, f.t tVar) {
        if (this.f46666l == null || !this.f46665k) {
            return;
        }
        j();
        boolean z3 = tVar == f.t.UNINITIALIZED;
        if (z3) {
            this.f46671q = Math.max(i4, this.f46671q);
        } else {
            this.f46670p = Math.max(i4, this.f46670p);
        }
        d1.a("CDNVideoDownloadTrigger", "onPositionBlock: blockTime = %d, mCurrentDownloadTime = %d, mTriggerBufferTime = %d, state = %s, mVideoDuration = %d, mCurrentDownloadRatio = %.4f", Integer.valueOf(i4), Integer.valueOf(this.f46667m), Integer.valueOf(this.f46662h), tVar, Integer.valueOf(this.f46659e), Double.valueOf(this.f46675u));
        if (this.f46675u >= 1.0d) {
            return;
        }
        int i5 = this.f46664j;
        if (z3) {
            i5 += 1000;
        }
        if (i4 <= i5 || com.qq.e.comm.plugin.o0.g.a.a().f(this.f46656b)) {
            return;
        }
        double min = Math.min(this.f46667m + this.f46663i, this.f46659e);
        double d4 = this.f46659e;
        Double.isNaN(min);
        Double.isNaN(d4);
        a(min / d4);
        d1.a("CDNVideoDownloadTrigger", "onPositionBlock: callback blockTime = %d, mCurrentDownloadTime = %d, mTriggerBufferTime = %d, state = %s, mVideoDuration = %d, mCurrentDownloadRatio = %.4f", Integer.valueOf(i4), Integer.valueOf(this.f46667m), Integer.valueOf(this.f46662h), tVar, Integer.valueOf(this.f46659e), Double.valueOf(this.f46675u));
        this.f46667m = (int) min;
        if (z3) {
            this.f46672r++;
        } else {
            this.f46673s++;
        }
    }

    private void a(double d4) {
        this.f46675u = d4;
        if (d4 > 0.95d) {
            this.f46675u = 1.0d;
        }
        this.f46666l.a(this, this.f46675u);
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public com.qq.e.comm.plugin.g0.e a() {
        return this.f46655a;
    }

    private void a(int i4) {
        if (this.f46674t != Integer.MIN_VALUE) {
            return;
        }
        int i5 = i4 == 0 ? -1 : ((i4 * this.f46659e) / 100) / 1000;
        this.f46674t = i5;
        v.a(1406010, this.f46657c, Integer.valueOf(i5), 0, this.f46658d);
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void a(f fVar) {
        q();
        s();
        o();
        t();
        p();
        r();
        b(fVar);
        this.f46665k = false;
        this.f46666l = null;
    }

    private int a(String str, int i4) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a(a.a(this.f46655a, str), this.f46655a.q0(), -1);
        return a4 >= 0 ? a4 : com.qq.e.comm.plugin.d0.a.d().f().a(str, this.f46655a.q0(), i4);
    }
}
