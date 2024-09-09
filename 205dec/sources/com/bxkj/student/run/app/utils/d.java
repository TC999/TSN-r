package com.bxkj.student.run.app.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AlarmTimer.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class d {
    public static void a(Context context, String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    public static void b(Context context, long firstTime, long cycTime, String action, int AlarmManagerType) {
        Intent intent = new Intent();
        intent.setAction(action);
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(AlarmManagerType, firstTime, cycTime, PendingIntent.getBroadcast(context, 0, intent, 0));
    }
}
