package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

/* renamed from: com.mbridge.msdk.foundation.tools.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameLogTool {

    /* renamed from: a */
    public static boolean f31159a = true;

    /* renamed from: b */
    public static boolean f31160b = true;

    /* renamed from: c */
    public static boolean f31161c = true;

    /* renamed from: d */
    public static boolean f31162d = true;

    /* renamed from: e */
    public static boolean f31163e = true;

    /* renamed from: f */
    public static boolean f31164f = false;

    /* renamed from: g */
    public static boolean f31165g = true;

    /* renamed from: h */
    public static boolean f31166h;

    static {
        if (MBridgeConstans.DEBUG) {
            return;
        }
        f31159a = false;
        f31160b = false;
        f31161c = false;
        f31162d = false;
        f31163e = false;
        f31164f = false;
        f31165g = false;
        f31166h = false;
    }

    /* renamed from: a */
    public static void m21738a(String str, String str2) {
        if (!f31160b || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(m21739a(str), str2);
    }

    /* renamed from: b */
    public static void m21736b(String str, String str2) {
        if (!f31161c || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(m21739a(str), str2);
    }

    /* renamed from: c */
    public static void m21734c(String str, String str2) {
        if (!f31162d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(m21739a(str), str2);
    }

    /* renamed from: d */
    public static void m21733d(String str, String str2) {
        if (!f31163e || str2 == null) {
            return;
        }
        Log.e(m21739a(str), str2);
    }

    /* renamed from: a */
    public static void m21737a(String str, String str2, Throwable th) {
        if (!f31160b || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(m21739a(str), str2, th);
    }

    /* renamed from: b */
    public static void m21735b(String str, String str2, Throwable th) {
        if (!f31163e || str2 == null || th == null) {
            return;
        }
        Log.e(m21739a(str), str2, th);
    }

    /* renamed from: a */
    private static String m21739a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "MBRIDGE_" + str;
    }
}
