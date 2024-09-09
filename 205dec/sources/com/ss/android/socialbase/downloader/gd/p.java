package com.ss.android.socialbase.downloader.gd;

import android.content.Context;
import android.content.pm.ServiceInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class p {
    public static boolean c(Context context, String str, String str2) {
        ServiceInfo[] serviceInfoArr;
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
