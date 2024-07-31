package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.al */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12820al {

    /* renamed from: a */
    public static String f36545a = "CrashReportInfo";

    /* renamed from: b */
    public static String f36546b = "CrashReport";

    /* renamed from: c */
    public static boolean f36547c;

    /* renamed from: a */
    private static boolean m15881a(int i, String str, Object... objArr) {
        if (f36547c) {
            if (str == null) {
                str = "null";
            } else if (objArr != null && objArr.length != 0) {
                str = String.format(Locale.US, str, objArr);
            }
            if (i == 0) {
                Log.i(f36546b, str);
                return true;
            } else if (i == 1) {
                Log.d(f36546b, str);
                return true;
            } else if (i == 2) {
                Log.w(f36546b, str);
                return true;
            } else if (i == 3) {
                Log.e(f36546b, str);
                return true;
            } else if (i != 5) {
                return false;
            } else {
                Log.i(f36545a, str);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m15876b(String str, Object... objArr) {
        return m15881a(5, str, objArr);
    }

    /* renamed from: c */
    public static boolean m15874c(String str, Object... objArr) {
        return m15881a(1, str, objArr);
    }

    /* renamed from: d */
    public static boolean m15873d(String str, Object... objArr) {
        return m15881a(2, str, objArr);
    }

    /* renamed from: e */
    public static boolean m15872e(String str, Object... objArr) {
        return m15881a(3, str, objArr);
    }

    /* renamed from: b */
    public static boolean m15875b(Throwable th) {
        return m15880a(3, th);
    }

    /* renamed from: a */
    private static boolean m15880a(int i, Throwable th) {
        if (f36547c) {
            return m15881a(i, C12828ap.m15828a(th), new Object[0]);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m15878a(String str, Object... objArr) {
        return m15881a(0, str, objArr);
    }

    /* renamed from: a */
    public static boolean m15879a(Class cls, String str, Object... objArr) {
        return m15881a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: a */
    public static boolean m15877a(Throwable th) {
        return m15880a(2, th);
    }
}
