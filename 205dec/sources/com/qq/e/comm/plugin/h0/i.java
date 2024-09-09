package com.qq.e.comm.plugin.h0;

import android.util.Pair;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f44045a = "i";

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f44046b;

    private static b a() {
        if (f44046b == null) {
            synchronized (b.class) {
                if (f44046b == null) {
                    b bVar = new b();
                    Pair<Integer, Integer> b4 = b();
                    bVar.a(((Integer) b4.first).intValue(), ((Integer) b4.second).intValue()).a(c());
                    f44046b = bVar;
                }
            }
        }
        return f44046b;
    }

    private static Pair<Integer, Integer> b() {
        try {
            String[] split = com.qq.e.comm.plugin.d0.a.d().f().b("emtd", "700,100").split(",");
            return new Pair<>(Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[1])));
        } catch (Exception unused) {
            return new Pair<>(700, 100);
        }
    }

    private static boolean c() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("emts", 0) == 1;
    }

    private static boolean d() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("emts", 0) != 0;
    }

    public static boolean e() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("fps_enable", 1) == 1;
    }

    public static void f() {
        if (d()) {
            a().c();
        } else {
            d1.a(f44045a, "startEvilMethodMonitor: failed");
        }
    }

    public static void g() {
        if (f44046b != null) {
            synchronized (b.class) {
                if (f44046b != null) {
                    f44046b.d();
                    f44046b = null;
                }
            }
        }
    }
}
