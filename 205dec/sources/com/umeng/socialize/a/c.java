package com.umeng.socialize.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Misc.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f53887a;

    /* renamed from: b  reason: collision with root package name */
    public static String f53888b;

    /* renamed from: c  reason: collision with root package name */
    public static String f53889c;

    public static String a() {
        if (TextUtils.isEmpty(f53887a)) {
            String str = Build.BRAND;
            f53887a = str;
            if (TextUtils.isEmpty(str)) {
                f53887a = Build.MANUFACTURER;
            }
        }
        return f53887a;
    }

    public static String b() {
        if (TextUtils.isEmpty(f53888b)) {
            f53888b = Build.MODEL;
        }
        return f53888b;
    }

    public static String c() {
        if (TextUtils.isEmpty(f53889c)) {
            f53889c = Build.BOARD;
        }
        return f53889c;
    }

    public static boolean b(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static Object a(Object obj, String str, int i4) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i4);
        } catch (Throwable th) {
            if (a.f53878c) {
                UMRTLog.e("MISC", "pkg:" + str + " failed:" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public static boolean a(Context context) {
        return UMUtils.isMainProgress(context);
    }
}
