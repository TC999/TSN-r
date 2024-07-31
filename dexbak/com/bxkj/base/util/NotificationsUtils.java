package com.bxkj.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import com.stub.StubApp;
import p618m.StartActivityForResult;

/* renamed from: com.bxkj.base.util.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NotificationsUtils {
    /* renamed from: a */
    public static boolean m44051a(Context context) {
        return NotificationManagerCompat.from(StubApp.getOrigApplicationContext(context.getApplicationContext())).areNotificationsEnabled();
    }

    /* renamed from: b */
    public static void m44050b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", activity.getApplicationInfo().uid);
            activity.startActivity(intent);
            return;
        }
        C3912s.m44034o(activity);
    }

    /* renamed from: c */
    public static void m44049c(FragmentActivity fragmentActivity, StartActivityForResult.InterfaceC15293a interfaceC15293a) {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", fragmentActivity.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", fragmentActivity.getApplicationInfo().uid);
            new StartActivityForResult(fragmentActivity).startActivityForResult(intent).m3460c(interfaceC15293a);
            return;
        }
        C3912s.m44033p(fragmentActivity, interfaceC15293a);
    }
}
