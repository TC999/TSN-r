package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Sagittarius {
    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean a() {
        Context context;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 16) {
            return true;
        }
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        if (a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            if (i4 >= 29) {
                return Environment.isExternalStorageLegacy();
            }
            return true;
        }
        return false;
    }
}
