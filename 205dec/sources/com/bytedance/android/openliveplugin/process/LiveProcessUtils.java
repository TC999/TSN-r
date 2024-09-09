package com.bytedance.android.openliveplugin.process;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LiveProcessUtils {
    private static String currentProcessName;

    public static String getCurrentProcessName(Context context) {
        if (TextUtils.isEmpty(currentProcessName)) {
            String currentProcessNameByApplication = getCurrentProcessNameByApplication();
            currentProcessName = currentProcessNameByApplication;
            if (TextUtils.isEmpty(currentProcessNameByApplication)) {
                String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
                currentProcessName = currentProcessNameByActivityThread;
                if (TextUtils.isEmpty(currentProcessNameByActivityThread)) {
                    String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
                    currentProcessName = currentProcessNameByActivityManager;
                    return currentProcessNameByActivityManager;
                }
                return currentProcessName;
            }
            return currentProcessName;
        }
        return currentProcessName;
    }

    private static String getCurrentProcessNameByActivityManager(Context context) {
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

    private static String getCurrentProcessNameByActivityThread() {
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

    private static String getCurrentProcessNameByApplication() {
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

    public static Boolean inLiveProcess(Context context) {
        return (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) ? Boolean.FALSE : Boolean.valueOf(getCurrentProcessName(context).endsWith(":bytelive"));
    }

    public static boolean isMainProcess(Context context) {
        if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            return false;
        }
        return TextUtils.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), getCurrentProcessName(context));
    }
}
