package com.bytedance.sdk.openadsdk.core.component.splash.w.c;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends c {

    /* renamed from: a  reason: collision with root package name */
    public static int f33014a = 5;
    public static int au = 22;

    /* renamed from: b  reason: collision with root package name */
    public static String f33015b = "render splash fail";
    public static String ba = "render splash fail";
    public static String bj = "load splash fail";
    public static String bk = "load splash fail";
    public static int bm = 27;
    public static int bw = 18;
    public static String ck = "render splash fail";
    public static String eq = "render splash native image data is empty";
    public static int ev = 3;

    /* renamed from: f  reason: collision with root package name */
    public static int f33016f = 2;
    public static String fm = "load splash fail";
    public static int fp = 7;
    public static String fz = "load splash fail";
    public static String gb = "load splash fail";
    public static String gd = "load splash fail";
    public static String gw = "render splash fail";

    /* renamed from: h  reason: collision with root package name */
    public static String f33017h = "render splash fail";

    /* renamed from: i  reason: collision with root package name */
    public static String f33018i = "load splash fail";
    public static String ia = "load splash fail";

    /* renamed from: j  reason: collision with root package name */
    public static String f33019j = "load splash fail";

    /* renamed from: k  reason: collision with root package name */
    public static String f33020k = "load splash fail";
    public static int ls = 11;

    /* renamed from: m  reason: collision with root package name */
    public static int f33021m = 19;
    public static int me = 15;
    public static int mt = 21;

    /* renamed from: n  reason: collision with root package name */
    public static int f33022n = 12;
    public static String ng = "load splash fail";
    public static int oh = 31;
    public static int ok = 30;
    public static String oo = "load splash fail";
    public static String ox = "load splash fail";

    /* renamed from: p  reason: collision with root package name */
    public static int f33023p = 4;
    public static String pr = "render splash fail";

    /* renamed from: q  reason: collision with root package name */
    public static int f33024q = 10;

    /* renamed from: r  reason: collision with root package name */
    public static String f33025r = "load splash fail";

    /* renamed from: s  reason: collision with root package name */
    public static int f33026s = 8;
    public static int sr = 1;

    /* renamed from: t  reason: collision with root package name */
    public static int f33027t = 6;

    /* renamed from: u  reason: collision with root package name */
    public static int f33028u = 9;
    public static String up = "load splash fail";
    public static String ux = "missing request parameter";
    public static int vc = 20;
    public static int wo = 28;
    public static String wv = "render splash native video play error";
    public static int wx = 17;

    /* renamed from: x  reason: collision with root package name */
    public static String f33029x = "render splash fail";
    public static int xk = 16;
    public static int xu = 29;

    /* renamed from: y  reason: collision with root package name */
    public static int f33030y = 14;
    public static String ys = "load splash fail";
    public static String yu = "render splash native video time out";

    /* renamed from: z  reason: collision with root package name */
    public static int f33031z = 13;
    private boolean be;
    private long bs;
    private int eu;

    /* renamed from: g  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ys.w.w.w f33032g;
    private String ge;
    private boolean ta;
    private int te;

    public r() {
        this.te = -1;
        this.ge = "unknown";
        this.ta = false;
        this.be = false;
    }

    public void c(String str) {
        this.ge = str;
    }

    public boolean ev() {
        return this.be;
    }

    public boolean f() {
        return this.ta;
    }

    public com.bytedance.sdk.openadsdk.ys.w.w.w gd() {
        return this.f33032g;
    }

    public int r() {
        return this.eu;
    }

    public int sr() {
        return this.te;
    }

    public String ux() {
        return TextUtils.isEmpty(this.ge) ? "unknown" : this.ge;
    }

    public void w(int i4) {
        this.te = i4;
    }

    public void xv(int i4) {
        this.eu = i4;
    }

    public void c(boolean z3) {
        this.ta = z3;
    }

    public void w(boolean z3) {
        this.be = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.c.c
    public long xv() {
        return this.bs;
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        this.f33032g = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.c.c
    public void c(long j4) {
        this.bs = j4;
    }

    public r(int i4, String str, boolean z3) {
        this.ta = false;
        this.te = i4;
        this.ge = str;
        this.be = z3;
    }
}
