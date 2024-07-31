package com.umeng.socialize.p569a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;

/* compiled from: Misc.java */
/* renamed from: com.umeng.socialize.a.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13308c {

    /* renamed from: a */
    public static String f39298a;

    /* renamed from: b */
    public static String f39299b;

    /* renamed from: c */
    public static String f39300c;

    /* renamed from: a */
    public static String m13426a() {
        if (TextUtils.isEmpty(f39298a)) {
            String str = Build.BRAND;
            f39298a = str;
            if (TextUtils.isEmpty(str)) {
                f39298a = Build.MANUFACTURER;
            }
        }
        return f39298a;
    }

    /* renamed from: b */
    public static String m13422b() {
        if (TextUtils.isEmpty(f39299b)) {
            f39299b = Build.MODEL;
        }
        return f39299b;
    }

    /* renamed from: c */
    public static String m13420c() {
        if (TextUtils.isEmpty(f39300c)) {
            f39300c = Build.BOARD;
        }
        return f39300c;
    }

    /* renamed from: b */
    public static boolean m13421b(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    /* renamed from: a */
    public static void m13424a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static Object m13423a(Object obj, String str, int i) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i);
        } catch (Throwable th) {
            if (AzxConstant.f39292c) {
                UMRTLog.m14009e("MISC", "pkg:" + str + " failed:" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m13425a(Context context) {
        return UMUtils.isMainProgress(context);
    }
}
