package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

/* compiled from: SameLogTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39932a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39933b = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39934c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f39935d = true;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f39936e = true;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f39937f = false;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f39938g = true;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f39939h;

    static {
        if (MBridgeConstans.DEBUG) {
            return;
        }
        f39932a = false;
        f39933b = false;
        f39934c = false;
        f39935d = false;
        f39936e = false;
        f39937f = false;
        f39938g = false;
        f39939h = false;
    }

    public static void a(String str, String str2) {
        if (!f39933b || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(a(str), str2);
    }

    public static void b(String str, String str2) {
        if (!f39934c || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(a(str), str2);
    }

    public static void c(String str, String str2) {
        if (!f39935d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2);
    }

    public static void d(String str, String str2) {
        if (!f39936e || str2 == null) {
            return;
        }
        Log.e(a(str), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!f39933b || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(a(str), str2, th);
    }

    public static void b(String str, String str2, Throwable th) {
        if (!f39936e || str2 == null || th == null) {
            return;
        }
        Log.e(a(str), str2, th);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "MBRIDGE_" + str;
    }
}
