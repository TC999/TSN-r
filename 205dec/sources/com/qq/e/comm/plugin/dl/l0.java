package com.qq.e.comm.plugin.dl;

import android.util.Pair;
import com.qq.e.comm.plugin.util.z1;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f42481a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile HashSet<Integer> f42482b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42483a;

        static {
            int[] iArr = new int[com.qq.e.comm.plugin.b.g.values().length];
            f42483a = iArr;
            try {
                iArr[com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42483a[com.qq.e.comm.plugin.b.g.UNIFIED_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42483a[com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<Boolean, String> a(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        boolean x3 = com.qq.e.comm.plugin.d0.a.d().c().x();
        int i4 = (!eVar.l1() || z3) ? 1 : 2;
        int i5 = x3 ? 2 : 1;
        int i6 = eVar.o0() > eVar.n0() ? 2 : 1;
        com.qq.e.comm.plugin.b.g o4 = eVar.o();
        int i7 = a.f42483a[o4.ordinal()];
        if (i7 == 1 || i7 == 2) {
            i5 = 0;
            i6 = 0;
        } else if (i7 == 3) {
            if (i4 == 2) {
                return new Pair<>(Boolean.valueOf(a(o4)), "");
            }
            i5 = 0;
        }
        boolean a4 = a(o4);
        return new Pair<>(Boolean.valueOf(a4), String.format(Locale.getDefault(), a4 ? "1%d%d%d%02d" : "%d%d%d%02d", Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(a(eVar))));
    }

    private static int a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar.o() == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD && eVar.z0() == 4) {
            return 51;
        }
        return eVar.o().f42000e;
    }

    public static boolean a(com.qq.e.comm.plugin.b.g gVar) {
        if (z1.c()) {
            if (f42481a == null) {
                synchronized (l0.class) {
                    if (f42481a == null) {
                        boolean z3 = true;
                        if (com.qq.e.comm.plugin.t.c.a("puit", "APP", 1) != 1) {
                            z3 = false;
                        }
                        f42481a = Boolean.valueOf(z3);
                    }
                }
            }
            if (f42481a.booleanValue()) {
                if (f42482b == null) {
                    synchronized (l0.class) {
                        if (f42482b == null) {
                            f42482b = new HashSet<>();
                            for (String str : com.qq.e.comm.plugin.d0.a.d().f().b("puitat", "3,5,8,9").split(",")) {
                                f42482b.add(Integer.valueOf(Integer.parseInt(str)));
                            }
                        }
                    }
                }
                return f42482b.contains(Integer.valueOf(gVar.f42000e));
            }
            return false;
        }
        return false;
    }
}
