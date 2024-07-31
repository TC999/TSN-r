package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.p434g.AbstractC10762b;
import java.io.IOException;

/* renamed from: com.kwad.sdk.utils.bh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11054bh {
    private static Class<?> aQi;

    /* renamed from: a */
    private static <T> T m23923a(String str, T t, AbstractC10762b<String, T> abstractC10762b) {
        String m23922gR = m23922gR(str);
        if (m23922gR == null) {
            return t;
        }
        try {
            return abstractC10762b.apply(m23922gR);
        } catch (Throwable unused) {
            return t;
        }
    }

    /* renamed from: gR */
    private static String m23922gR(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            return C10747h.m24943c(runtime.exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            C10331c.printStackTrace(e);
            return null;
        }
    }

    public static String get(String str) {
        Object m23921k = m23921k("get", str);
        if (m23921k instanceof String) {
            return (String) m23921k;
        }
        return m23922gR(str);
    }

    public static boolean getBoolean(String str, boolean z) {
        Object m23921k = m23921k("getBoolean", str, Boolean.valueOf(z));
        if (m23921k instanceof Boolean) {
            return ((Boolean) m23921k).booleanValue();
        }
        return ((Boolean) m23923a(str, Boolean.valueOf(z), new AbstractC10762b<String, Boolean>() { // from class: com.kwad.sdk.utils.bh.4
            /* renamed from: gV */
            private static Boolean m23917gV(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }

            @Override // com.kwad.sdk.p434g.AbstractC10762b
            public final /* synthetic */ Boolean apply(String str2) {
                return m23917gV(str2);
            }
        })).booleanValue();
    }

    public static int getInt(String str, int i) {
        Object m23921k = m23921k("getInt", str, Integer.valueOf(i));
        if (m23921k instanceof Integer) {
            return ((Integer) m23921k).intValue();
        }
        return ((Integer) m23923a(str, Integer.valueOf(i), new AbstractC10762b<String, Integer>() { // from class: com.kwad.sdk.utils.bh.2
            /* renamed from: gT */
            private static Integer m23919gT(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }

            @Override // com.kwad.sdk.p434g.AbstractC10762b
            public final /* synthetic */ Integer apply(String str2) {
                return m23919gT(str2);
            }
        })).intValue();
    }

    public static long getLong(String str, long j) {
        Object m23921k = m23921k("getLong", str, Long.valueOf(j));
        if (m23921k instanceof Long) {
            return ((Long) m23921k).longValue();
        }
        return ((Long) m23923a(str, Long.valueOf(j), new AbstractC10762b<String, Long>() { // from class: com.kwad.sdk.utils.bh.3
            /* renamed from: gU */
            private static Long m23918gU(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }

            @Override // com.kwad.sdk.p434g.AbstractC10762b
            public final /* synthetic */ Long apply(String str2) {
                return m23918gU(str2);
            }
        })).longValue();
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: k */
    private static Object m23921k(String str, Object... objArr) {
        try {
            if (aQi == null) {
                aQi = Class.forName("android.os.SystemProperties");
            }
            return C11124s.m23700b(aQi, str, objArr);
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
            return null;
        }
    }

    public static String get(String str, String str2) {
        Object m23921k = m23921k("get", str, str2);
        if (m23921k instanceof String) {
            return (String) m23921k;
        }
        return (String) m23923a(str, str2, new AbstractC10762b<String, String>() { // from class: com.kwad.sdk.utils.bh.1
            /* renamed from: gS */
            private static String m23920gS(String str3) {
                return str3;
            }

            @Override // com.kwad.sdk.p434g.AbstractC10762b
            public final /* synthetic */ String apply(String str3) {
                return m23920gS(str3);
            }
        });
    }
}
