package com.mbridge.msdk.mbdownload;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.shell.MBService;

/* compiled from: NotificationUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j {
    public static String a(int i4, String str) {
        if (i4 == 0) {
            return null;
        }
        return (i4 + "") + ":" + str;
    }

    public static PendingIntent a(Context context, String str) {
        Intent intent = new Intent(context, MBService.class);
        intent.putExtra("com.mbridge.msdk.broadcast.download.msg", str);
        return PendingIntent.getService(context, str.hashCode(), intent, 134217728);
    }

    public static void a() {
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (j4 == null || t.w(j4) < 26 || Build.VERSION.SDK_INT < 26) {
            return;
        }
        ((NotificationManager) j4.getSystemService("notification")).createNotificationChannel(new NotificationChannel("download", "\u4e0b\u8f7d\u8fdb\u5ea6", 2));
    }
}
