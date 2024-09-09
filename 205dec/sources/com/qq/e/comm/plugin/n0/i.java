package com.qq.e.comm.plugin.n0;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final com.qq.e.comm.plugin.d0.d.h f44757a = com.qq.e.comm.plugin.d0.a.d().f();

    /* renamed from: b  reason: collision with root package name */
    private static final int f44758b = new Random(System.currentTimeMillis()).nextInt(10000);

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f44759c;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f44760d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f44761e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f44762f;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f44763g;

    /* renamed from: h  reason: collision with root package name */
    private static final int f44764h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f44765i;

    /* renamed from: j  reason: collision with root package name */
    private static final int f44766j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f44767k;

    /* renamed from: l  reason: collision with root package name */
    private static final int f44768l;

    /* renamed from: m  reason: collision with root package name */
    private static final int f44769m;

    /* renamed from: n  reason: collision with root package name */
    private static final HashSet<Integer> f44770n;

    /* renamed from: o  reason: collision with root package name */
    private static final HashSet<Integer> f44771o;

    static {
        f44757a.a("maxSingleSize", 1024);
        f44759c = f44758b < f44757a.a("perfRate", 10000);
        f44760d = f44758b < f44757a.a("eventRate", 10000);
        f44761e = f44757a.a("eventInstant", 0) == 1;
        f44762f = f44757a.a("maxCount", 30);
        f44763g = f44757a.a("perfInstant", 0) == 1;
        f44764h = f44757a.a("perfPeriod", 600);
        f44765i = f44757a.a("eventPeriod", 600);
        f44766j = f44757a.a("perfBatchCount", 30);
        f44767k = f44757a.a("eventBatchCount", 30);
        f44768l = f44757a.a("perfNetPer", 30);
        f44769m = f44757a.a("eventNetPer", 30);
        f44770n = g();
        f44771o = f();
    }

    private static HashSet<Integer> a(String str) {
        String[] split;
        HashSet<Integer> hashSet = new HashSet<>();
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c(str);
        if (!TextUtils.isEmpty(c4) && (split = c4.split(",")) != null && split.length > 0) {
            try {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }

    static int b() {
        return f44765i;
    }

    static int c() {
        return f44762f;
    }

    static int d() {
        return f44766j;
    }

    static int e() {
        return f44764h;
    }

    private static HashSet<Integer> f() {
        HashSet<Integer> a4 = a("ntrpe");
        a4.addAll(a("sprpe"));
        return a4;
    }

    private static HashSet<Integer> g() {
        return a("skrrd");
    }

    static boolean h() {
        return f44761e;
    }

    static boolean i() {
        return (com.qq.e.comm.plugin.d0.a.d().c().n().c() & f44769m) > 0;
    }

    static boolean j() {
        return f44763g;
    }

    static boolean k() {
        return (com.qq.e.comm.plugin.d0.a.d().c().n().c() & f44768l) > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l() {
        return f44759c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(boolean z3, int i4) {
        return z3 || (f44770n.size() > 0 && f44770n.contains(Integer.valueOf(i4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(int i4) {
        return i4 != 0 && f44760d && (f44771o.size() <= 0 || !f44771o.contains(Integer.valueOf(i4)));
    }

    static int a() {
        return f44767k;
    }
}
