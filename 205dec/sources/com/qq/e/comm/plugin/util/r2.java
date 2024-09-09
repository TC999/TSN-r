package com.qq.e.comm.plugin.util;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class r2 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Integer f46599a;

    public static int a() {
        if (f46599a == null) {
            f46599a = Integer.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("drwuc", 1));
        }
        return f46599a.intValue();
    }

    public static boolean b() {
        int a4 = a();
        return a4 == 2 || a4 == 3;
    }

    public static boolean c() {
        int a4 = a();
        return a4 == 2 || a4 == 1;
    }
}
