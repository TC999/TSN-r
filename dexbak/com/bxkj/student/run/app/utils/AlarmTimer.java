package com.bxkj.student.run.app.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

/* renamed from: com.bxkj.student.run.app.utils.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AlarmTimer {
    /* renamed from: a */
    public static void m39671a(Context context, String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    /* renamed from: b */
    public static void m39670b(Context context, long firstTime, long cycTime, String action, int AlarmManagerType) {
        Intent intent = new Intent();
        intent.setAction(action);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(AlarmManagerType, firstTime, cycTime, PendingIntent.getBroadcast(context, 0, intent, 0));
    }
}
