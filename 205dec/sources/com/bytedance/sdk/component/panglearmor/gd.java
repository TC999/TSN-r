package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {
    public static int c(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
        }
    }

    public static boolean c(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }
}
