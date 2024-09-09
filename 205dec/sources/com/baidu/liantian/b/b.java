package com.baidu.liantian.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.liantian.LiantianService;
import com.baidu.liantian.ac.U;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* compiled from: AlarmUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {
    public static void a(Context context, boolean z3) {
        long currentTimeMillis;
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.baidu.action.Liantian.VIEW");
            intent.setClass(context, LiantianService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.liantian");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleWork");
            intent.putExtra("from", 6);
            PendingIntent service = PendingIntent.getService(context, 1000, intent, 134217728);
            if (z3) {
                currentTimeMillis = eVar.f12228a.getLong("npuct", 0L);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = System.currentTimeMillis() + 86400000;
                    eVar.a(currentTimeMillis);
                }
            } else {
                currentTimeMillis = ((System.currentTimeMillis() + 86400000) - 600000) + ((long) (Math.random() * 1200000.0d));
                eVar.a(currentTimeMillis);
            }
            System.currentTimeMillis();
            com.baidu.liantian.b.a();
            alarmManager.cancel(service);
            alarmManager.set(0, currentTimeMillis, service);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public static void a(Context context, int i4, boolean z3) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.baidu.action.Liantian.VIEW");
            intent.setClass(context, LiantianService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.liantian");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleWork");
            intent.putExtra("from", 2);
            PendingIntent service = PendingIntent.getService(context, 1001, intent, 134217728);
            long currentTimeMillis = System.currentTimeMillis() + (i4 != 0 ? i4 != 1 ? i4 != 2 ? 600000L : 300000L : 180000L : PolicyConfig.mServerBusyRetryBaseInternal);
            System.currentTimeMillis();
            com.baidu.liantian.b.a();
            alarmManager.cancel(service);
            if (z3) {
                return;
            }
            alarmManager.set(0, currentTimeMillis, service);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public static void a(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.baidu.action.Liantian.VIEW");
            intent.setClass(context, LiantianService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.liantian");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleUploadPidChange");
            PendingIntent service = PendingIntent.getService(context, 1002, intent, 134217728);
            long currentTimeMillis = System.currentTimeMillis() + 86400000;
            alarmManager.cancel(service);
            alarmManager.set(0, currentTimeMillis, service);
        } catch (Throwable unused) {
            e.a();
        }
    }
}
