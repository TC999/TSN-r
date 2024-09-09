package com.qq.e.comm.plugin.apkmanager.x;

import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, String> f41939a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f41940b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private static String f41941c;

    public static int a() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("riadc", 0);
        return a4 <= 10 ? a4 : com.qq.e.comm.plugin.t.a.b().a(String.valueOf(a4), 0);
    }

    public static final int b() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("jusmc", 0);
        return a4 <= 10 ? a4 : com.qq.e.comm.plugin.t.a.b().a(String.valueOf(a4), 0);
    }

    private static int c() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("rtiac", 0);
        return a4 <= 3 ? a4 : com.qq.e.comm.plugin.t.a.b().a(String.valueOf(a4), 0);
    }

    private static int d() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("rdec", 2);
        return a4 <= 3 ? a4 : com.qq.e.comm.plugin.t.a.b().a(String.valueOf(a4), 2);
    }

    public static String e() {
        return f41941c;
    }

    public static final boolean f() {
        int c4 = c();
        return c4 == 1 || c4 == 3;
    }

    public static final boolean g() {
        int c4 = c();
        return c4 == 2 || c4 == 3;
    }

    public static boolean h() {
        return d() != 1;
    }

    public static boolean i() {
        return d() == 2;
    }

    public static int a(com.qq.e.comm.plugin.g0.e eVar) {
        return Math.max(1, com.qq.e.comm.plugin.d0.a.d().f().a("adact", eVar.q0(), 3));
    }

    public static int b(com.qq.e.comm.plugin.g0.e eVar) {
        int i4 = f41940b;
        if (i4 >= 1) {
            return i4;
        }
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("adcdt", eVar.q0(), 4);
        if (a4 > 10000) {
            a4 = com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), String.valueOf(a4), 4);
            if (f41939a == null) {
                HashMap hashMap = new HashMap();
                f41939a = hashMap;
                hashMap.put(1, "AA");
                f41939a.put(2, "AB");
                f41939a.put(3, "AC");
                f41939a.put(4, "AD");
            }
            f41941c = f41939a.get(Integer.valueOf(a4));
        }
        f41940b = a4;
        return a4;
    }
}
