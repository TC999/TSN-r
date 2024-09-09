package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f46529a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f46530b;

    static {
        f46529a = com.qq.e.comm.plugin.d0.a.d().f().a("gvfqe", 1) == 1;
    }

    public static String a() {
        if (f46529a) {
            if (f46530b == null) {
                synchronized (n.class) {
                    if (f46530b == null) {
                        f46530b = a("com.tencent.mobileqq");
                    }
                }
            }
            return f46530b == null ? "" : f46530b;
        }
        return "";
    }

    private static String a(String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (TextUtils.isEmpty(str)) {
            d1.a("getVersionName error, packageName == null");
            com.qq.e.comm.plugin.n0.v.b(100192, null, 1, dVar);
            return null;
        }
        dVar.a("pkg", str);
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        if (a4 == null) {
            d1.a("getVersionName error, context == null, pkg = " + str);
            com.qq.e.comm.plugin.n0.v.b(100192, null, 2, dVar);
            return null;
        }
        try {
            PackageManager packageManager = a4.getPackageManager();
            if (packageManager == null) {
                d1.a("getVersionName error, pm == null, pkg = " + str);
                com.qq.e.comm.plugin.n0.v.b(100192, null, 3, dVar);
                return null;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                d1.a("getVersionName error, info == null, pkg = " + str);
                com.qq.e.comm.plugin.n0.v.b(100192, null, 4, dVar);
                return "";
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            d1.a("getVersionName error, exception = %s", e4.toString());
            com.qq.e.comm.plugin.n0.v.b(100192, null, 5, dVar);
            return "";
        } catch (Exception e5) {
            d1.a("getVersionName error, exception = %s", e5.toString());
            com.qq.e.comm.plugin.n0.v.b(100192, null, 6, dVar);
            return "";
        }
    }
}
