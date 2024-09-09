package com.bxkj.base.util;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ServiceUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class y {
    public static boolean a(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices.size() <= 0) {
            return false;
        }
        for (int i4 = 0; i4 < runningServices.size(); i4++) {
            if (runningServices.get(i4).service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
