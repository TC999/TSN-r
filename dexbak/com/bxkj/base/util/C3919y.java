package com.bxkj.base.util;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* compiled from: ServiceUtils.java */
/* renamed from: com.bxkj.base.util.y */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3919y {
    /* renamed from: a */
    public static boolean m44006a(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
        if (runningServices.size() <= 0) {
            return false;
        }
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
