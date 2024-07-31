package com.tencent.bugly.crashreport;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.proguard.C12824ao;
import com.tencent.bugly.proguard.C12904p;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BuglyLog {
    /* renamed from: d */
    public static void m16049d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C12904p.f36892c) {
            Log.d(str, str2);
        }
        C12824ao.m15861a("D", str, str2);
    }

    /* renamed from: e */
    public static void m16048e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C12904p.f36892c) {
            Log.e(str, str2);
        }
        C12824ao.m15861a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    /* renamed from: i */
    public static void m16046i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C12904p.f36892c) {
            Log.i(str, str2);
        }
        C12824ao.m15861a("I", str, str2);
    }

    public static void setCache(int i) {
        C12824ao.m15863a(i);
    }

    /* renamed from: v */
    public static void m16045v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C12904p.f36892c) {
            Log.v(str, str2);
        }
        C12824ao.m15861a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    /* renamed from: w */
    public static void m16044w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C12904p.f36892c) {
            Log.w(str, str2);
        }
        C12824ao.m15861a(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    /* renamed from: e */
    public static void m16047e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C12904p.f36892c) {
            Log.e(str, str2, th);
        }
        C12824ao.m15859a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}
