package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* renamed from: com.kwad.sdk.utils.aq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11024aq {
    private static String aPC = "";
    private static volatile Boolean aPD;

    /* renamed from: Mb */
    private static String m24085Mb() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    /* renamed from: Mc */
    private static String m24084Mc() {
        try {
            Object callStaticMethod = C11124s.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return callStaticMethod instanceof String ? (String) callStaticMethod : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: ct */
    private static String m24083ct(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(aPC)) {
            return aPC;
        }
        String m24085Mb = m24085Mb();
        aPC = m24085Mb;
        if (!TextUtils.isEmpty(m24085Mb)) {
            return aPC;
        }
        String m24084Mc = m24084Mc();
        aPC = m24084Mc;
        if (!TextUtils.isEmpty(m24084Mc)) {
            return aPC;
        }
        String m24083ct = m24083ct(context);
        aPC = m24083ct;
        return m24083ct;
    }

    public static boolean isInMainProcess(Context context) {
        if (aPD == null) {
            String processName = getProcessName(context);
            aPD = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return aPD.booleanValue();
    }
}
