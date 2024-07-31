package com.bxkj.student.run.app.utils;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* renamed from: com.bxkj.student.run.app.utils.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AlarmManagerUtils {

    /* renamed from: a */
    private final long f19567a = 5000;

    /* renamed from: b */
    private Context f19568b;

    /* renamed from: c */
    public AlarmManager f19569c;

    /* renamed from: d */
    public PendingIntent f19570d;

    public AlarmManagerUtils(Context aContext) {
        this.f19568b = aContext;
        this.f19569c = (AlarmManager) aContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent("WANG_LEI");
        intent.putExtra("msg", "赶紧起床");
        this.f19570d = PendingIntent.getBroadcast(this.f19568b, 0, intent, 0);
    }

    /* renamed from: a */
    public void m39674a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f19569c;
        if (alarmManager == null || (pendingIntent = this.f19570d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m39673b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            this.f19569c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f19570d);
        } else if (i >= 19) {
            this.f19569c.setExact(0, System.currentTimeMillis() + 5000, this.f19570d);
        } else {
            this.f19569c.set(0, System.currentTimeMillis() + 5000, this.f19570d);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public void m39672c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            this.f19569c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f19570d);
        } else if (i >= 19) {
            this.f19569c.setExact(0, System.currentTimeMillis() + 5000, this.f19570d);
        } else {
            this.f19569c.set(0, System.currentTimeMillis() + 5000, this.f19570d);
        }
    }
}
