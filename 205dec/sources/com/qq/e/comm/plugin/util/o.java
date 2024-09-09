package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f46532a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f46533b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f46534c;

    public static long a(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return new File(context.getApplicationContext().getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).length();
        } catch (Exception e4) {
            d1.a("Get apk size encounter exception: " + e4.getMessage(), new Object[0]);
            return 0L;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Boolean bool = f46533b;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = context.getApplicationInfo().packageName;
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            try {
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
                if (resolveActivity != null && resolveActivity.activityInfo != null) {
                    Boolean valueOf = Boolean.valueOf(str.equals(resolveActivity.activityInfo.packageName));
                    f46533b = valueOf;
                    return valueOf.booleanValue();
                }
                f46533b = Boolean.FALSE;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        return (context == null || (context.getApplicationInfo().flags & 1) == 0) ? false : true;
    }

    public static boolean c() {
        Boolean bool = f46534c;
        if (bool != null) {
            return bool.booleanValue();
        }
        com.qq.e.comm.plugin.d0.a d4 = com.qq.e.comm.plugin.d0.a.d();
        Context a4 = d4.a();
        if (a4 == null) {
            return true;
        }
        Boolean valueOf = Boolean.valueOf(TextUtils.equals(a4.getApplicationContext().getPackageName(), d4.b().e()));
        f46534c = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean a() {
        if (f46532a == null) {
            try {
                f46532a = Boolean.valueOf((com.qq.e.comm.plugin.d0.a.d().a().getApplicationInfo().flags & 2) != 0);
            } catch (Exception unused) {
                f46532a = Boolean.FALSE;
            }
        }
        return f46532a.booleanValue();
    }

    public static boolean b() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("ecgpi", 1) == 1;
    }
}
