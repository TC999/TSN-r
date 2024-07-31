package com.p521ss.android.socialbase.downloader.p556q;

import android.content.Context;
import android.content.pm.ServiceInfo;

/* renamed from: com.ss.android.socialbase.downloader.q.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12712k {
    /* renamed from: ok */
    public static boolean m16624ok(Context context, String str, String str2) {
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
