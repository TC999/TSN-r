package com.acse.ottn.util;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Ea {
    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(200)) {
            if (TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }
}
