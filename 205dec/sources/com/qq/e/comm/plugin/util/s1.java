package com.qq.e.comm.plugin.util;

import java.util.Random;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class s1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f46602a = new Random(System.currentTimeMillis());

    public static void a() {
    }

    public static boolean a(int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return false;
        }
        return i4 >= i5 || f46602a.nextInt(i5) < i4;
    }

    public static boolean b() {
        com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
        if (f4 != null) {
            return a(f4.a("securityVulnerabilityReport", 10), 10000);
        }
        return false;
    }
}
