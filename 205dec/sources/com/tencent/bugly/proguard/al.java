package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class al {

    /* renamed from: a  reason: collision with root package name */
    public static String f50919a = "CrashReportInfo";

    /* renamed from: b  reason: collision with root package name */
    public static String f50920b = "CrashReport";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f50921c;

    private static boolean a(int i4, String str, Object... objArr) {
        if (f50921c) {
            if (str == null) {
                str = "null";
            } else if (objArr != null && objArr.length != 0) {
                str = String.format(Locale.US, str, objArr);
            }
            if (i4 == 0) {
                Log.i(f50920b, str);
                return true;
            } else if (i4 == 1) {
                Log.d(f50920b, str);
                return true;
            } else if (i4 == 2) {
                Log.w(f50920b, str);
                return true;
            } else if (i4 == 3) {
                Log.e(f50920b, str);
                return true;
            } else if (i4 != 5) {
                return false;
            } else {
                Log.i(f50919a, str);
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Throwable th) {
        return a(3, th);
    }

    private static boolean a(int i4, Throwable th) {
        if (f50921c) {
            return a(i4, ap.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th) {
        return a(2, th);
    }
}
