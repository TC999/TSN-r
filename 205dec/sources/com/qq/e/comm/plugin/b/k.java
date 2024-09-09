package com.qq.e.comm.plugin.b;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42014a = "k";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42015a;

        static {
            int[] iArr = new int[c.values().length];
            f42015a = iArr;
            try {
                iArr[c.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42015a[c.UNIFIED_INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42015a[c.FULL_SCREEN_INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42015a[c.REWARD_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f42015a[c.END_CARD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f42015a[c.REWARD_PAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f42016a;

        /* renamed from: b  reason: collision with root package name */
        public final int f42017b;

        /* renamed from: c  reason: collision with root package name */
        public final int f42018c;

        /* renamed from: d  reason: collision with root package name */
        public final int f42019d;

        public b(int i4, int i5, int i6, int i7) {
            this.f42016a = i4;
            this.f42017b = i5;
            this.f42018c = i6;
            this.f42019d = i7;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public enum c {
        SPLASH,
        UNIFIED_INTERSTITIAL,
        FULL_SCREEN_INTERSTITIAL,
        REWARD_VIDEO,
        REWARD_PAGE,
        END_CARD
    }

    public static b a(c cVar, com.qq.e.comm.plugin.g0.e eVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        String a4;
        String a5 = a(cVar);
        int i8 = 0;
        if (TextUtils.isEmpty(a5)) {
            i7 = 0;
            i5 = 0;
            i6 = 0;
        } else {
            try {
                String b4 = b(cVar);
                com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
                if (eVar == null) {
                    a4 = f4.b(a5, b4);
                } else {
                    a4 = f4.a(a5, eVar.q0(), b4);
                }
                if (a4.contains(",")) {
                    b4 = a4;
                } else if (eVar != null) {
                    b4 = com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), a4, b4);
                }
                Context a6 = com.qq.e.comm.plugin.d0.a.d().a();
                String[] split = b4.split(",");
                i4 = f1.a(a6, Integer.parseInt(split[0]));
                try {
                    i5 = f1.a(a6, Integer.parseInt(split[1]));
                    try {
                        i6 = f1.a(a6, Integer.parseInt(split[2]));
                        try {
                            i7 = f1.a(a6, Integer.parseInt(split[3]));
                            i8 = i4;
                        } catch (Exception e4) {
                            e = e4;
                            d1.a(f42014a, "getSafeArea", e);
                            i8 = i4;
                            i7 = 0;
                            return new b(i8, i5, i6, i7);
                        }
                    } catch (Exception e5) {
                        e = e5;
                        i6 = 0;
                        d1.a(f42014a, "getSafeArea", e);
                        i8 = i4;
                        i7 = 0;
                        return new b(i8, i5, i6, i7);
                    }
                } catch (Exception e6) {
                    e = e6;
                    i5 = 0;
                    i6 = 0;
                    d1.a(f42014a, "getSafeArea", e);
                    i8 = i4;
                    i7 = 0;
                    return new b(i8, i5, i6, i7);
                }
            } catch (Exception e7) {
                e = e7;
                i4 = 0;
            }
        }
        return new b(i8, i5, i6, i7);
    }

    private static String b(c cVar) {
        int i4 = a.f42015a[cVar.ordinal()];
        return (i4 == 3 || i4 == 4) ? "7,7,7,7" : i4 != 6 ? "6,6,6,6" : "14,14,14,14";
    }

    private static String a(c cVar) {
        switch (a.f42015a[cVar.ordinal()]) {
            case 1:
                return "ssvsa";
            case 2:
                return "icbsa";
            case 3:
                return "fsicbsa";
            case 4:
                return "rvcbsa";
            case 5:
                return "eccbsa";
            case 6:
                return "rpcbsa";
            default:
                return "";
        }
    }
}
