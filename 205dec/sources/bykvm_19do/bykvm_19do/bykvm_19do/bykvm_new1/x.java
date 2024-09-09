package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

/* compiled from: TTProcessUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class x {
    private static String a(Context context) {
        int myPid = Process.myPid();
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    public static boolean b(Context context) {
        String packageName;
        try {
            packageName = context.getPackageName();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        return packageName.equalsIgnoreCase(a(context));
    }
}
