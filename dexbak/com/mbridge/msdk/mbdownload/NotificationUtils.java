package com.mbridge.msdk.mbdownload;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.shell.MBService;

/* renamed from: com.mbridge.msdk.mbdownload.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class NotificationUtils {
    /* renamed from: a */
    public static String m21589a(int i, String str) {
        if (i == 0) {
            return null;
        }
        return (i + "") + ":" + str;
    }

    /* renamed from: a */
    public static PendingIntent m21588a(Context context, String str) {
        Intent intent = new Intent(context, MBService.class);
        intent.putExtra("com.mbridge.msdk.broadcast.download.msg", str);
        return PendingIntent.getService(context, str.hashCode(), intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    /* renamed from: a */
    public static void m21590a() {
        Context m22861j = MBSDKContext.m22865f().m22861j();
        if (m22861j == null || SameDiTool.m21767w(m22861j) < 26 || Build.VERSION.SDK_INT < 26) {
            return;
        }
        ((NotificationManager) m22861j.getSystemService("notification")).createNotificationChannel(new NotificationChannel("download", "下载进度", 2));
    }
}
