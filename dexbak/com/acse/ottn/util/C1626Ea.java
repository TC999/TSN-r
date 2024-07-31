package com.acse.ottn.util;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: com.acse.ottn.util.Ea */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1626Ea {
    /* renamed from: a */
    public static boolean m56272a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(200)) {
            if (TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }
}
