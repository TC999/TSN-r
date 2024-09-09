package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f46765a;

    private static boolean a() {
        if (Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        if (a4.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            int i4 = a4.getApplicationInfo().targetSdkVersion;
            return Build.VERSION.SDK_INT < 29 || i4 < 29 || (i4 == 29 && Environment.isExternalStorageLegacy());
        }
        return false;
    }

    public static void b() {
        int a4 = u1.a("estop", 0);
        int i4 = 1;
        int i5 = a() ? 1 : -1;
        if (a4 != i5) {
            u1.b("estop", i5);
        }
        if (a4 != 0 && a4 != i5) {
            i4 = -1;
        }
        com.qq.e.comm.plugin.n0.v.a(9200002, null, Integer.valueOf(i5), Integer.valueOf(i4), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        com.qq.e.comm.plugin.util.z0.f46765a = java.lang.Boolean.TRUE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            java.lang.Boolean r1 = com.qq.e.comm.plugin.util.z0.f46765a
            if (r1 != 0) goto L3f
            java.lang.Class<com.qq.e.comm.plugin.util.c> r1 = com.qq.e.comm.plugin.util.c.class
            monitor-enter(r1)
            java.lang.Boolean r2 = com.qq.e.comm.plugin.util.z0.f46765a     // Catch: java.lang.Throwable -> L3c
            if (r2 != 0) goto L3a
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L3c
            com.qq.e.comm.plugin.util.z0.f46765a = r2     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Throwable -> L3c
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a java.lang.Throwable -> L3c
            r3 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r2, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a java.lang.Throwable -> L3c
            java.lang.String[] r5 = r5.requestedPermissions     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a java.lang.Throwable -> L3c
            if (r5 == 0) goto L3a
            int r2 = r5.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a java.lang.Throwable -> L3c
        L26:
            if (r0 >= r2) goto L3a
            r3 = r5[r0]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a java.lang.Throwable -> L3c
            java.lang.String r4 = "android.permission.QUERY_ALL_PACKAGES"
            boolean r3 = r4.equals(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a java.lang.Throwable -> L3c
            if (r3 == 0) goto L37
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a java.lang.Throwable -> L3c
            com.qq.e.comm.plugin.util.z0.f46765a = r5     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a java.lang.Throwable -> L3c
            goto L3a
        L37:
            int r0 = r0 + 1
            goto L26
        L3a:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L3c
            goto L3f
        L3c:
            r5 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L3c
            throw r5
        L3f:
            java.lang.Boolean r5 = com.qq.e.comm.plugin.util.z0.f46765a
            boolean r5 = r5.booleanValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.z0.c(android.content.Context):boolean");
    }

    public static boolean b(Context context) {
        if (context != null) {
            return Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30 || c(context);
        }
        return true;
    }

    public static void a(Context context) {
        if (context != null) {
            int i4 = context.getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT < 30 || i4 < 30) {
                return;
            }
            com.qq.e.comm.plugin.n0.v.a(1130005, null, Integer.valueOf(c(context) ? 1 : -1));
        }
    }
}
