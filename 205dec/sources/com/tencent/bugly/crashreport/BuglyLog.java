package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BuglyLog {
    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f51258c) {
            Log.d(str, str2);
        }
        ao.a("D", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f51258c) {
            Log.e(str, str2);
        }
        ao.a("E", str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f51258c) {
            Log.i(str, str2);
        }
        ao.a("I", str, str2);
    }

    public static void setCache(int i4) {
        ao.a(i4);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f51258c) {
            Log.v(str, str2);
        }
        ao.a("V", str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f51258c) {
            Log.w(str, str2);
        }
        ao.a("W", str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f51258c) {
            Log.e(str, str2, th);
        }
        ao.a("E", str, th);
    }
}
