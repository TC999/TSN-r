package com.qq.e.comm.plugin.apkmanager.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f41947a;

    public static final int a() {
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        if (Build.VERSION.SDK_INT < 26) {
            return 1;
        }
        if (b(a4)) {
            return a(a4) ? 1 : 2;
        }
        return 3;
    }

    private static boolean b(Context context) {
        String[] strArr;
        Boolean bool = f41947a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            strArr = packageInfo != null ? packageInfo.requestedPermissions : null;
        } catch (Exception unused) {
            f41947a = Boolean.TRUE;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if ("android.permission.REQUEST_INSTALL_PACKAGES".equals(str)) {
                    f41947a = Boolean.TRUE;
                    return true;
                }
            }
            f41947a = Boolean.FALSE;
            return f41947a.booleanValue();
        }
        f41947a = Boolean.TRUE;
        return true;
    }

    public static boolean c() {
        int a4 = a();
        return a4 == 1 || a4 == 3;
    }

    private static boolean a(Context context) {
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        return a() == 1;
    }
}
