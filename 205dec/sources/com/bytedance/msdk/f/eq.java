package com.bytedance.msdk.f;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class eq {

    /* renamed from: c  reason: collision with root package name */
    private static String f28312c;

    public static boolean c(Context context) {
        String packageName;
        try {
            packageName = context.getPackageName();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        return packageName.equalsIgnoreCase(w(context));
    }

    public static String w(Context context) {
        if (!TextUtils.isEmpty(f28312c)) {
            return f28312c;
        }
        String c4 = c();
        f28312c = c4;
        if (!TextUtils.isEmpty(c4)) {
            return f28312c;
        }
        String w3 = w();
        f28312c = w3;
        if (!TextUtils.isEmpty(w3)) {
            return f28312c;
        }
        String xv = xv(context);
        f28312c = xv;
        return xv;
    }

    private static String xv(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    private static String c() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static String w() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
