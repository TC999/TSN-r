package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.os.Build;
import android.os.Vibrator;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k2 {
    public static void a() {
        Vibrator vibrator;
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        if ((Build.VERSION.SDK_INT < 23 || a4.checkSelfPermission("android.permission.VIBRATE") == 0) && (vibrator = (Vibrator) a4.getSystemService("vibrator")) != null) {
            try {
                vibrator.vibrate(200L);
            } catch (Throwable unused) {
            }
        }
    }
}
