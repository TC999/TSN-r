package com.bxkj.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import com.stub.StubApp;
import m.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: NotificationsUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class r {
    public static boolean a(Context context) {
        return NotificationManagerCompat.from(StubApp.getOrigApplicationContext(context.getApplicationContext())).areNotificationsEnabled();
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", activity.getApplicationInfo().uid);
            activity.startActivity(intent);
            return;
        }
        s.o(activity);
    }

    public static void c(FragmentActivity fragmentActivity, b.a aVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", fragmentActivity.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", fragmentActivity.getApplicationInfo().uid);
            new m.b(fragmentActivity).startActivityForResult(intent).c(aVar);
            return;
        }
        s.p(fragmentActivity, aVar);
    }
}
