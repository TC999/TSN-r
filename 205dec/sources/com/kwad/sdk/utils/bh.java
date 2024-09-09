package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.acse.ottn.f3;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bh {
    private static Class<?> aQi;

    private static <T> T a(String str, T t3, com.kwad.sdk.g.b<String, T> bVar) {
        String gR = gR(str);
        if (gR == null) {
            return t3;
        }
        try {
            return bVar.apply(gR);
        } catch (Throwable unused) {
            return t3;
        }
    }

    private static String gR(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            return com.kwad.sdk.crash.utils.h.c(runtime.exec("getprop " + str).getInputStream());
        } catch (IOException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            return null;
        }
    }

    public static String get(String str) {
        Object k4 = k(f3.f5657f, str);
        if (k4 instanceof String) {
            return (String) k4;
        }
        return gR(str);
    }

    public static boolean getBoolean(String str, boolean z3) {
        Object k4 = k("getBoolean", str, Boolean.valueOf(z3));
        if (k4 instanceof Boolean) {
            return ((Boolean) k4).booleanValue();
        }
        return ((Boolean) a(str, Boolean.valueOf(z3), new com.kwad.sdk.g.b<String, Boolean>() { // from class: com.kwad.sdk.utils.bh.4
            private static Boolean gV(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(String str2) {
                return gV(str2);
            }
        })).booleanValue();
    }

    public static int getInt(String str, int i4) {
        Object k4 = k("getInt", str, Integer.valueOf(i4));
        if (k4 instanceof Integer) {
            return ((Integer) k4).intValue();
        }
        return ((Integer) a(str, Integer.valueOf(i4), new com.kwad.sdk.g.b<String, Integer>() { // from class: com.kwad.sdk.utils.bh.2
            private static Integer gT(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Integer apply(String str2) {
                return gT(str2);
            }
        })).intValue();
    }

    public static long getLong(String str, long j4) {
        Object k4 = k("getLong", str, Long.valueOf(j4));
        if (k4 instanceof Long) {
            return ((Long) k4).longValue();
        }
        return ((Long) a(str, Long.valueOf(j4), new com.kwad.sdk.g.b<String, Long>() { // from class: com.kwad.sdk.utils.bh.3
            private static Long gU(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Long apply(String str2) {
                return gU(str2);
            }
        })).longValue();
    }

    @SuppressLint({"PrivateApi"})
    private static Object k(String str, Object... objArr) {
        try {
            if (aQi == null) {
                aQi = Class.forName("android.os.SystemProperties");
            }
            return s.b(aQi, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return null;
        }
    }

    public static String get(String str, String str2) {
        Object k4 = k(f3.f5657f, str, str2);
        if (k4 instanceof String) {
            return (String) k4;
        }
        return (String) a(str, str2, new com.kwad.sdk.g.b<String, String>() { // from class: com.kwad.sdk.utils.bh.1
            private static String gS(String str3) {
                return str3;
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ String apply(String str3) {
                return gS(str3);
            }
        });
    }
}
