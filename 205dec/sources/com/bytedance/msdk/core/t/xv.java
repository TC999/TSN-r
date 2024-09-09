package com.bytedance.msdk.core.t;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static int c(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable th) {
                th.printStackTrace();
                return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
            }
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i4);
        }
    }
}
