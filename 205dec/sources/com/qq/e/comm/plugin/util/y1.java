package com.qq.e.comm.plugin.util;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashSet;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HashSet<Integer> f46728a;

    /* renamed from: b  reason: collision with root package name */
    private static Integer f46729b;

    private static int a(String str) {
        int i4 = com.qq.e.comm.plugin.s0.b.a(true) ? 54956 : 22188;
        if (com.qq.e.comm.plugin.i.w.a(com.qq.e.comm.plugin.d0.a.d().a())) {
            i4 |= 65536;
        }
        int i5 = i4 | 131072 | 524288 | 2097152;
        if (d(str)) {
            i5 |= 4194304;
        }
        if (c()) {
            i5 |= 8388608;
        }
        int i6 = i5 | 16777216;
        if (c(str)) {
            i6 |= 33554432;
        }
        return !b(str) ? i6 | TTAdConstant.KEY_CLICK_AREA : i6;
    }

    private static void a(int i4) {
    }

    private static boolean b(int i4) {
        if (f46728a == null) {
            synchronized (y1.class) {
                if (f46728a == null) {
                    f46728a = new HashSet<>();
                    try {
                        for (String str : com.qq.e.comm.plugin.d0.a.d().f().b("swcat", "9,23,12,22,26,11,24").split(",")) {
                            f46728a.add(Integer.valueOf(Integer.parseInt(str)));
                        }
                    } catch (Exception e4) {
                        d1.a(e4.getMessage(), e4);
                    }
                }
            }
        }
        if (f46728a.isEmpty()) {
            return i4 == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.d() || i4 == com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.d() || i4 == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN.d() || i4 == com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.d();
        }
        return f46728a.contains(Integer.valueOf(i4));
    }

    private static boolean c() {
        return true;
    }

    private static boolean c(String str) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("spprd", str, 0) == 1;
    }

    private static boolean d(String str) {
        if (com.qq.e.comm.plugin.j.c.a.a()) {
            if (f46729b == null) {
                f46729b = Integer.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("smdpa", str, 1));
            }
            return f46729b.intValue() == 1;
        }
        return false;
    }

    public static int a(com.qq.e.comm.plugin.b.d dVar) {
        int a4 = a(dVar.w());
        boolean z3 = com.qq.e.comm.plugin.d0.a.d().f().a("rewardEndCardLandingPageLandscape", 0) == 1;
        if (com.qq.e.comm.plugin.d0.a.d().f().a("rewardEndCardLandingPage", 1) == 1 && (z3 || com.qq.e.comm.plugin.d0.a.d().c().y())) {
            a4 |= 1;
        }
        if (b(dVar.x())) {
            a4 |= 64;
        }
        if (com.qq.e.comm.plugin.splash.j.a(dVar) && b()) {
            a4 |= 2048;
        }
        a(a4);
        return a4;
    }

    private static boolean b() {
        return !"0".equals(GlobalSetting.getExtraUserData().get("shakable"));
    }

    private static boolean b(String str) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("auss", str, 0) == 0;
    }

    public static int a() {
        int a4 = a((String) null);
        if (com.qq.e.comm.plugin.d0.a.d().c().y()) {
            a4 |= 1;
        }
        int i4 = a4 | 64;
        if (b()) {
            i4 |= 2048;
        }
        a(i4);
        return i4;
    }
}
