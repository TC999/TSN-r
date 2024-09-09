package com.acse.ottn;

import com.acse.ottn.util.HelpShopAppUtil;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j0 {

    /* renamed from: c  reason: collision with root package name */
    public static m0 f5761c;

    /* renamed from: w  reason: collision with root package name */
    public static String f5781w;

    /* renamed from: x  reason: collision with root package name */
    public static String f5782x;

    /* renamed from: y  reason: collision with root package name */
    public static String f5783y;

    /* renamed from: a  reason: collision with root package name */
    public static String f5759a = h1.c().b();

    /* renamed from: b  reason: collision with root package name */
    public static String f5760b = a("");

    /* renamed from: d  reason: collision with root package name */
    public static boolean f5762d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f5763e = true;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f5764f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f5765g = false;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f5766h = false;

    /* renamed from: i  reason: collision with root package name */
    public static String f5767i = "1";

    /* renamed from: j  reason: collision with root package name */
    public static String f5768j = "0";

    /* renamed from: k  reason: collision with root package name */
    public static String f5769k = "11";

    /* renamed from: l  reason: collision with root package name */
    public static String f5770l = "1";

    /* renamed from: m  reason: collision with root package name */
    public static int f5771m = 17;

    /* renamed from: n  reason: collision with root package name */
    public static int f5772n = 18;

    /* renamed from: o  reason: collision with root package name */
    public static String f5773o = "com.acse.ottn";

    /* renamed from: p  reason: collision with root package name */
    public static String f5774p = "0";

    /* renamed from: q  reason: collision with root package name */
    public static String f5775q = "1";

    /* renamed from: r  reason: collision with root package name */
    public static String f5776r = "com.zjwh.android_wh_physicalfitness";

    /* renamed from: s  reason: collision with root package name */
    public static String f5777s = "com.huachenjie.shandong_school";

    /* renamed from: t  reason: collision with root package name */
    public static String f5778t = "com.bxkj.student";

    /* renamed from: u  reason: collision with root package name */
    public static String f5779u = "com.lptiyu.tanke";

    /* renamed from: v  reason: collision with root package name */
    public static String f5780v = "com.yuedong.sport";

    static {
        f5781w = HelpShopAppUtil.getContext() != null ? HelpShopAppUtil.getContext().getPackageName() : "";
        f5782x = "".equals(g1.a().d("app_version_code")) ? c4.r() : g1.a().d("app_version_code");
        f5783y = "".equals(g1.a().d("getSystemVersion")) ? c4.q() : g1.a().d("getSystemVersion");
    }

    public static String a(String str) {
        return "\u7a0b\u5e8f";
    }

    public static String a(boolean z3) {
        return z3 ? "QVbZFjAoPF6LCCQm6RgDs1g13mnJ8nA0" : g1.a().d("aes_key");
    }

    public static void b(boolean z3) {
        if (g1.a() != null) {
            i2.a().a("battery_permission");
            g1.a().a("open_battery_white", z3);
        }
    }

    public static void c(boolean z3) {
        z1.a("MyService", "setServiceHightButteryState come on");
        if (g1.a() != null) {
            g1.a().a("background_battery_hignt", z3);
        }
        i2.a().a("vivo_battery_permission");
    }

    public static void a(m0 m0Var) {
        f5761c = m0Var;
    }

    public static m0 a() {
        return f5761c;
    }
}
