package com.qq.e.comm.plugin.util;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c0 {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f46384a;

        static {
            int[] iArr = new int[com.qq.e.comm.plugin.b.g.values().length];
            f46384a = iArr;
            try {
                iArr[com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46384a[com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46384a[com.qq.e.comm.plugin.b.g.UNIFIED_BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46384a[com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int a(com.qq.e.comm.plugin.b.g gVar, String str) {
        String str2;
        int i4 = a.f46384a[gVar.ordinal()];
        if (i4 == 1 || i4 == 2) {
            str2 = "naexpopct";
        } else if (i4 == 3) {
            str2 = "bexpopct";
        } else if (i4 != 4) {
            return 50;
        } else {
            str2 = "ihexpopct";
        }
        return com.qq.e.comm.plugin.d0.a.d().f().a(str2, str, 50);
    }

    public static int a(String str) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("nauexpopct", str, 20);
    }
}
